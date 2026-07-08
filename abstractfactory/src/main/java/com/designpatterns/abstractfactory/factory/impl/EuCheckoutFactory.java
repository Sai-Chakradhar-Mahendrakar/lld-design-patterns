package com.designpatterns.abstractfactory.factory.impl;

import com.designpatterns.abstractfactory.factory.RegionalCheckoutFactory;
import com.designpatterns.abstractfactory.service.PaymentGateway;
import com.designpatterns.abstractfactory.service.ShippingCalculator;
import com.designpatterns.abstractfactory.service.TaxCalculator;
import com.designpatterns.abstractfactory.service.impl.eu.EuPaymentGateway;
import com.designpatterns.abstractfactory.service.impl.eu.EuShippingCalculator;
import com.designpatterns.abstractfactory.service.impl.eu.EuTaxCalculator;
import org.springframework.stereotype.Component;

@Component("EU")
public class EuCheckoutFactory implements RegionalCheckoutFactory {
    @Override
    public PaymentGateway calculatePaymentGateway() {
        return new EuPaymentGateway();
    }

    @Override
    public ShippingCalculator calculateShippingCalculator() {
        return new EuShippingCalculator();
    }

    @Override
    public TaxCalculator calculateTaxCalculator() {
        return new EuTaxCalculator();
    }
}
