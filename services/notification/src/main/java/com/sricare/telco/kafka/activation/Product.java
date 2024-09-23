package com.sricare.telco.kafka.activation;

import java.math.BigDecimal;

public record Product(
        Integer productId,
        String name,
        String description,
        BigDecimal price
) {
}
