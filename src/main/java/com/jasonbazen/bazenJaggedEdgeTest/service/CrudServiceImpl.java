package com.jasonbazen.bazenJaggedEdgeTest.service;

import com.jasonbazen.bazenJaggedEdgeTest.entity.NonceEntity;
import com.jasonbazen.bazenJaggedEdgeTest.entity.OrderEntity;
import com.jasonbazen.bazenJaggedEdgeTest.mapper.PojoEntityMapper;
import com.jasonbazen.bazenJaggedEdgeTest.pojo.OrderResponse;
import com.jasonbazen.bazenJaggedEdgeTest.repository.NonceRepository;
import com.jasonbazen.bazenJaggedEdgeTest.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class CrudServiceImpl implements CrudService {

    private OrderRepository orderRepository;

    private NonceRepository nonceRepository;

    private PojoEntityMapper pojoEntityMapper;

    @Autowired
    public CrudServiceImpl(OrderRepository orderRepository, NonceRepository nonceRepository, PojoEntityMapper pojoEntityMapper) {
        this.orderRepository = orderRepository;
        this.nonceRepository = nonceRepository;
        this.pojoEntityMapper = pojoEntityMapper;
    }

    @Override
    @Transactional
    public void seedNonceTable() {
        List<NonceEntity> nonceList = nonceRepository.findAll();

        if (nonceList == null || nonceList.isEmpty()) {
            NonceEntity nonceEntity = new NonceEntity();
            nonceEntity.setNonce(1000L);
            nonceRepository.save(nonceEntity);
        }
    }

    @Override
    @Transactional
    public Long getAndIncrementNonce() {
        List<NonceEntity> nonceList = nonceRepository.findAll();
        NonceEntity nonceEntity = new NonceEntity();

        if (nonceList == null || nonceList.isEmpty()) {
            nonceEntity.setNonce(50L);
        } else {
            nonceEntity = nonceList.get(0);
        }

        long nonce = nonceEntity.getNonce();

        ++nonce;

        nonceEntity.setNonce(nonce);
        nonceRepository.save(nonceEntity);

        return nonce;
    }

    @Override
    @Transactional
    public OrderResponse insertOrder(OrderResponse orderResponse) {
        boolean exists = orderRepository.existsByOrderID(orderResponse.getOrderID());

        if (!exists) {
            OrderEntity orderEntity = pojoEntityMapper.map(orderResponse, OrderEntity.class);

            orderEntity = orderRepository.save(orderEntity);
        }

        return orderResponse;
    }

    @Override
    @Transactional
    public OrderResponse updateOrder(OrderResponse orderResponse) {
        OrderEntity orderEntity = orderRepository.findOneByOrderID(orderResponse.getOrderID());

        Long id = orderEntity.getId();

        orderEntity = pojoEntityMapper.map(orderResponse, OrderEntity.class);

        orderEntity.setId(id);

        orderEntity = orderRepository.save(orderEntity);

        return orderResponse;
    }


}
