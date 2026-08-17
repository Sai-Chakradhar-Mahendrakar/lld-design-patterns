package com.lld.decoratordesignpattern.model;

import java.math.BigDecimal;

public record TransactionRequest(
        String cardId,
        BigDecimal amount,
        String currency,
        String merchantId
) {
}
