package com.sricare.telco.kafka;


import com.sricare.telco.activation.PaymentMethod;
import com.sricare.telco.customer.CustomerResponse;
import com.sricare.telco.product.PurchaseResponse;

import java.math.BigDecimal;
import java.util.List;

public record ActivationConfirmation (
        String activationReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        CustomerResponse customer,
        List<PurchaseResponse> products

) {
}
