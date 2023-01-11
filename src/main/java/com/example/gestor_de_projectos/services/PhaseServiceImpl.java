package com.example.gestor_de_projectos.services;

import com.example.gestor_de_projectos.model.Phase;
import com.example.gestor_de_projectos.model.PhaseRequest;
import com.example.gestor_de_projectos.model.Project;
import com.example.gestor_de_projectos.repositories.PhaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PhaseServiceImpl implements PhaseService {

    private final PhaseRepository phaseRepository;
    private final UserService userService;
    private final ProjectService projectService;


    @Override
    public Phase create(PhaseRequest request) {

        Phase phase = new Phase();
        BeanUtils.copyProperties(request, phase);
        phase.setResponsible(userService.findById(request.getResponsibleId()));
        phase.setProject(projectService.findById(request.getProject_id()));
        return phaseRepository.saveAndFlush(phase);
    }

    @Override
    public Phase update(PhaseRequest request, Long id) {

        Phase phase = findById(id);
        BeanUtils.copyProperties(request, phase);
        phase.setResponsible(userService.findById(request.getResponsibleId()));
        phase.setProject(projectService.findById(request.getProject_id()));
        return phaseRepository.saveAndFlush(phase);
    }

    @Override
    public Phase findById(Long id) {
        return phaseRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public List<Phase> findAll() {
        return phaseRepository.findAll();
    }
}
