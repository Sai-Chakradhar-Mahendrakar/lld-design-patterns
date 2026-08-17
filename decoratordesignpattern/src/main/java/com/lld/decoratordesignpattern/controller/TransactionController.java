package com.lld.decoratordesignpattern.controller;

import com.lld.decoratordesignpattern.model.TransactionRequest;
import com.lld.decoratordesignpattern.model.TransactionResult;
import com.lld.decoratordesignpattern.processor.CardTransactionProcessor;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {
    private final CardTransactionProcessor processor;

    public TransactionController(CardTransactionProcessor processor) {
        this.processor = processor;
    }

    @PostMapping
    public ResponseEntity<TransactionResult> process(@RequestBody TransactionRequest request) {
        TransactionResult transactionResult = processor.process(request);
        return ResponseEntity.ok(transactionResult);
    }
}
