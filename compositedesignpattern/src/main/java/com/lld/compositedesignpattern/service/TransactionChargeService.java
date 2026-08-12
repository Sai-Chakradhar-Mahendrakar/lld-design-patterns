package com.lld.compositedesignpattern.service;

import com.lld.compositedesignpattern.component.Charge;
import com.lld.compositedesignpattern.component.composite.ChargeBundle;
import com.lld.compositedesignpattern.component.leaf.PercentageCharge;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TransactionChargeService {
    public Charge buildInternationalTransactionCharge(BigDecimal transactionAmount) {
        Charge forexMarkup = new PercentageCharge(
                transactionAmount,
                BigDecimal.valueOf(3.5),
                "Forex Markup"
        );
        Charge gst = new PercentageCharge(
                transactionAmount,
                BigDecimal.valueOf(18),
                "GST"
        );
        Charge flatSwitchFee = new PercentageCharge(
                transactionAmount,
                BigDecimal.valueOf(2),
                "Flat Switch Fee"
        );

        ChargeBundle bundle = new ChargeBundle("International Transaction Charges");
        bundle.add(forexMarkup).add(gst).add(flatSwitchFee);

        ChargeBundle taxBundle = new ChargeBundle("Tax Charges");
        taxBundle.add(gst);

        return bundle;
    }
}
