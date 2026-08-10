package com.lld.bridgedesignpattern.gateway.impl;

import com.lld.bridgedesignpattern.gateway.PaymentNetworkGateway;
import com.lld.bridgedesignpattern.model.AuthorizationResult;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

@Component("VISA")
public class VisaGateway implements PaymentNetworkGateway {
    @Override
    public AuthorizationResult authorize(String cardInstrumentId, BigDecimal amount) {
        return new AuthorizationResult(true, "VISA-" + UUID.randomUUID(), amount);
    }

    @Override
    public void reverse(String transactionId) {
    }
}
