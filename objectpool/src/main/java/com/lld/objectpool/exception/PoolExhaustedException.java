package com.lld.objectpool.exception;

public class PoolExhaustedException extends RuntimeException {
    public PoolExhaustedException(String message) {
        super(message);
    }
}
