package com.tekion.jiraassignment.service.serviceImpl;

import com.tekion.jiraassignment.Enums.TaskStatus;
import com.tekion.jiraassignment.dto.TaskDto;
import com.tekion.jiraassignment.entity.Task;
import com.tekion.jiraassignment.entity.TaskStatusSet;
import com.tekion.jiraassignment.repository.SprintRepository;
import com.tekion.jiraassignment.repository.TaskRepository;
import com.tekion.jiraassignment.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    SprintRepository sprintRepository;
    @Autowired
    TaskRepository taskRepository;

    @Override
    public Task createTask(TaskDto taskDto) {
        Task task = new Task(taskDto);
        return taskRepository.save(task);
    }

    @Override
    public List<Task> getDelayedTasks() {
        LocalDate currentDate = LocalDate.now();

        List<Task> allTasks = taskRepository.findByDueDateBefore(currentDate);

        return allTasks.stream().filter(task -> task.getStatus() != TaskStatus.DONE).collect(Collectors.toList());
    }

    @Override
    public void removeTask(String taskId) {
        taskRepository.deleteById(taskId);
    }

    @Override
    public Task findById(String taskId) {
        return taskRepository.findById(taskId).orElseThrow(() -> new RuntimeException("Task not found"));
    }



    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public List<Task> getAllTaskByStatus(String taskStatus) {
        return taskRepository.findByStatus(TaskStatus.valueOf(taskStatus.toUpperCase()));
    }

    @Override
    public Task changeTaskStatus(String taskId, TaskStatus newStatus) {
        Task task = taskRepository.findById(taskId)
                                  .orElseThrow(()-> new RuntimeException("Task not found with id: " + taskId));

        if(!isValidStatusTransition(task.getStatus(),newStatus)){
            throw new RuntimeException("Invalid status transition for task: " + taskId);
        }
        task.setStatus(newStatus);
        return taskRepository.save(task);
    }

    public boolean isValidStatusTransition(TaskStatus currentStatus, TaskStatus newStatus){
        return switch (currentStatus) {
            case TO_DO -> newStatus == TaskStatus.DEV_IN_PROGRESS;
            case DEV_IN_PROGRESS -> newStatus == TaskStatus.DONE || newStatus == TaskStatus.TO_DO;
            default -> false;
        };
    }
}
