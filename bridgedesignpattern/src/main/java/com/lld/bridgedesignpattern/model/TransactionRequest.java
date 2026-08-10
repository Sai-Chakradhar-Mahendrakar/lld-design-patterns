package com.lld.bridgedesignpattern.model;

import java.math.BigDecimal;

public record TransactionRequest(
        String cardType,
        String networkType,
        String cardInstrumentId,
        BigDecimal amount
) {
}
