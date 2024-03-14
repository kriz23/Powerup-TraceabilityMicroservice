package com.pragma.powerup_traceabilitymicroservice.infrastructure.input.rest;

import com.pragma.powerup_traceabilitymicroservice.application.dto.request.OrderTraceRequestDto;
import com.pragma.powerup_traceabilitymicroservice.application.dto.request.OrderTraceUpdateRequestDto;
import com.pragma.powerup_traceabilitymicroservice.application.dto.response.OrderTraceResponseDto;
import com.pragma.powerup_traceabilitymicroservice.application.handler.IOrderTraceHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Order Trace Rest Controller", description = "Rest controller for Order Trace operations")
@RestController
@RequestMapping("/api/v1/traceability")
@RequiredArgsConstructor
public class OrderTraceRestController {
    private final IOrderTraceHandler orderTraceHandler;
    
    @Operation(summary = "Create order trace")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "Restaurant created", content = @Content)})
    @PostMapping("/orderTrace")
    public ResponseEntity<Void> createOrderTrace(@RequestBody OrderTraceRequestDto orderTraceRequestDto){
        orderTraceHandler.createOrderTrace(orderTraceRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
    @Operation(summary = "Update order trace")
    @ApiResponses(value = {@ApiResponse(responseCode = "204", description = "Dish updated", content = @Content)})
    @PutMapping("/orderTrace")
    public ResponseEntity<Void> updateOrderTrace(@RequestBody OrderTraceUpdateRequestDto orderTraceUpdateRequestDto){
        orderTraceHandler.updateOrderTrace(orderTraceUpdateRequestDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @Operation(summary = "Get order trace by order ID")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "All categories returned", content =
    @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation =
            OrderTraceResponseDto.class))))})
    @GetMapping("/orderTrace/{idOrder}")
    public ResponseEntity<List<OrderTraceResponseDto>> getOrderTracesByOrderId(
            @Parameter(description = "Order id") @PathVariable Long idOrder) {
        return ResponseEntity.ok(orderTraceHandler.getOrderTracesByOrderId(idOrder));
    }
}
