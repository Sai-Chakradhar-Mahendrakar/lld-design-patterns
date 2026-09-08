package com.vertex.commanddesignpatten.model;

import java.math.BigDecimal;

public record Payment(
        String Id,
        String amountId,
        BigDecimal amount
) {
}
