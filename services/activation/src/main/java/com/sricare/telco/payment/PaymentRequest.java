package com.sricare.telco.payment;

import com.sricare.telco.activation.PaymentMethod;
import com.sricare.telco.customer.CustomerResponse;

import java.math.BigDecimal;

public record PaymentRequest(
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Integer activationId,
        String activationReference,
        CustomerResponse customer
) {
}