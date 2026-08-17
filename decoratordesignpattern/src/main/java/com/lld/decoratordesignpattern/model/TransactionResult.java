package com.lld.decoratordesignpattern.model;

public record TransactionResult (
        String transactionId,
        TransactionStatus status,
        String message
){
    public enum TransactionStatus {
        APPROVED,
        DECLINED,
        FLAGGED,
    }
}
