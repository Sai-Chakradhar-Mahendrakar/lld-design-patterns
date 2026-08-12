package com.lld.compositedesignpattern.component.leaf;

import com.lld.compositedesignpattern.component.Charge;

import java.math.BigDecimal;
import java.math.RoundingMode;

public record PercentageCharge(
        BigDecimal baseAmount,
        BigDecimal percentage,
        String description
) implements Charge {
    @Override
    public BigDecimal amount() {
        return baseAmount
                .multiply(percentage)
                .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
    }
}
