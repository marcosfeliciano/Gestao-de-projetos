package com.example.gestor_de_projectos.repositories;

import com.example.gestor_de_projectos.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
