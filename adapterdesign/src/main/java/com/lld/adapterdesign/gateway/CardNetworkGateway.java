package com.lld.adapterdesign.gateway;

import com.lld.adapterdesign.response.AuthorizationResult;
import com.lld.adapterdesign.request.CardAuthRequest;

public interface CardNetworkGateway {
    AuthorizationResult authorize(CardAuthRequest request);
}
