package com.example.gestor_de_projectos.repositories;

import com.example.gestor_de_projectos.model.Activity;
import com.example.gestor_de_projectos.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ActivityRepository extends JpaRepository<Activity, Long> {

}
