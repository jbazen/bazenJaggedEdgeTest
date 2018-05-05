package com.jasonbazen.bazenJaggedEdgeTest.mapper;

import com.jasonbazen.bazenJaggedEdgeTest.entity.OrderEntity;
import com.jasonbazen.bazenJaggedEdgeTest.pojo.OrderResponse;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

@Component
public class PojoEntityMapper extends ConfigurableMapper {

    protected void configure(MapperFactory factory) {
        factory.classMap(OrderResponse.class, OrderEntity.class)
                .exclude("id")
                .byDefault()
                .register();

        factory.classMap(OrderEntity.class, OrderResponse.class)
                .exclude("id")
                .byDefault()
                .register();
    }

}
