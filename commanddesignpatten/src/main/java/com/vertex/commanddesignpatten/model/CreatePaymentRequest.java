package com.vertex.commanddesignpatten.model;

import com.vertex.commanddesignpatten.command.Command;

import java.math.BigDecimal;

public record CreatePaymentRequest(
        String accountId,
        BigDecimal amount
) implements Command<Payment> {
}
