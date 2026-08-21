package com.lld.flyweightdesign.factory;

import com.lld.flyweightdesign.flyweight.CardNetworkFlyweight;
import com.lld.flyweightdesign.flyweight.impl.CardNetworkProperties;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class CardNetworkFlyweightFactory {
    private final Map<String, CardNetworkFlyweight> pool = new ConcurrentHashMap<>();

    public CardNetworkFlyweightFactory() {
        register(new CardNetworkProperties(
                "VISA",
                "^4[0-9]{12}(?:[0-9]{3})?$",
                "^4",
                3,
                "/logos/visa.svg",
                4));

        register(new CardNetworkProperties(
                "MASTERCARD",
                "^5[1-5][0-9]{14}$",
                "^5[1-5]",
                3,
                "/logos/mastercard.svg",
                4));

        register(new CardNetworkProperties(
                "RUPAY",
                "^6[0-9]{15}$",
                "^6",
                3,
                "/logos/rupay.svg",
                4));

        register(new CardNetworkProperties(
                "AMEX",
                "^3[47][0-9]{13}$",
                "^3[47]",
                4,
                "/logos/amex.svg",
                5));
    }

    private void register(CardNetworkProperties cardNetworkProperties) {
        pool.put(cardNetworkProperties.getNetworkName(), cardNetworkProperties);
    }

    public CardNetworkFlyweight getCardNetworkFlyweight(String networkName) {
        CardNetworkFlyweight flyweight = pool.get(networkName.toUpperCase());
        if (flyweight == null) {
            throw new IllegalArgumentException("Card network not supported: " + networkName);
        }
        return flyweight;
    }

    public Optional<CardNetworkFlyweight> detectFromCardNumber(String cardNumber) {
        if (cardNumber == null) {
            return Optional.empty();
        }
        String stripped = cardNumber.replaceAll("[\\s-]", "");
        return pool.values().stream()
                .filter(flyweight -> flyweight.getBinPattern().matcher(stripped).find())
                .findFirst();
    }

    public int poolSize() {
        return pool.size();
    }
}
