package com.lld.bridgedesignpattern.gateway.impl;

import com.lld.bridgedesignpattern.gateway.PaymentNetworkGateway;
import com.lld.bridgedesignpattern.model.AuthorizationResult;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

@Component("MASTERCARD")
public class MastercardGateway implements PaymentNetworkGateway {
    @Override
    public AuthorizationResult authorize(String cardInstrumentId, BigDecimal amount) {
        return new AuthorizationResult(false, "MASTERCARD-" + UUID.randomUUID(), amount);
    }

    @Override
    public void reverse(String transactionId) {
    }
}
