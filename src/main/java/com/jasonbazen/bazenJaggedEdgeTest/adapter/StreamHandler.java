package com.jasonbazen.bazenJaggedEdgeTest.adapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jasonbazen.bazenJaggedEdgeTest.pojo.OrderResponse;
import com.jasonbazen.bazenJaggedEdgeTest.pojo.QuoteResponse;
import com.jasonbazen.bazenJaggedEdgeTest.pojo.StreamOrderResponse;
import com.jasonbazen.bazenJaggedEdgeTest.pojo.StreamQuoteResponse;
import com.jasonbazen.bazenJaggedEdgeTest.service.CrudService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;

@Component
public class StreamHandler extends TextWebSocketHandler {

    private static final Logger log = LoggerFactory.getLogger(StreamHandler.class);

    private ObjectMapper objectMapper;

    private CrudService crudService;

    @Autowired
    public StreamHandler(ObjectMapper objectMapper, CrudService crudService) {
        this.objectMapper = objectMapper;
        this.crudService = crudService;
    }

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) {
        log.info("------- received client message ------");
        log.info(message.getPayload());
        log.info("--------- end client message ---------");

        StreamQuoteResponse response = new StreamQuoteResponse();

        if (message.getPayload().contains("\"symbol\":\"XBTUSD\"")) {
            try {
                response = objectMapper.readValue(message.getPayload(), StreamQuoteResponse.class);

                log.info("******* Start Task 2: WebSocket API *******");

                for (QuoteResponse quoteResponse : response.getData()) {
                    log.info(quoteResponse.toString());
                }

                log.info("******* End Task 2: WebSocket API *******");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (message.getPayload().contains("\"table\":\"order\"")) {
            StreamOrderResponse streamOrderResponse = null;

            try {
                streamOrderResponse = objectMapper.readValue(message.getPayload(), StreamOrderResponse.class);
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (message.getPayload().contains("\"action\":\"insert\"")) {
                for (OrderResponse orderResponse : streamOrderResponse.getData()) {
                    log.info("******* Start Task 8: Stream Order Updates from WebSocket API - inserting Order *******");
                    log.info(orderResponse.toString());
                    log.info("******* End Task 8: Stream Order Updates from WebSocket API - inserting Order *******");

                    crudService.insertOrder(orderResponse);
                }
            } else if (message.getPayload().contains("\"action\":\"update\"")) {
                for (OrderResponse orderResponse : streamOrderResponse.getData()) {
                    log.info("******* Start Task 8: Stream Order Updates from WebSocket API - updating Order *******");
                    log.info(orderResponse.toString());
                    log.info("******* End Task 8: Stream Order Updates from WebSocket API - updating Order *******");

                    crudService.updateOrder(orderResponse);
                }
            }
        }
    }
}
