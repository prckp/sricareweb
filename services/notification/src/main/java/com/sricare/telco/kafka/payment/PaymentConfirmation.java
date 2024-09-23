package com.sricare.telco.kafka.payment;

import java.math.BigDecimal;

public record PaymentConfirmation(
        String activationReference,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        String customerFirstname,
        String customerLastname,
        String customerEmail
) {
}
