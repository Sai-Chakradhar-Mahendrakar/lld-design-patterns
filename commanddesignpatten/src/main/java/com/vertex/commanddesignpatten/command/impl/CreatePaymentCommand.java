package com.vertex.commanddesignpatten.command.impl;


import com.vertex.commanddesignpatten.command.CommandHandler;
import com.vertex.commanddesignpatten.model.CreatePaymentRequest;
import com.vertex.commanddesignpatten.model.Payment;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CreatePaymentCommand implements CommandHandler<CreatePaymentRequest, Payment> {
    @Override
    public Payment handle(CreatePaymentRequest command) {
        System.out.println(
                "Creating payment for " + command.accountId()
        );

        return new Payment(
                UUID.randomUUID().toString(),
                command.accountId(),
                command.amount()
        );
    }
}
