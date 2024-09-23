package com.sricare.telco.activation;

import org.springframework.stereotype.Service;

@Service
public class ActivationMapper {


    public Activation toActivate(ActivationRequest request) {
        if (request == null) {
            return null;
        }
        return Activation.builder()
                .id(request.id())
                .reference(request.reference())
                .paymentMethod(request.paymentMethod())
                .customerId(request.customerId())
                .build();
    }

    public ActivationResponse fromActivation(Activation activation) {
        return new ActivationResponse(
                activation.getId(),
                activation.getReference(),
                activation.getTotalAmount(),
                activation.getPaymentMethod(),
                activation.getCustomerId()
        );
    }
}
