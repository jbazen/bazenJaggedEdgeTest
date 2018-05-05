package com.jasonbazen.bazenJaggedEdgeTest.service;

public interface BitMexService {

    String getCurrentBidPrice(String symbol);

    String streamCurrentBidPrice(String symbol);

    String stopStreamCurrentBidPrice();

    String submitMarketOrder(String symbol);

    String monitorMarketOrder(String symbol);

    String submitAndMonitorMarketOrder(String symbol);

}
