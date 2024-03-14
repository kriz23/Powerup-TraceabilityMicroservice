package com.pragma.powerup_traceabilitymicroservice.application.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class OrderTraceRequestDto {
    private Long idOrder;
    private Long idClient;
    private String clientMail;
    private String currentState;
    private LocalDateTime updatedAt;
}
