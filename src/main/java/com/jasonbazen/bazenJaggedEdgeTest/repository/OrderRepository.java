package com.jasonbazen.bazenJaggedEdgeTest.repository;

import com.jasonbazen.bazenJaggedEdgeTest.entity.OrderEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<OrderEntity, Long> {

    OrderEntity findOneByOrderID(String orderId);

    boolean existsByOrderID(String orderId);

}
