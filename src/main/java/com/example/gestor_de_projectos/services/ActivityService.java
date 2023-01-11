package com.example.gestor_de_projectos.services;

import com.example.gestor_de_projectos.model.Activity;
import com.example.gestor_de_projectos.model.ActivityRequest;

import java.util.List;

public interface ActivityService {

    Activity create(ActivityRequest activity);
    Activity update(ActivityRequest activity, Long id);
    Activity findById(Long id);
    List<Activity> findAll();
}
