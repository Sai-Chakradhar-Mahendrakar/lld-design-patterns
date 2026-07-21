package com.lld.prototypedesign.prototype.impl;

import com.lld.prototypedesign.prototype.CardLimits;
import com.lld.prototypedesign.prototype.CardPrototype;

import java.util.ArrayList;
import java.util.List;

public class CardConfig implements CardPrototype {
    private String cardType;
    private String currency;
    private boolean contactlessEnabled;
    private CardLimits cardLimits;
    private List<String> allowedMccCategories;

    public CardConfig() {
        this.allowedMccCategories = new ArrayList<>();
    }

    public CardConfig(String cardType, String currency, boolean contactlessEnabled, CardLimits cardLimits, List<String> allowedMccCategories) {
        this.cardType = cardType;
        this.currency = currency;
        this.contactlessEnabled = contactlessEnabled;
        this.cardLimits = cardLimits;
        this.allowedMccCategories = allowedMccCategories != null ? new ArrayList<>(allowedMccCategories) : new ArrayList<>();
    }


    @Override
    public CardConfig cloneCard() {
        CardConfig copy = new CardConfig();
        copy.cardType = this.cardType;
        copy.currency = this.currency;
        copy.contactlessEnabled = this.contactlessEnabled;
        copy.cardLimits = this.cardLimits;
        copy.allowedMccCategories = this.allowedMccCategories;
        return copy;
    }

    public String getCardType() { return cardType; }
    public void setCardType(String cardType) { this.cardType = cardType; }

    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }

    public boolean isContactlessEnabled() { return contactlessEnabled; }
    public void setContactlessEnabled(boolean contactlessEnabled) { this.contactlessEnabled = contactlessEnabled; }

    public CardLimits getCardLimits() { return cardLimits; }
    public void setCardLimits(CardLimits cardLimits) { this.cardLimits = cardLimits; }

    public List<String> getAllowedMccCategories() { return allowedMccCategories; }
    public void setAllowedMccCategories(List<String> allowedMccCategories) { this.allowedMccCategories = allowedMccCategories; }

    @Override
    public String toString() {
        return "CardConfig{" +
                "cardType='" + cardType + '\'' +
                ", currency='" + currency + '\'' +
                ", contactlessEnabled=" + contactlessEnabled +
                ", limits=" + cardLimits +
                ", allowedMccCategories=" + allowedMccCategories +
                '}';
    }
}
