package com.vertex.commanddesignpatten.controller;

import com.vertex.commanddesignpatten.command.impl.CreatePaymentCommand;
import com.vertex.commanddesignpatten.model.CreatePaymentRequest;
import com.vertex.commanddesignpatten.model.Payment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final CreatePaymentCommand createPaymentCommand;

    public PaymentController(CreatePaymentCommand createPaymentCommand) {
        this.createPaymentCommand = createPaymentCommand;
    }

    @PostMapping
    public Payment createPayment(@RequestBody CreatePaymentRequest request) {
        return createPaymentCommand.execute(request);
    }
}
