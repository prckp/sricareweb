package com.sricare.telco.customer;

public record CustomerResponse(
        String id,
        String firstname,
        String lastname,
        String email
) {

}
