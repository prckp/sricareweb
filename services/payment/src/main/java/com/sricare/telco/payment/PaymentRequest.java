package com.sricare.telco.payment;

import java.math.BigDecimal;

public record PaymentRequest(
        Integer id,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Integer activationId,
        String activationReference,
        Customer customer
) {
}
