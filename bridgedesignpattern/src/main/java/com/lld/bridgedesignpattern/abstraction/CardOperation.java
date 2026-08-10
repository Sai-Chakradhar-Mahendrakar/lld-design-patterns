package com.lld.bridgedesignpattern.abstraction;

import com.lld.bridgedesignpattern.gateway.PaymentNetworkGateway;
import com.lld.bridgedesignpattern.model.AuthorizationResult;

import java.math.BigDecimal;

public abstract class CardOperation {
    protected final PaymentNetworkGateway gateway;

    public CardOperation(PaymentNetworkGateway gateway) {
        this.gateway = gateway;
    }

    public abstract AuthorizationResult process(String cardInstrumentId, BigDecimal amount);
}
