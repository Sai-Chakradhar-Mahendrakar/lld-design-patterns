package com.lld.decoratordesignpattern.decorator.impl;

import com.lld.decoratordesignpattern.model.TransactionRequest;
import com.lld.decoratordesignpattern.model.TransactionResult;
import com.lld.decoratordesignpattern.processor.CardTransactionProcessor;
import com.lld.decoratordesignpattern.decorator.TransactionProcessorDecorator;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class RateLimitingDecorator extends TransactionProcessorDecorator {
    private final Map<String, Integer> attemptsPerCard = new ConcurrentHashMap<>();
    private static final int MAX_ATTEMPTS_PER_WINDOW = 5;

    public RateLimitingDecorator(CardTransactionProcessor delegate) {
        super(delegate);
    }

    @Override
    public TransactionResult process(TransactionRequest request) {
        int attempts = attemptsPerCard.merge(request.cardId(), 1, Integer::sum);
        if (attempts > MAX_ATTEMPTS_PER_WINDOW) {
            return new TransactionResult(
                    UUID.randomUUID().toString(),
                    TransactionResult.TransactionStatus.DECLINED,
                    "Rate limit exceeded for card"
            );
        }
        return super.process(request);
    }
}
