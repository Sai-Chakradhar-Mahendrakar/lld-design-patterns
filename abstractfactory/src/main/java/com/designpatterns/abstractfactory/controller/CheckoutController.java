package com.designpatterns.abstractfactory.controller;

import com.designpatterns.abstractfactory.factory.RegionalCheckoutFactory;
import com.designpatterns.abstractfactory.provider.CheckoutFactorProvider;
import com.designpatterns.abstractfactory.request.CheckoutRequest;
import com.designpatterns.abstractfactory.response.CheckoutResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {
    private final CheckoutFactorProvider factorProvider;

    public CheckoutController(CheckoutFactorProvider factorProvider) {
        this.factorProvider = factorProvider;
    }

    @PostMapping("/{region}")
    public CheckoutResponse checkout(@PathVariable String region, @RequestBody CheckoutRequest request) {
        RegionalCheckoutFactory factory = factorProvider.getFactory(region);
        double pay = factory.calculatePaymentGateway().calculate(request.getAmount());
        double shipping = factory.calculateShippingCalculator().calculate(request.getWeight(), request.getDistance());
        double tax = factory.calculateTaxCalculator().calculate(request.getAmount(), request.getDistance());
        double total =  pay + shipping + tax;

        return new CheckoutResponse(region, pay, shipping, tax, total);
    }
}
