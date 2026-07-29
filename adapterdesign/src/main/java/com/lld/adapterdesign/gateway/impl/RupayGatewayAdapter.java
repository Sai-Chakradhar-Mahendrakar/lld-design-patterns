package com.lld.adapterdesign.gateway.impl;

import com.lld.adapterdesign.client.RupayClient;
import com.lld.adapterdesign.gateway.CardNetworkGateway;
import com.lld.adapterdesign.response.AuthorizationResult;
import com.lld.adapterdesign.request.CardAuthRequest;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("RUPAY")
public class RupayGatewayAdapter implements CardNetworkGateway {
    private final RupayClient rupayClient;

    public RupayGatewayAdapter(RupayClient rupayClient) {
        this.rupayClient = rupayClient;
    }

    @Override
    public AuthorizationResult authorize(CardAuthRequest request) {
        Map<String, Object> isoMessage = Map.of(
                "pan", request.cardNumber(),
                "amount", request.amount().toString()
        );
        Map<String, Object> response = rupayClient.processTransaction(isoMessage);
        boolean approved = "00".equals(response.get("field12"));
        return new AuthorizationResult(
                approved,
                (String) response.get("field34"),
                response.get("raw").toString()
        );
    }
}
