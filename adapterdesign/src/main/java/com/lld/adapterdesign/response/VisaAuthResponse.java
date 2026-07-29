package com.lld.adapterdesign.response;

public record VisaAuthResponse(
        String responseCode,
        String authorizationCode,
        String payload
) {
}
