package com.example.gestor_de_projectos.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "phases")
public class Phase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "project_id")
    @ManyToOne
    private Project project;
    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User responsible;
    private Byte order;
    private String observation;
}
