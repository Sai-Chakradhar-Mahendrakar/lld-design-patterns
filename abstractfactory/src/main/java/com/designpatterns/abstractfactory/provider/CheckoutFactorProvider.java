package com.designpatterns.abstractfactory.provider;

import com.designpatterns.abstractfactory.factory.RegionalCheckoutFactory;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CheckoutFactorProvider {
    private final Map<String, RegionalCheckoutFactory> factories;

    public CheckoutFactorProvider(Map<String, RegionalCheckoutFactory> factories) {
        this.factories = factories;
    }

    public RegionalCheckoutFactory getFactory(String region) {
        return factories.get(region);
    }
}
