package com.example.gestor_de_projectos.services;

import com.example.gestor_de_projectos.model.Phase;
import com.example.gestor_de_projectos.model.PhaseRequest;

import java.util.List;

public interface PhaseService {

    Phase create(PhaseRequest phase);
    Phase update(PhaseRequest phase, Long id);
    Phase findById(Long id);
    List<Phase> findAll();
}
