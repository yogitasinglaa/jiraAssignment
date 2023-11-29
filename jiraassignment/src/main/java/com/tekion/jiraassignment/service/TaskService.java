package com.tekion.jiraassignment.service;

import com.tekion.jiraassignment.Enums.TaskStatus;
import com.tekion.jiraassignment.dto.TaskDto;
import com.tekion.jiraassignment.entity.Task;
import com.tekion.jiraassignment.entity.TaskStatusSet;

import java.util.List;

public interface TaskService {

    public Task createTask(TaskDto taskDto);

    public List<Task> getDelayedTasks();

    public void removeTask(String taskId);

    public Task findById(String taskId);

    public List<Task> findAll();

    public  List<Task> getAllTaskByStatus(String taskStatus);

    public  Task changeTaskStatus(String taskId, TaskStatus newStatus);

    boolean isValidStatusTransition(TaskStatus currentStatus, TaskStatus newStatus);


}
