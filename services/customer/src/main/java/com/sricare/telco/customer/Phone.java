package com.sricare.telco.customer;

import lombok.*;
import org.springframework.validation.annotation.Validated;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Validated
public class Phone {
    private String registeredCountry;
    private String phoneNumber;
    private String code;
}
