package com.designpatterns.abstractfactory.service.impl.in;

import com.designpatterns.abstractfactory.service.TaxCalculator;

public class InTaxCalculator implements TaxCalculator {
    @Override
    public double calculate(double amount, double distance) {
        System.out.printf("Calculating tax for %.2f over %.2f km in India%n", amount, distance);
        return amount * 0.18;
    }
}
