package com.example.gestor_de_projectos.services;

import com.example.gestor_de_projectos.model.Activity;
import com.example.gestor_de_projectos.model.ActivityRequest;
import com.example.gestor_de_projectos.model.Phase;
import com.example.gestor_de_projectos.model.Project;
import com.example.gestor_de_projectos.repositories.ActivityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActivityServiceImpl implements ActivityService {

    private final ActivityRepository activityRepository;
    private final PhaseService phaseService;
    private final UserService userService;

    @Override
    public Activity create(ActivityRequest request) {

        Activity activity = new Activity();
        BeanUtils.copyProperties(request, activity);
        activity.setResponsible(userService.findById(request.getResponsibleId()));
        activity.setPhase(phaseService.findById(request.getPhaseId()));
        return activityRepository.saveAndFlush(activity);

    }

    @Override
    public Activity update(ActivityRequest request, Long id) {

        Activity activity = findById(id);
        BeanUtils.copyProperties(request, activity);
        activity.setResponsible(userService.findById(request.getResponsibleId()));
        activity.setPhase(phaseService.findById(request.getPhaseId()));
        return activityRepository.saveAndFlush(activity);
    }

    @Override
    public Activity findById(Long id) {
        return activityRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public List<Activity> findAll() {
        return activityRepository.findAll();
    }
}
