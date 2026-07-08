package com.designpatterns.abstractfactory.factory.impl;

import com.designpatterns.abstractfactory.factory.RegionalCheckoutFactory;
import com.designpatterns.abstractfactory.service.PaymentGateway;
import com.designpatterns.abstractfactory.service.ShippingCalculator;
import com.designpatterns.abstractfactory.service.TaxCalculator;
import com.designpatterns.abstractfactory.service.impl.in.InPaymentGateway;
import com.designpatterns.abstractfactory.service.impl.in.InShippingCalculator;
import com.designpatterns.abstractfactory.service.impl.in.InTaxCalculator;
import org.springframework.stereotype.Component;

@Component("IN")
public class InCheckoutFactory implements RegionalCheckoutFactory {
    @Override
    public PaymentGateway calculatePaymentGateway() {
        return new InPaymentGateway();
    }

    @Override
    public ShippingCalculator calculateShippingCalculator() {
        return new InShippingCalculator();
    }

    @Override
    public TaxCalculator calculateTaxCalculator() {
        return new InTaxCalculator();
    }
}
