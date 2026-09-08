package com.vertex.commanddesignpatten.command.impl;

import com.vertex.commanddesignpatten.command.PaymentCommand;

public class CancelPaymentCommand implements PaymentCommand {
    @Override
    public void execute() {
        System.out.println("Cancelling payment...");
    }
}
