package com.tekion.jiraassignment.service;

import com.tekion.jiraassignment.dto.SprintDto;
import com.tekion.jiraassignment.entity.Sprint;
import com.tekion.jiraassignment.entity.Task;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface SprintService {

    public Sprint createSprint(SprintDto sprintDto);

    public void addToSprint(String sprintId, String taskId);

    public Sprint findSprintById(String sprintId);

    public List<Sprint> findAllSprints();

    public String deleteSprint(String sprintId);



    public void removeFromSprint(String sprintId, String taskId);

    public  List<Task> getTasksBySprint(String sprintId);







}