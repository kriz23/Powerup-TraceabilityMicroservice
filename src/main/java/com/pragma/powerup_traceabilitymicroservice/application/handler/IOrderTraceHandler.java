package com.pragma.powerup_traceabilitymicroservice.application.handler;

import com.pragma.powerup_traceabilitymicroservice.application.dto.request.OrderTraceRequestDto;
import com.pragma.powerup_traceabilitymicroservice.application.dto.request.OrderTraceUpdateRequestDto;
import com.pragma.powerup_traceabilitymicroservice.application.dto.response.OrderTraceResponseDto;

import java.time.Duration;
import java.util.List;

public interface IOrderTraceHandler {
    void createOrderTrace(OrderTraceRequestDto orderTraceRequestDto);
    void updateOrderTrace(OrderTraceUpdateRequestDto orderTraceUpdateRequestDto);
    List<OrderTraceResponseDto> getOrderTracesByOrderId(Long orderId);
    Duration getDurationByIdOrder(Long idOrder);
}
