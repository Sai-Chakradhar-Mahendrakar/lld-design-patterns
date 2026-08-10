package com.lld.bridgedesignpattern.gateway;

import com.lld.bridgedesignpattern.model.AuthorizationResult;

import java.math.BigDecimal;

public interface PaymentNetworkGateway {
    AuthorizationResult authorize(String cardInstrumentId, BigDecimal amount);

    void reverse(String transactionId);
}
