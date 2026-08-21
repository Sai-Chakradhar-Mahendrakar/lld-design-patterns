package com.lld.flyweightdesign.model;

import com.lld.flyweightdesign.flyweight.CardNetworkFlyweight;

import java.time.YearMonth;

public class Card {
    private final String cardNumber;
    private final String cardHolderName;
    private final YearMonth expiry;
    private final CardNetworkFlyweight network;

    public Card(String cardNumber, String cardHolderName, YearMonth expiry, CardNetworkFlyweight network) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.expiry = expiry;
        this.network = network;
    }

    public boolean isFormatValid() {
        return network.isValidFormat(cardNumber);
    }

    public String maskedPan() {
        return network.maskPan(cardNumber);
    }

    public int expectedCvvLength() {
        return network.getCvvLength();
    }

    public String networkName() {
        return network.getNetworkName();
    }

    public String logoUrl() {
        return network.getLogoUrl();
    }

    public boolean isExpired() {
        return YearMonth.now().isAfter(expiry);
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public YearMonth getExpiry() {
        return expiry;
    }

    @Override
    public String toString() {
        return "Card{pan=" + maskedPan() + ", network=" + networkName()
                + ", holder=" + cardHolderName + ", expiry=" + expiry + "}";
    }
}
