package com.pragma.powerup_traceabilitymicroservice.infrastructure.configuration;

import com.pragma.powerup_traceabilitymicroservice.domain.api.IOrderTraceServicePort;
import com.pragma.powerup_traceabilitymicroservice.domain.spi.IOrderTracePersistencePort;
import com.pragma.powerup_traceabilitymicroservice.domain.usecase.OrderTraceUseCase;
import com.pragma.powerup_traceabilitymicroservice.infrastructure.out.mongo.adapter.OrderTraceMongoDBAdapter;
import com.pragma.powerup_traceabilitymicroservice.infrastructure.out.mongo.mapper.IOrderTraceEntityMapper;
import com.pragma.powerup_traceabilitymicroservice.infrastructure.out.mongo.repository.IOrderTraceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final IOrderTraceRepository orderTraceRepository;
    private final IOrderTraceEntityMapper orderTraceEntityMapper;
    
    @Bean
    public IOrderTracePersistencePort orderTracePersistencePort(){
        return new OrderTraceMongoDBAdapter(orderTraceRepository, orderTraceEntityMapper);
    }
    
    @Bean
    public IOrderTraceServicePort orderTraceServicePort(){
        return new OrderTraceUseCase(orderTracePersistencePort());
    }
}