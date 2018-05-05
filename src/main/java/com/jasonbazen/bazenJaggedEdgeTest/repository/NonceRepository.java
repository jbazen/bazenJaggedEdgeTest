package com.jasonbazen.bazenJaggedEdgeTest.repository;

import com.jasonbazen.bazenJaggedEdgeTest.entity.NonceEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NonceRepository extends CrudRepository<NonceEntity, Long> {

    List<NonceEntity> findAll();

}
