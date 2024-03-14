package com.pragma.powerup_traceabilitymicroservice.infrastructure.out.mongo.repository;

import com.pragma.powerup_traceabilitymicroservice.infrastructure.out.mongo.entity.OrderTraceEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface IOrderTraceRepository extends MongoRepository<OrderTraceEntity, String> {
    List<OrderTraceEntity> findAllByIdOrder(Long idOrder);
}
