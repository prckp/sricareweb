package com.sricare.telco.activation;

import java.util.List;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/activations")
@RequiredArgsConstructor
public class ActivationController {

    private final ActivationService service;

    @PostMapping
    public ResponseEntity<Integer> createActivation(
            @RequestBody @Valid ActivationRequest request
    ) {
        return ResponseEntity.ok(service.createActivation(request));
    }

    @GetMapping
    public ResponseEntity<List<ActivationResponse>> findAll() {
        return ResponseEntity.ok(this.service.findAllActivations());
    }

    @GetMapping("/{activation-id}")
    public ResponseEntity<ActivationResponse> findById(
            @PathVariable("activation-id") Integer activationId
    ) {
        return ResponseEntity.ok(this.service.findById(activationId));
    }
}
