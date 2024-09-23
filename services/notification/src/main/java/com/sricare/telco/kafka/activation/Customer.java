package com.sricare.telco.kafka.activation;

public record Customer(
        String id,
        String firstname,
        String lastname,
        String email
) {

}
