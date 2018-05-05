package com.jasonbazen.bazenJaggedEdgeTest.service;

import com.jasonbazen.bazenJaggedEdgeTest.pojo.OrderResponse;

public interface CrudService {

    void seedNonceTable();

    Long getAndIncrementNonce();

    OrderResponse insertOrder(OrderResponse orderResponse);

    OrderResponse updateOrder(OrderResponse orderResponse);

}
