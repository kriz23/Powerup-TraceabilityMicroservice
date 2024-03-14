package com.pragma.powerup_traceabilitymicroservice.application.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class OrderTraceUpdateRequestDto {
    private Long idOrder;
    private String lastState;
    private String currentState;
    private Long idEmployee;
    private String employeeMail;
    private LocalDateTime updatedAt;
}
