package com.lld.flyweightdesign.dto;

import com.lld.flyweightdesign.model.Card;

public record CardResponse(
        String maskedPan,
        String network,
        String cardholderName,
        String expiry,
        String logoUrl,
        boolean expired
) {
    public static CardResponse from(Card card) {
        return new CardResponse(
                card.maskedPan(),
                card.networkName(),
                card.getCardHolderName(),
                card.getExpiry().toString(),
                card.logoUrl(),
                card.isExpired()
        );
    }
}
