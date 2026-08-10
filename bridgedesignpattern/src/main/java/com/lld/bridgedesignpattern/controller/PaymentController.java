package com.lld.bridgedesignpattern.controller;

import com.lld.bridgedesignpattern.model.AuthorizationResult;
import com.lld.bridgedesignpattern.model.TransactionRequest;
import com.lld.bridgedesignpattern.service.CardTransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {
    private final CardTransactionService cardTransactionService;

    public PaymentController(CardTransactionService cardTransactionService) {
        this.cardTransactionService = cardTransactionService;
    }

    @PostMapping("/make-payment")
    public ResponseEntity<AuthorizationResult> makePayment(@RequestBody TransactionRequest transactionRequest) {
        AuthorizationResult result = cardTransactionService.authorizeTransaction(transactionRequest);
        return result.approved()
                ? ResponseEntity.ok(result)
                : ResponseEntity.status(HttpStatus.PAYMENT_REQUIRED).body(result);
    }
}
