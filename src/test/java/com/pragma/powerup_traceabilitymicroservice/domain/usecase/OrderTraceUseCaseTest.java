package com.pragma.powerup_traceabilitymicroservice.domain.usecase;

import com.pragma.powerup_traceabilitymicroservice.domain.model.OrderTrace;
import com.pragma.powerup_traceabilitymicroservice.domain.spi.IOrderTracePersistencePort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrderTraceUseCaseTest {
    @Mock
    private IOrderTracePersistencePort orderTracePersistencePort;
    
    @InjectMocks
    private OrderTraceUseCase orderTraceUseCase;
    
    @Test
    void createOrderTrace_callsPersistencePort(){
        orderTraceUseCase.createOrderTrace(new OrderTrace());
        verify(orderTracePersistencePort, times(1)).createOrderTrace(any(OrderTrace.class));
    }
    
    @Test
    void updateOrderTrace_preparingUpdate_callsPersistencePort(){
        OrderTrace orderTrace = new OrderTrace(null, 1L, null, null, "PENDING",
                                               "PREPARING", 3L, "employee@mail.com", null, LocalDateTime.now());
        when(orderTracePersistencePort.getOrderTraceByIdOrder(1L)).thenReturn(
                new OrderTrace("id", 1L, 4L, "client@mail.com", null, "PENDING", null, null, LocalDateTime.now(), LocalDateTime.now()));
        orderTraceUseCase.updateOrderTrace(orderTrace);
        verify(orderTracePersistencePort, times(1)).createOrderTrace(any(OrderTrace.class));
    }
    
    @Test
    void updateOrderTrace_otherUpdate_callsPersistencePort(){
        OrderTrace orderTrace = new OrderTrace(null, 1L, null, null, "PREPARING",
                                               "READY", null, null, null, LocalDateTime.now());
        when(orderTracePersistencePort.getOrderTraceByIdOrder(1L)).thenReturn(
                new OrderTrace("id", 1L, 4L, "client@mail.com", "PENDING", "PREPARING", 3L, "employee@mail.com", LocalDateTime.now(), LocalDateTime.now()));
        orderTraceUseCase.updateOrderTrace(orderTrace);
        verify(orderTracePersistencePort, times(1)).createOrderTrace(any(OrderTrace.class));
    }
    
    @Test
    void getOrderTracesByIdOrder_callsPersistencePort(){
        orderTraceUseCase.getOrderTracesByIdOrder(1L);
        verify(orderTracePersistencePort, times(1)).getOrderTracesByIdOrder(1L);
    }
}