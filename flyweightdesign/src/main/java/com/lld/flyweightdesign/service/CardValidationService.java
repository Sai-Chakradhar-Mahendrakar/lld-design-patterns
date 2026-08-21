package com.lld.flyweightdesign.service;

import com.lld.flyweightdesign.dto.CardOnboardingRequest;
import com.lld.flyweightdesign.factory.CardNetworkFlyweightFactory;
import com.lld.flyweightdesign.flyweight.CardNetworkFlyweight;
import com.lld.flyweightdesign.model.Card;
import org.springframework.stereotype.Service;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

@Service
public class CardValidationService {
    private static final DateTimeFormatter EXPIRY_FORMAT = DateTimeFormatter.ofPattern("MM/yyyy");
    private final CardNetworkFlyweightFactory flyweightFactory;

    public CardValidationService(CardNetworkFlyweightFactory flyweightFactory) {
        this.flyweightFactory = flyweightFactory;
    }

    public Card onboard(CardOnboardingRequest request) {
        CardNetworkFlyweight network = resolveNetwork(request);
        Card card = new Card(
                request.cardNumber(),
                request.cardholderName(),
                YearMonth.parse(request.expiry(), EXPIRY_FORMAT),
                network
        );

        if (!card.isFormatValid()) {
            throw new IllegalArgumentException("Card number format is invalid for network: " + card.networkName());
        }
        return card;
    }

    private CardNetworkFlyweight resolveNetwork(CardOnboardingRequest request) {
        if (request.network() != null && !request.network().isBlank()) {
            return flyweightFactory.getCardNetworkFlyweight(request.network());
        }
        return flyweightFactory.detectFromCardNumber(request.cardNumber())
                .orElseThrow(() -> new IllegalArgumentException("Unable to detect card network from card number"));
    }
}
