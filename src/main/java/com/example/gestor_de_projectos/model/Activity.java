package com.example.gestor_de_projectos.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "activities")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @ManyToOne
    @JoinColumn (name = "phase_id")
    private Phase phase;
    private String name;
    private LocalDate start;
    private LocalDate end;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User responsible;
    private String cell;
    private String observation;
    private Float percent;

    @OneToOne
    @JoinColumn (name = "activity_id")
    private Activity dependency;
}
