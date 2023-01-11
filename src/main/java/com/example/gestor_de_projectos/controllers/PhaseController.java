package com.example.gestor_de_projectos.controllers;


import com.example.gestor_de_projectos.model.Phase;
import com.example.gestor_de_projectos.model.PhaseRequest;
import com.example.gestor_de_projectos.services.PhaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/phases")
@RequiredArgsConstructor
public class PhaseController {

    private final PhaseService phaseService;

    @PostMapping
    public Phase create(@RequestBody PhaseRequest phase) {
        return phaseService.create(phase);
    }


    @PutMapping("/{id}")
    public Phase update(@RequestBody PhaseRequest phase, @PathVariable Long id) {
        return phaseService.update(phase, id);
    }

    @GetMapping("/{id}")
    public Phase findById(@PathVariable Long id) {
        return phaseService.findById(id);
    }

    @GetMapping
    public List<Phase> findAll() {
        return phaseService.findAll();
    }
}
