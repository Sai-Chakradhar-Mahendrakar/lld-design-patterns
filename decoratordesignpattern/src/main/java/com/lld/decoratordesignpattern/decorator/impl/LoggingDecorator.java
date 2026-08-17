package com.lld.decoratordesignpattern.decorator.impl;

import com.lld.decoratordesignpattern.model.TransactionRequest;
import com.lld.decoratordesignpattern.model.TransactionResult;
import com.lld.decoratordesignpattern.processor.CardTransactionProcessor;
import com.lld.decoratordesignpattern.decorator.TransactionProcessorDecorator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class LoggingDecorator extends TransactionProcessorDecorator {
    private static final Logger log = LoggerFactory.getLogger(LoggingDecorator.class);

    public LoggingDecorator(CardTransactionProcessor delegate) {
        super(delegate);
    }

    @Override
    public TransactionResult process(TransactionRequest request) {
        log.info("Processing transaction for card={} amount={} {}",
                request.cardId(), request.amount(), request.currency());
        TransactionResult result = delegate.process(request);
        log.info("Transaction {} completed with status={}",
                result.transactionId(), result.status());
        return result;
    }
}
