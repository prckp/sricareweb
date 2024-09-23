package com.sricare.telco.activationline;

import com.sricare.telco.activation.Activation;
import org.springframework.stereotype.Service;

@Service
public class ActivationLineMapper {
    public ActivationLine toActivationLine(ActivationLineRequest request) {
        return ActivationLine.builder()
                .id(request.activationId())
                .productId(request.productId())
                .activation(
                        Activation.builder()
                                .id(request.activationId())
                                .build()
                )
                .build();
    }

    public ActivationLineResponse toActivationLineResponse(ActivationLine activationLine) {
        return new ActivationLineResponse(
                activationLine.getId()
        );
    }
}
