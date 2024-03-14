package com.pragma.powerup_traceabilitymicroservice.domain.spi;

import com.pragma.powerup_traceabilitymicroservice.domain.model.OrderTrace;

import java.util.List;

public interface IOrderTracePersistencePort {
    void createOrderTrace(OrderTrace orderTrace);
    OrderTrace getOrderTraceByIdOrder(Long idOrderTrace);
    List<OrderTrace> getOrderTracesByIdOrder(Long idOrderTrace);
}
