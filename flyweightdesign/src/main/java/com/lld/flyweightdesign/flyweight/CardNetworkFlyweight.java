package com.lld.flyweightdesign.flyweight;

import java.util.regex.Pattern;

public interface CardNetworkFlyweight {
    boolean isValidFormat(String cardNumber);
    String maskPan(String cardNumber);
    int getCvvLength();
    String getNetworkName();
    String getLogoUrl();
    Pattern getBinPattern();
}
