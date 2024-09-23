package com.sricare.telco.activationline;

public record ActivationLineRequest(
        Integer id,
        Integer activationId,
        Integer productId
) {
}
