package com.pragma.powerup_traceabilitymicroservice.application.handler.impl;

import com.pragma.powerup_traceabilitymicroservice.application.dto.request.OrderTraceRequestDto;
import com.pragma.powerup_traceabilitymicroservice.application.dto.request.OrderTraceUpdateRequestDto;
import com.pragma.powerup_traceabilitymicroservice.application.dto.response.OrderTraceResponseDto;
import com.pragma.powerup_traceabilitymicroservice.application.handler.IOrderTraceHandler;
import com.pragma.powerup_traceabilitymicroservice.application.mapper.IOrderTraceRequestMapper;
import com.pragma.powerup_traceabilitymicroservice.application.mapper.IOrderTraceResponseMapper;
import com.pragma.powerup_traceabilitymicroservice.application.mapper.IOrderTraceUpdateRequestMapper;
import com.pragma.powerup_traceabilitymicroservice.domain.api.IOrderTraceServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderTraceHandler implements IOrderTraceHandler {
    private final IOrderTraceServicePort orderTraceServicePort;
    private final IOrderTraceRequestMapper orderTraceRequestMapper;
    private final IOrderTraceUpdateRequestMapper orderTraceUpdateRequestMapper;
    private final IOrderTraceResponseMapper orderTraceResponseMapper;
    
    @Override
    public void createOrderTrace(OrderTraceRequestDto orderTraceRequestDto) {
        orderTraceServicePort.createOrderTrace(orderTraceRequestMapper.orderTraceRequestDtoToOrderTrace(orderTraceRequestDto));
    }
    
    @Override
    public void updateOrderTrace(OrderTraceUpdateRequestDto orderTraceUpdateRequestDto) {
        orderTraceServicePort.updateOrderTrace(orderTraceUpdateRequestMapper.orderTraceUpdateRequestDtoToOrderTrace(orderTraceUpdateRequestDto));
    }
    
    @Override
    public List<OrderTraceResponseDto> getOrderTracesByOrderId(Long orderId) {
        return orderTraceResponseMapper.orderTraceListToOrderTraceResponseDtoList(orderTraceServicePort.getOrderTracesByIdOrder(orderId));
    }
    
    @Override
    public Duration getDurationByIdOrder(Long idOrder) {
        return orderTraceServicePort.getDurationByIdOrder(idOrder);
    }
}
