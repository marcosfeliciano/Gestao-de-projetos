package com.example.gestor_de_projectos.model;

import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
public class PhaseRequest {

    private Long project_id;
    private String name;
    private Long responsibleId;
    private Byte order;
    private String observation;
}
