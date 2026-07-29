package com.lld.adapterdesign.client;

import java.util.Map;

public class RupayClient {
    public Map<String, Object> processTransaction(Map<String, Object> isoMessage) {
        return Map.of(
                "field12",
                "00",
                "field34",
                "AUTHXYZ",
                "raw",
                isoMessage.toString()
        );
    }
}
