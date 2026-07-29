package com.lld.adapterdesign.service;

import com.lld.adapterdesign.gateway.CardNetworkGateway;
import com.lld.adapterdesign.request.CardAuthRequest;
import com.lld.adapterdesign.response.AuthorizationResult;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CardAuthorizationService {
    private final Map<String, CardNetworkGateway>  gatewaysByNetwork;

    public CardAuthorizationService(Map<String, CardNetworkGateway> gatewaysByNetwork) {
        this.gatewaysByNetwork = gatewaysByNetwork;
    }

    public AuthorizationResult authorize(String network, CardAuthRequest request) {
        CardNetworkGateway gateway = gatewaysByNetwork.get(network.toUpperCase());
        if (gateway == null) {
            throw new IllegalArgumentException("Unsupported network: " + network);
        }
        return gateway.authorize(request);
    }
}
