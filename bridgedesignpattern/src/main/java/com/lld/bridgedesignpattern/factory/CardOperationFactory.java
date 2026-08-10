package com.lld.bridgedesignpattern.factory;

import com.lld.bridgedesignpattern.abstraction.CardOperation;
import com.lld.bridgedesignpattern.abstraction.impl.CreditCardOperation;
import com.lld.bridgedesignpattern.abstraction.impl.DebitCardOperation;
import com.lld.bridgedesignpattern.gateway.PaymentNetworkGateway;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class CardOperationFactory {
    private final Map<String, PaymentNetworkGateway> gateways;

    public CardOperationFactory(Map<String, PaymentNetworkGateway> gateways) {
        this.gateways = gateways;
    }

    public CardOperation create(String cardType, String networkType) {
        PaymentNetworkGateway gateway = gateways.get(networkType);
        if (gateway == null) {
            throw new IllegalArgumentException("Unsupported network type: " + networkType);
        }
        return switch (cardType.toUpperCase()) {
            case "DEBIT" -> new DebitCardOperation(gateway);
            case "CREDIT" -> new CreditCardOperation(gateway);
            default -> throw new IllegalArgumentException("Unsupported card type: " + cardType);
        };
    }
}
