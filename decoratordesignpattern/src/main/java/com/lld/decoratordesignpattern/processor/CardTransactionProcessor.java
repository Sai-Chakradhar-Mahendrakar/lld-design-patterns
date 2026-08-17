package com.lld.decoratordesignpattern.processor;

import com.lld.decoratordesignpattern.model.TransactionRequest;
import com.lld.decoratordesignpattern.model.TransactionResult;

public interface CardTransactionProcessor {
    TransactionResult process(TransactionRequest request);
}
