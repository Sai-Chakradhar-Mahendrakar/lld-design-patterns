package com.designpatterns.abstractfactory.factory;

import com.designpatterns.abstractfactory.service.PaymentGateway;
import com.designpatterns.abstractfactory.service.ShippingCalculator;
import com.designpatterns.abstractfactory.service.TaxCalculator;

public interface RegionalCheckoutFactory {
    PaymentGateway  calculatePaymentGateway();
    ShippingCalculator calculateShippingCalculator();
    TaxCalculator calculateTaxCalculator();
}
