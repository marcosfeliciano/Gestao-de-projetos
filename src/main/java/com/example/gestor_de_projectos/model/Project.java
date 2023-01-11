package com.example.gestor_de_projectos.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Table(name = "projects")
@Getter
@Setter
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String area_app;
    private LocalDate start;
    private LocalDate end;
    private Local location;
    private Long budget;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User manager;
    private String observations;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
