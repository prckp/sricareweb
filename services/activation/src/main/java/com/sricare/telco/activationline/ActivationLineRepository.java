package com.sricare.telco.activationline;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;

public interface ActivationLineRepository extends JpaRepository<ActivationLine, Integer> {

    List<ActivationLine> findAllByActivationId(Integer activationId);

}
