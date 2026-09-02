package com.vertex.chainofresponsibility.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderRequest {
    private String productId;
    private int quantity;
    private boolean paymentCompleted;
}
