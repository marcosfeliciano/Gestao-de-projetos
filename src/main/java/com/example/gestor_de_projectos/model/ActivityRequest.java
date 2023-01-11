package com.example.gestor_de_projectos.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ActivityRequest {

    private Long phaseId;
    private String name;
    private LocalDate start;
    private LocalDate end;
    private Long responsibleId;
    private String observation;
    private Float percent;
    private Long dependencyId;
    private String cell;
}
