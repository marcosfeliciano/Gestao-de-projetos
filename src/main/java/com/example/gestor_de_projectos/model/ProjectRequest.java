package com.example.gestor_de_projectos.model;

import lombok.Data;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Data
public class ProjectRequest {

    private String name;
    private String area_app;
    private LocalDate start;
    private LocalDate end;
    private Long budget;
    private Long managerId;
    private Local location;
    private String observations;
}
