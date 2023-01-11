package com.example.gestor_de_projectos.services;


import com.example.gestor_de_projectos.model.Project;
import com.example.gestor_de_projectos.model.ProjectRequest;
import com.example.gestor_de_projectos.model.User;
import com.example.gestor_de_projectos.repositories.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final UserService userService;


    @Override
    public Project create(ProjectRequest request) {

        Project project = new Project();
        BeanUtils.copyProperties(request, project);
        project.setManager(userService.findById(request.getManagerId()));
        return projectRepository.saveAndFlush(project);
    }

    @Override
    public Project update(ProjectRequest request, Long id) {

        Project project = findById(id);
        BeanUtils.copyProperties(request, project);
        project.setManager(userService.findById(request.getManagerId()));
        return projectRepository.saveAndFlush(project);
    }

    @Override
    public Project findById(Long id) {
        return projectRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public List<Project> findAll() {
        return projectRepository.findAll();
    }
}
