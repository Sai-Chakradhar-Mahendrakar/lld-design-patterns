package com.lld.adapterdesign.gateway.impl;

import com.lld.adapterdesign.client.VisaNetSdkClient;
import com.lld.adapterdesign.gateway.CardNetworkGateway;
import com.lld.adapterdesign.response.AuthorizationResult;
import com.lld.adapterdesign.request.CardAuthRequest;
import com.lld.adapterdesign.response.VisaAuthResponse;
import org.springframework.stereotype.Component;

@Component("VISA")
public class VisaGatewayAdaptor implements CardNetworkGateway {
    private final VisaNetSdkClient visaClient;

    public VisaGatewayAdaptor(VisaNetSdkClient visaClient) {
        this.visaClient = visaClient;
    }

    @Override
    public AuthorizationResult authorize(CardAuthRequest request) {
        long amountInCents = request.amount().movePointRight(2).longValueExact();
        VisaAuthResponse response = visaClient.doAuth(
                request.cardNumber(),
                request.expiry(),
                request.cvv(),
                amountInCents
        );
        boolean approved = "00".equals(response.responseCode());
        return new AuthorizationResult(
                approved,
                response.authorizationCode(),
                response.payload()
        );
    }
}
