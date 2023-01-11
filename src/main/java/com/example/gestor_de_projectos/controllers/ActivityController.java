package com.example.gestor_de_projectos.controllers;


import com.example.gestor_de_projectos.model.Activity;
import com.example.gestor_de_projectos.model.ActivityRequest;
import com.example.gestor_de_projectos.services.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/activity")
@RequiredArgsConstructor
public class ActivityController {

    private final ActivityService activityService;

    @PostMapping
    public Activity create(@RequestBody ActivityRequest activity) {
        return activityService.create(activity);
    }


    @PutMapping("/{id}")
    public Activity update(@RequestBody ActivityRequest activity, @PathVariable Long id) {
        return activityService.update(activity, id);
    }

    @GetMapping("/{id}")
    public Activity findById(@PathVariable Long id) {
        return activityService.findById(id);
    }

    @GetMapping
    public List<Activity> findAll() {
        return activityService.findAll();
    }
}
