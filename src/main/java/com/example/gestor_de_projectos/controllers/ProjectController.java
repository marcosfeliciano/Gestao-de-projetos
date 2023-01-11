package com.example.gestor_de_projectos.controllers;

import com.example.gestor_de_projectos.model.Project;
import com.example.gestor_de_projectos.model.ProjectRequest;
import com.example.gestor_de_projectos.services.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectController extends Project {

    private final ProjectService projectService;

    @PostMapping
    public Project create(@RequestBody ProjectRequest project) {
        return projectService.create(project);
    }


    @PutMapping("/{id}")
    public Project update(@RequestBody ProjectRequest project, @PathVariable Long id) {
        return projectService.update(project, id);
    }

    @GetMapping("/{id}")
    public Project findById(@PathVariable Long id) {
        return projectService.findById(id);
    }

    @GetMapping
    public List<Project> findAll() {
        return projectService.findAll();
    }
}
