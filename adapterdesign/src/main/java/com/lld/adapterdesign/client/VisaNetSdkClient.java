package com.lld.adapterdesign.client;

import com.lld.adapterdesign.response.VisaAuthResponse;

public class VisaNetSdkClient {
    public VisaAuthResponse doAuth(String pan, String expiryDate, String cvv, double amountInCents) {
        return new VisaAuthResponse(
                "00",
                "AUTH123",
                "{\"status\":\"approved\"}"
        );
    }
}
