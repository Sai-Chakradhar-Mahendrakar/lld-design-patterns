package com.lld.compositedesignpattern.component.composite;

import com.lld.compositedesignpattern.component.Charge;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ChargeBundle implements Charge {
    private final String description;
    private final List<Charge> charges = new ArrayList<>();

    public ChargeBundle(String description) {
        this.description = description;
    }

    public ChargeBundle add(Charge charge) {
        charges.add(charge);
        return this;
    }

    public ChargeBundle remove(Charge charge) {
        charges.remove(charge);
        return this;
    }

    public List<Charge> charges() {
        return List.copyOf(charges);
    }

    @Override
    public BigDecimal amount() {
        return charges.stream()
                .map(Charge::amount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public String description() {
        return description;
    }
}
