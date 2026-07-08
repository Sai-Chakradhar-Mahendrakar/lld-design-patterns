package com.designpatterns.abstractfactory.service.impl.us;

import com.designpatterns.abstractfactory.service.TaxCalculator;

public class UsTaxCalculator implements TaxCalculator {
    @Override
    public double calculate(double amount, double distance) {
        System.out.printf("Calculating tax for $%.2f in US%n", amount);
        return amount * 0.07;
    }
}
