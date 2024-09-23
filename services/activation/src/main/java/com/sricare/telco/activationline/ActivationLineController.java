package com.sricare.telco.activationline;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/activation-lines")
@RequiredArgsConstructor
public class ActivationLineController {

    private final ActivationLineService service;

    @GetMapping("/activation/{activation-id}")
    public ResponseEntity<List<ActivationLineResponse>> findByActivationId(
            @PathVariable("activation-id") Integer activationId
    ) {
        return ResponseEntity.ok(service.findAllByActivationId(activationId));
    }
}
