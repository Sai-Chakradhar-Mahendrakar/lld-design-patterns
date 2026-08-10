package com.lld.bridgedesignpattern.model;

import java.math.BigDecimal;

public record AuthorizationResult(
        boolean approved,
        String authCode,
        BigDecimal amount
) {
}
