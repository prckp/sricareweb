package com.sricare.telco.notification;

import com.sricare.telco.payment.PaymentMethod;


import java.math.BigDecimal;

public record PaymentNotificationRequest(
        String activationReference,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        String customerFirstname,
        String customerLastname,
        String customerEmail
) {
}
