package com.lld.adapterdesign.request;

import java.math.BigDecimal;

public record CardAuthRequest(
        String cardNumber,
        String expiry,
        String cvv,
        BigDecimal amount
) {
}
