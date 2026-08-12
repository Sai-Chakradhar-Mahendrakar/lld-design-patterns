package com.lld.compositedesignpattern.component.leaf;

import com.lld.compositedesignpattern.component.Charge;

import java.math.BigDecimal;

public record FlatFeeCharge(
        BigDecimal amount,
        String description
) implements Charge { }
