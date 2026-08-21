package com.lld.flyweightdesign.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record CardOnboardingRequest(
        @NotBlank
        @Pattern(regexp = "\\d{13,19}", message = "cardNumber must be 13-19 digits")
        String cardNumber,

        @NotBlank
        String cardholderName,

        @NotBlank
        @Pattern(regexp = "(0[1-9]|1[0-2])/\\d{4}", message = "expiry must be MM/yyyy")
        String expiry,

        String network
) {
}
