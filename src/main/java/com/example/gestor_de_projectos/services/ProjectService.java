package com.example.gestor_de_projectos.services;

import com.example.gestor_de_projectos.model.Project;
import com.example.gestor_de_projectos.model.ProjectRequest;

import java.util.List;

public interface ProjectService {


    Project create(ProjectRequest project);
    Project update(ProjectRequest project, Long id);
    Project findById(Long id);
    List<Project> findAll();


}
