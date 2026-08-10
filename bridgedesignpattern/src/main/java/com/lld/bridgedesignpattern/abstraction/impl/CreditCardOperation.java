package com.lld.bridgedesignpattern.abstraction.impl;

import com.lld.bridgedesignpattern.abstraction.CardOperation;
import com.lld.bridgedesignpattern.gateway.PaymentNetworkGateway;
import com.lld.bridgedesignpattern.model.AuthorizationResult;

import java.math.BigDecimal;

public class CreditCardOperation extends CardOperation {
    public CreditCardOperation(PaymentNetworkGateway gateway) {
        super(gateway);
    }

    @Override
    public AuthorizationResult process(String cardInstrumentId, BigDecimal amount) {
        return gateway.authorize(cardInstrumentId, amount);
    }
}
