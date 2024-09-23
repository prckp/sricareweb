package com.sricare.telco.handler;

import java.util.Map;

public record ErrorResponse(
        Map<String, String> errors
) {

}
