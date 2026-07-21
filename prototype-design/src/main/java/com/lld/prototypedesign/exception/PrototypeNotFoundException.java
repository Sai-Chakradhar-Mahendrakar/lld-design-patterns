package com.lld.prototypedesign.exception;

public class PrototypeNotFoundException extends RuntimeException {
    public PrototypeNotFoundException(String cardType) {
        super("No registered card prototype found for type: " + cardType);
    }
}
