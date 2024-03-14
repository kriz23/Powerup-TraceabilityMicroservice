package com.pragma.powerup_traceabilitymicroservice.application.mapper;

import com.pragma.powerup_traceabilitymicroservice.application.dto.response.OrderTraceResponseDto;
import com.pragma.powerup_traceabilitymicroservice.domain.model.OrderTrace;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy =
        ReportingPolicy.IGNORE)
public interface IOrderTraceResponseMapper {
    OrderTraceResponseDto orderTraceToOrderTraceResponseDto(OrderTrace orderTrace);
    
    List<OrderTraceResponseDto> orderTraceListToOrderTraceResponseDtoList(List<OrderTrace> orderTraces);
}
