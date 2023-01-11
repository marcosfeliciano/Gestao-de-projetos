package com.example.gestor_de_projectos.repositories;

import com.example.gestor_de_projectos.model.Phase;
import com.example.gestor_de_projectos.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhaseRepository extends JpaRepository<Phase, Long> {
}
