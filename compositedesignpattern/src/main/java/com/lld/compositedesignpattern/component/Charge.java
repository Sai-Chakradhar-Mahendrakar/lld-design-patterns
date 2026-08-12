package com.lld.compositedesignpattern.component;

import java.math.BigDecimal;

public interface Charge {
    BigDecimal amount();
    String description();
}
