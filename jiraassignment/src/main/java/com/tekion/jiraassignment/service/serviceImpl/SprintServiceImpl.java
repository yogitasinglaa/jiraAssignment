package com.tekion.jiraassignment.service.serviceImpl;

import com.tekion.jiraassignment.dto.SprintDto;
import com.tekion.jiraassignment.entity.Sprint;
import com.tekion.jiraassignment.entity.Task;
import com.tekion.jiraassignment.repository.SprintRepository;
import com.tekion.jiraassignment.repository.TaskRepository;
import com.tekion.jiraassignment.service.SprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SprintServiceImpl implements SprintService {

    @Autowired
    SprintRepository sprintRepository;

    @Autowired
    TaskRepository taskRepository;


    @Override
    public Sprint createSprint(SprintDto sprintDto) {
        Sprint sprint = new Sprint(sprintDto);
        return sprintRepository.save(sprint);
    }

    @Override
    public void addToSprint(String sprintId, String taskId) {
        Sprint sprint = sprintRepository.findById(sprintId).orElseThrow(() -> new RuntimeException("Sprint not found"));
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new RuntimeException("Task not found"));

        // Add the task to the Sprint
        sprint.getTaskIds().add(task.getTaskId());
        sprintRepository.save(sprint);

        // Update the Sprint ID in the Task
        task.setSprintId(sprint.getSprintId());
        taskRepository.save(task);
    }

    @Override
    public Sprint findSprintById(String sprintId) {
        return sprintRepository.findById(sprintId).orElseThrow(() -> new RuntimeException("Sprint not found"));
    }

    @Override
    public List<Sprint> findAllSprints() {
        return sprintRepository.findAll();
    }

    @Override
    public String deleteSprint(String sprintId) {
       sprintRepository.deleteBySprintId(sprintId);
       return "Sprint deleted successfully with id " + sprintId;
    }


    @Override
    public void removeFromSprint(String sprintId, String taskId) {
        Sprint sprint = sprintRepository.findById(sprintId).orElseThrow(() -> new RuntimeException("Sprint not found"));
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new RuntimeException("Task not found"));

        // Remove the task from the Sprint
        sprint.getTaskIds().remove(task.getTaskId());
        sprintRepository.save(sprint);

        // Update the Sprint ID in the Task
        task.setSprintId(null);
        taskRepository.save(task);

    }

    @Override
    public List<Task> getTasksBySprint(String sprintId) {
        sprintRepository.findById(sprintId).orElseThrow(() -> new RuntimeException("Sprint not found with id: " + sprintId));
        return taskRepository.findBySprintId(sprintId);
    }
}
