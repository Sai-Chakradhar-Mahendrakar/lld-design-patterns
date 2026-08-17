package com.lld.decoratordesignpattern.decorator.impl;

import com.lld.decoratordesignpattern.model.TransactionRequest;
import com.lld.decoratordesignpattern.model.TransactionResult;
import com.lld.decoratordesignpattern.processor.CardTransactionProcessor;
import com.lld.decoratordesignpattern.decorator.TransactionProcessorDecorator;

import java.math.BigDecimal;
import java.util.UUID;

public class FraudCheckDecorator extends TransactionProcessorDecorator {
    private static final BigDecimal FLAG_THRESHOLD = new BigDecimal("100000");

    public FraudCheckDecorator(CardTransactionProcessor delegate) {
        super(delegate);
    }

    @Override
    public TransactionResult process(TransactionRequest request) {
        if (request.amount().compareTo(FLAG_THRESHOLD) > 0) {
            return new TransactionResult(
                    UUID.randomUUID().toString(),
                    TransactionResult.TransactionStatus.FLAGGED,
                    "Flagged for manual review: amount exceeds threshold"
            );
        }
        return super.process(request);
    }
}
