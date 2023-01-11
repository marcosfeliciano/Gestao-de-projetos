package com.example.gestor_de_projectos.services;


import com.example.gestor_de_projectos.model.Project;
import com.example.gestor_de_projectos.model.User;
import com.example.gestor_de_projectos.repositories.ProjectRepository;
import com.example.gestor_de_projectos.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    @Override
    public User create(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public User update(User user, Long id) {

        User user1 = findById(id);
        BeanUtils.copyProperties(user, user1);
        return userRepository.saveAndFlush(user1);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
