package com.pragma.powerup_traceabilitymicroservice.infrastructure.out.mongo.mapper;

import com.pragma.powerup_traceabilitymicroservice.domain.model.OrderTrace;
import com.pragma.powerup_traceabilitymicroservice.infrastructure.out.mongo.entity.OrderTraceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy =
        ReportingPolicy.IGNORE)
public interface IOrderTraceEntityMapper {
    OrderTraceEntity orderTraceToOrderTraceEntity(OrderTrace orderTrace);
    
    OrderTrace orderTraceEntityToOrderTrace(OrderTraceEntity orderTraceEntity);
    
    List<OrderTrace> orderTraceEntityListToOrderTraceList(List<OrderTraceEntity> orderTraceEntityList);
}
