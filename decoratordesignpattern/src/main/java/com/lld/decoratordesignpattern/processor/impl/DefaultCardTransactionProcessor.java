package com.lld.decoratordesignpattern.processor.impl;

import com.lld.decoratordesignpattern.model.TransactionRequest;
import com.lld.decoratordesignpattern.model.TransactionResult;
import com.lld.decoratordesignpattern.processor.CardTransactionProcessor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component("baseTransactionProcessor")
public class DefaultCardTransactionProcessor implements CardTransactionProcessor {
    @Override
    public TransactionResult process (TransactionRequest request) {
        String txnId = UUID.randomUUID().toString();
        return new TransactionResult(
                txnId,
                TransactionResult.TransactionStatus.APPROVED,
                "Transaction authorized"
        );
    }
}
