package com.example.gestor_de_projectos.services;

import com.example.gestor_de_projectos.model.Activity;
import com.example.gestor_de_projectos.model.User;

import java.util.List;

public interface UserService {

    User create(User user);
    User update(User user, Long id);
    User findById(Long id);
    List<User> findAll();
}
