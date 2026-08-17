package com.lld.decoratordesignpattern.decorator;

import com.lld.decoratordesignpattern.model.TransactionRequest;
import com.lld.decoratordesignpattern.model.TransactionResult;
import com.lld.decoratordesignpattern.processor.CardTransactionProcessor;

public abstract class TransactionProcessorDecorator implements CardTransactionProcessor {
    protected final CardTransactionProcessor delegate;

    protected TransactionProcessorDecorator(CardTransactionProcessor delegate) {
        this.delegate = delegate;
    }

    @Override
    public TransactionResult process(TransactionRequest request) {
        return delegate.process(request);
    }
}
