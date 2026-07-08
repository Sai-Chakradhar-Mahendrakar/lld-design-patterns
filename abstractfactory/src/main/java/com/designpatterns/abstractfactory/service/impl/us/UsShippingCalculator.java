package com.designpatterns.abstractfactory.service.impl.us;

import com.designpatterns.abstractfactory.service.ShippingCalculator;

public class UsShippingCalculator implements ShippingCalculator {
    @Override
    public double calculate(double weight, double distance) {
        System.out.printf("Calculating shipping for %.2f kg over %.2f km in the US%n", weight, distance);
        return weight * distance * 0.05;
    }
}
