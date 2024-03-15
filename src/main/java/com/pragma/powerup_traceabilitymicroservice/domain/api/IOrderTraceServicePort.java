package com.pragma.powerup_traceabilitymicroservice.domain.api;

import com.pragma.powerup_traceabilitymicroservice.domain.model.OrderTrace;

import java.time.Duration;
import java.util.List;

public interface IOrderTraceServicePort {
    void createOrderTrace(OrderTrace orderTrace);
    void updateOrderTrace(OrderTrace orderTrace);
    List<OrderTrace> getOrderTracesByIdOrder(Long idOrder);
    Duration getDurationByIdOrder(Long idOrder);
}
