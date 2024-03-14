package com.pragma.powerup_traceabilitymicroservice.infrastructure.out.mongo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document(collection = "order_trace")
public class OrderTraceEntity {
    @MongoId
    private String id;
    private Long idOrder;
    private Long idClient;
    private String clientMail;
    private String lastState;
    private String currentState;
    private Long idEmployee;
    private String employeeMail;
    private String createdAt;
    private String updatedAt;
}
