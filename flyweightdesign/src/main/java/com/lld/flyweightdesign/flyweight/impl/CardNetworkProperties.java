package com.lld.flyweightdesign.flyweight.impl;

import com.lld.flyweightdesign.flyweight.CardNetworkFlyweight;

import java.util.regex.Pattern;

public final class CardNetworkProperties implements CardNetworkFlyweight {
    private final String networkName;
    private final Pattern cardNumberPattern;
    private final Pattern binPattern;
    private final int cvvLength;
    private final String logoUrl;
    private final int panVisibleDigits;

    public CardNetworkProperties(
            String networkName,
            String cardNumberRegex,
            String binRegex,
            int cvvLength,
            String logoUrl,
            int panVisibleDigits
    ) {
        this.networkName = networkName;
        this.cardNumberPattern = Pattern.compile(cardNumberRegex);
        this.binPattern = Pattern.compile(binRegex);
        this.cvvLength = cvvLength;
        this.logoUrl = logoUrl;
        this.panVisibleDigits = panVisibleDigits;
    }


    @Override
    public boolean isValidFormat(String cardNumber) {
        if (cardNumber == null) {
            return false;
        }
        String stripped = cardNumber.replaceAll("[\\s-]", "");
        return cardNumberPattern.matcher(stripped).matches();
    }

    @Override
    public String maskPan(String cardNumber) {
        String stripped = cardNumber.replaceAll("[\\s-]", "");
        int len = stripped.length();
        if (len <= panVisibleDigits) {
            return stripped;
        }
        String visible = stripped.substring(len-panVisibleDigits);
        return "*".repeat(len-panVisibleDigits) + visible;
    }

    @Override
    public int getCvvLength() {
        return cvvLength;
    }

    @Override
    public String getNetworkName() {
        return networkName;
    }

    @Override
    public String getLogoUrl() {
        return logoUrl;
    }

    @Override
    public Pattern getBinPattern() {
        return binPattern;
    }
}
