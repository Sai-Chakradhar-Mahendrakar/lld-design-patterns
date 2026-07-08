package com.designpatterns.abstractfactory.factory.impl;

import com.designpatterns.abstractfactory.factory.RegionalCheckoutFactory;
import com.designpatterns.abstractfactory.service.PaymentGateway;
import com.designpatterns.abstractfactory.service.ShippingCalculator;
import com.designpatterns.abstractfactory.service.TaxCalculator;
import com.designpatterns.abstractfactory.service.impl.us.UsPaymentGateway;
import com.designpatterns.abstractfactory.service.impl.us.UsShippingCalculator;
import com.designpatterns.abstractfactory.service.impl.us.UsTaxCalculator;
import org.springframework.stereotype.Component;

@Component("US")
public class UsCheckoutFactory implements RegionalCheckoutFactory {
    @Override
    public PaymentGateway calculatePaymentGateway() {
        return new UsPaymentGateway();
    }

    @Override
    public ShippingCalculator calculateShippingCalculator() {
        return new UsShippingCalculator();
    }

    @Override
    public TaxCalculator calculateTaxCalculator() {
        return new UsTaxCalculator();
    }
}
