package com.learning.observerdesign.model;

import java.math.BigDecimal;

public record Order(
        Long id,
        String customerEmail,
        String customerPhone,
        BigDecimal amount
) {
}
