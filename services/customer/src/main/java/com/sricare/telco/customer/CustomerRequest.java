package com.sricare.telco.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record CustomerRequest(
        String id,
        @NotNull(message="Customer first name is required")
        String firstname,
        @NotNull(message="Customer last name is required")
        String lastname,
        @NotNull(message="Customer email name is required")
        @Email(message = "Customer email is not a valid email address")
        String email,
        Phone phone
) {
}
