package com.pragma.powerup_traceabilitymicroservice.infrastructure.out.mongo.adapter;

import com.pragma.powerup_traceabilitymicroservice.domain.model.OrderTrace;
import com.pragma.powerup_traceabilitymicroservice.domain.spi.IOrderTracePersistencePort;
import com.pragma.powerup_traceabilitymicroservice.infrastructure.exception.NoDataFoundException;
import com.pragma.powerup_traceabilitymicroservice.infrastructure.out.mongo.entity.OrderTraceEntity;
import com.pragma.powerup_traceabilitymicroservice.infrastructure.out.mongo.mapper.IOrderTraceEntityMapper;
import com.pragma.powerup_traceabilitymicroservice.infrastructure.out.mongo.repository.IOrderTraceRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class OrderTraceMongoDBAdapter implements IOrderTracePersistencePort {
    private final IOrderTraceRepository orderTraceRepository;
    private final IOrderTraceEntityMapper orderTraceEntityMapper;
    @Override
    public void createOrderTrace(OrderTrace orderTrace) {
        orderTraceRepository.save(orderTraceEntityMapper.orderTraceToOrderTraceEntity(orderTrace));
    }
    
    @Override
    public OrderTrace getOrderTraceByIdOrder(Long idOrderTrace) {
        List<OrderTraceEntity> orderTraceEntityList = orderTraceRepository.findAllByIdOrder(idOrderTrace);
        if (orderTraceEntityList.isEmpty()) {
            throw new NoDataFoundException();
        }
        return orderTraceEntityMapper.orderTraceEntityToOrderTrace(orderTraceEntityList.get(orderTraceEntityList.size()-1));
    }
    
    @Override
    public List<OrderTrace> getOrderTracesByIdOrder(Long idOrderTrace) {
        List<OrderTraceEntity> orderTraceEntityList = orderTraceRepository.findAllByIdOrder(idOrderTrace);
        if (orderTraceEntityList.isEmpty()) {
            throw new NoDataFoundException();
        }
        return orderTraceEntityMapper.orderTraceEntityListToOrderTraceList(orderTraceEntityList);
    }
}
