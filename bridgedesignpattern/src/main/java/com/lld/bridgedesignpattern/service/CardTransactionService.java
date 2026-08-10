package com.lld.bridgedesignpattern.service;

import com.lld.bridgedesignpattern.abstraction.CardOperation;
import com.lld.bridgedesignpattern.factory.CardOperationFactory;
import com.lld.bridgedesignpattern.model.AuthorizationResult;
import com.lld.bridgedesignpattern.model.TransactionRequest;
import org.springframework.stereotype.Service;

@Service
public class CardTransactionService {
    private final CardOperationFactory  cardOperationFactory;

    public CardTransactionService(CardOperationFactory cardOperationFactory) {
        this.cardOperationFactory = cardOperationFactory;
    }

    public AuthorizationResult authorizeTransaction(TransactionRequest req) {
        CardOperation operation = cardOperationFactory.create(req.cardType(), req.networkType());
        return operation.process(req.cardInstrumentId(), req.amount());
    }
}
