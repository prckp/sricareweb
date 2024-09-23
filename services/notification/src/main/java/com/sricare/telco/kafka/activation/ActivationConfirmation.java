package com.sricare.telco.kafka.activation;

import com.sricare.telco.kafka.payment.PaymentMethod;

import java.math.BigDecimal;
import java.util.List;

public record ActivationConfirmation(
        String activationReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        Customer customer,
        List<Product> products

) {
}
