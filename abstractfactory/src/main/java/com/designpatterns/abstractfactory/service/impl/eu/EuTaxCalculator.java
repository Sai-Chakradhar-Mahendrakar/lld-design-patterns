package com.designpatterns.abstractfactory.service.impl.eu;

import com.designpatterns.abstractfactory.service.TaxCalculator;

public class EuTaxCalculator implements TaxCalculator {
    @Override
    public double calculate(double amount, double distance) {
        System.out.printf("Calculating tax for €%.2f in EU%n", amount);
        return amount * 0.20;
    }
}
