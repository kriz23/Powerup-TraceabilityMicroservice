package com.pragma.powerup_traceabilitymicroservice.domain.usecase;

import com.pragma.powerup_traceabilitymicroservice.domain.api.IOrderTraceServicePort;
import com.pragma.powerup_traceabilitymicroservice.domain.model.OrderTrace;
import com.pragma.powerup_traceabilitymicroservice.domain.spi.IOrderTracePersistencePort;

import java.util.List;

public class OrderTraceUseCase implements IOrderTraceServicePort {
    private final IOrderTracePersistencePort orderTracePersistencePort;
    
    public OrderTraceUseCase(IOrderTracePersistencePort orderTracePersistencePort) {
        this.orderTracePersistencePort = orderTracePersistencePort;
    }
    
    @Override
    public void createOrderTrace(OrderTrace orderTrace) {
        orderTrace.setCreatedAt(orderTrace.getUpdatedAt());
        orderTracePersistencePort.createOrderTrace(orderTrace);
    }
    
    @Override
    public void updateOrderTrace(OrderTrace orderTrace) {
        OrderTrace existingOrderTrace = orderTracePersistencePort.getOrderTraceByIdOrder(orderTrace.getIdOrder());
        OrderTrace newOrderTrace;
        if (orderTrace.getIdEmployee() != null && orderTrace.getEmployeeMail() != null){
            newOrderTrace = new OrderTrace(null, existingOrderTrace.getIdOrder(), existingOrderTrace.getIdClient(),
                                           existingOrderTrace.getClientMail(), orderTrace.getLastState(),
                                           orderTrace.getCurrentState(), orderTrace.getIdEmployee(),
                                           orderTrace.getEmployeeMail(), existingOrderTrace.getCreatedAt(),
                                           orderTrace.getUpdatedAt());
        } else {
            newOrderTrace = new OrderTrace(null, existingOrderTrace.getIdOrder(), existingOrderTrace.getIdClient(),
                                           existingOrderTrace.getClientMail(), orderTrace.getLastState(),
                                           orderTrace.getCurrentState(), existingOrderTrace.getIdEmployee(),
                                           existingOrderTrace.getEmployeeMail(), existingOrderTrace.getCreatedAt(),
                                           orderTrace.getUpdatedAt());
        }
        orderTracePersistencePort.createOrderTrace(newOrderTrace);
    }
    
    @Override
    public List<OrderTrace> getOrderTracesByIdOrder(Long idOrder) {
        return orderTracePersistencePort.getOrderTracesByIdOrder(idOrder);
    }
}
