package com.jasonbazen.bazenJaggedEdgeTest.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jasonbazen.bazenJaggedEdgeTest.adapter.StreamHandler;
import com.jasonbazen.bazenJaggedEdgeTest.pojo.OrderRequest;
import com.jasonbazen.bazenJaggedEdgeTest.pojo.OrderResponse;
import com.jasonbazen.bazenJaggedEdgeTest.pojo.QuoteResponse;
import org.apache.commons.codec.binary.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHttpHeaders;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.util.UriComponentsBuilder;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ExecutionException;

@Component
public class BitMexServiceImpl implements BitMexService {

    private static final Logger log = LoggerFactory.getLogger(BitMexServiceImpl.class);

    private static final String BIT_MEX_REST_API_QUOTE_URL = "https://testnet.bitmex.com/api/v1/quote";

    private static final String BIT_MEX_REST_API_ORDER_URL = "https://testnet.bitmex.com/api/v1/order";

    private static final String BIT_MEX_WEBSOCKET_API_URL = "wss://testnet.bitmex.com/realtime";

    private static final String BIT_MEX_API_KEY = "B2a5RSpbdadp6a0NiCc6kP7P";

    private static final String BIT_MEX_API_SECRET = "0tUigl4hMbAkc2FieZz2uIFQd5NeDny_irVpbKrfTo4r7oBF";

    private WebSocketSession quoteSession = null;

    private WebSocketSession orderSession = null;

    private ObjectMapper objectMapper;

    private CrudService crudService;

    private StreamHandler handler;

    @Autowired
    public BitMexServiceImpl(ObjectMapper objectMapper, CrudService crudService, StreamHandler streamHandler) {
        this.objectMapper = objectMapper;
        this.crudService = crudService;
        this.handler = streamHandler;
    }

    @Override
    public String getCurrentBidPrice(String symbol) {
        UriComponentsBuilder builder = UriComponentsBuilder
                .fromUriString(BIT_MEX_REST_API_QUOTE_URL)
                .queryParam("symbol", symbol)
                .queryParam("columns", "bidPrice")
                .queryParam("count", "1")
                .queryParam("reverse", "true");

        RestTemplate restTemplate = new RestTemplate();
        QuoteResponse[] quoteResponseList = restTemplate.getForObject(builder.toUriString(), QuoteResponse[].class);

        log.info("******* Start Task 1: REST API *******");

        for (QuoteResponse quoteResponse : quoteResponseList) {
            log.info(quoteResponse.toString());
        }

        log.info("******* End Task 1: REST API *******");

        return quoteResponseList[0].toString();
    }

    @Override
    public String streamCurrentBidPrice(String symbol) {
        UriComponentsBuilder builder = UriComponentsBuilder
                .fromUriString(BIT_MEX_WEBSOCKET_API_URL)
                .queryParam("subscribe", "quote:" + symbol);

        streamBitMex(builder, null, false);

        return "Success";
    }

    @Override
    public String stopStreamCurrentBidPrice() {
        if (quoteSession == null) {
            return null;
        }

        String unsubOp = "{\"op\": \"unsubscribe\", \"args\": [\"quote:XBTUSD\"]}";

        try {
            quoteSession.sendMessage(new TextMessage(unsubOp));
            quoteSession.close();
        } catch (Exception e) {
            return e.getMessage();
        } finally {
        }

        return "Success";
    }

    @Override
    public String submitMarketOrder(String symbol) {
        String payload = "";
        OrderRequest marketRequest = new OrderRequest();

        marketRequest.setSymbol(symbol);
        marketRequest.setSide("Buy");
        marketRequest.setOrderQty(1);
        marketRequest.setOrdType("Market");

        try {
            payload = objectMapper.writeValueAsString(marketRequest);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        HttpEntity<OrderRequest> httpRequest = new HttpEntity<>(marketRequest, getBitMexAuthHeaders("POST/api/v1/order", payload));

        RestTemplate restTemplate = new RestTemplate();
        OrderResponse marketResponse = restTemplate.postForObject(BIT_MEX_REST_API_ORDER_URL, httpRequest, OrderResponse.class);

        return marketResponse.getOrderID();
    }

    @Override
    public String monitorMarketOrder(String orderId) {
        UriComponentsBuilder builder = UriComponentsBuilder
                .fromUriString(BIT_MEX_WEBSOCKET_API_URL)
                .queryParam("subscribe", "order");

        String subOrderOp = "{\"op\": \"subscribe\", \"args\": [\"order:" + orderId + "\"]}";

        streamBitMex(builder, subOrderOp, true);

        return null;
    }

    @Override
    public String submitAndMonitorMarketOrder(String symbol) {
        monitorMarketOrder(null);

        return submitMarketOrder(symbol);
    }

    private long getApiExpires() {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();

        cal.setTime(date);
        cal.add(Calendar.MINUTE, 2);

        return cal.getTimeInMillis();
    }

    private String getEncodedApiSignature(String apiSignature) {
        String encodedApiSignature = "";

        try {
            Mac sha256Hmac = Mac.getInstance("HmacSHA256");
            SecretKeySpec secretKey = new SecretKeySpec(BIT_MEX_API_SECRET.getBytes(), "HmacSHA256");
            sha256Hmac.init(secretKey);
            encodedApiSignature = Hex.encodeHexString(sha256Hmac.doFinal(apiSignature.getBytes()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }

        return encodedApiSignature;
    }

    private HttpHeaders getBitMexAuthHeaders(String verbAndPath, String payload) {
        HttpHeaders headers = new HttpHeaders();
        String apiSignature = "";

        apiSignature = apiSignature.concat(verbAndPath).concat(String.valueOf(getApiExpires()).concat(payload));

        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("api-expires", String.valueOf(getApiExpires()));
        headers.set("api-key", BIT_MEX_API_KEY);
        headers.set("api-signature", getEncodedApiSignature(apiSignature));

        return headers;
    }

    private WebSocketHttpHeaders getBitMexAuthWebSocketHeaders(String verbAndPath, long nonce) {
        WebSocketHttpHeaders webSocketHttpHeaders = new WebSocketHttpHeaders();
        String apiSignature = "";

        apiSignature = apiSignature.concat(verbAndPath).concat(String.valueOf(nonce));
        webSocketHttpHeaders.set("api-nonce", String.valueOf(nonce));
        webSocketHttpHeaders.set("api-key", BIT_MEX_API_KEY);
        webSocketHttpHeaders.set("api-signature", getEncodedApiSignature(apiSignature));

        return webSocketHttpHeaders;
    }

    private String streamBitMex(UriComponentsBuilder builder, String op, boolean isSecure) {
        WebSocketClient client = new StandardWebSocketClient();
        long nonce = crudService.getAndIncrementNonce();

        try {
            if (isSecure) {
                if (orderSession != null && orderSession.isOpen()) {
                    orderSession.close();
                }

                WebSocketHttpHeaders headers = getBitMexAuthWebSocketHeaders("GET/realtime", nonce);

                orderSession = client.doHandshake(handler, headers, new URI(builder.toUriString())).get();
            } else {
                if (quoteSession != null && quoteSession.isOpen()) {
                    quoteSession.close();
                }

                quoteSession = client.doHandshake(handler, builder.toUriString()).get();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
