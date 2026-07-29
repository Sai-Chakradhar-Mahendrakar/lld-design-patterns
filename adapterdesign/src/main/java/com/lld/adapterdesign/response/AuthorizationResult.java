package com.lld.adapterdesign.response;

public record AuthorizationResult(
        boolean approved,
        String authCode,
        String rawResponse
) {
}
