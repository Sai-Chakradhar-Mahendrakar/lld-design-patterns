package com.lld.compositedesignpattern.component.controller;

import com.lld.compositedesignpattern.component.Charge;
import com.lld.compositedesignpattern.service.TransactionChargeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Map;

@RestController
@RequestMapping("/api/charge")
public class ChargeController {
    private final TransactionChargeService  transactionChargeService;

    public ChargeController(TransactionChargeService transactionChargeService) {
        this.transactionChargeService = transactionChargeService;
    }

    @GetMapping("/international")
    public Map<String, Object> getInternationalCharges(@RequestParam BigDecimal amount) {
        Charge charge = transactionChargeService.buildInternationalTransactionCharge(amount);
        return Map.of(
                "description", charge.description(),
                "totalAmount", charge.amount()
        );
    }
}
