package com.pragma.powerup_traceabilitymicroservice.application.mapper;

import com.pragma.powerup_traceabilitymicroservice.application.dto.request.OrderTraceUpdateRequestDto;
import com.pragma.powerup_traceabilitymicroservice.domain.model.OrderTrace;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy =
        ReportingPolicy.IGNORE)
public interface IOrderTraceUpdateRequestMapper {
    OrderTrace orderTraceUpdateRequestDtoToOrderTrace(OrderTraceUpdateRequestDto orderTraceUpdateRequestDto);
}
