package com.designpatterns.abstractfactory.service.impl.eu;

import com.designpatterns.abstractfactory.service.ShippingCalculator;

public class EuShippingCalculator implements ShippingCalculator {
    @Override
    public double calculate(double weight, double distance) {
        System.out.printf("Calculating shipping for %.2f kg over %.2f km in EU%n", weight, distance);
        return weight * distance * 0.05;
    }
}
