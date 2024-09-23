package com.sricare.telco.activationline;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ActivationLineService {

    private final ActivationLineRepository repository;
    private final ActivationLineMapper mapper;

    public Integer saveActivationLine(ActivationLineRequest request) {
        var activation = mapper.toActivationLine(request);
        return repository.save(activation).getId();
    }

    public List<ActivationLineResponse> findAllByActivationId(Integer activationId) {
        return repository.findAllByActivationId(activationId)
                .stream()
                .map(mapper::toActivationLineResponse)
                .collect(Collectors.toList());
    }
}
