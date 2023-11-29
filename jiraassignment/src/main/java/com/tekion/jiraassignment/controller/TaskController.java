package com.tekion.jiraassignment.controller;

import com.tekion.jiraassignment.Enums.TaskStatus;
import com.tekion.jiraassignment.dto.TaskDto;
import com.tekion.jiraassignment.entity.Task;
import com.tekion.jiraassignment.entity.TaskStatusSet;
import com.tekion.jiraassignment.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    TaskService taskService;

    @PostMapping("/addtask")
    public Task createTask(@RequestBody TaskDto task) {
        return taskService.createTask(task);
    }

    @GetMapping("/alltasks")
    public List<Task> getAllTasks(){
        return taskService.findAll();
    }

    @GetMapping("/{taskId}")
    public Task findTaskById(@PathVariable String taskId){
        return taskService.findById(taskId);
    }

    @GetMapping("/delayedtasks")
    public List<Task> getDelayedTasks() {
        return taskService.getDelayedTasks();
    }

    @GetMapping("/status")
    public List<Task> getAllTasksByStatus(@RequestParam String taskStatus){
        return taskService.getAllTaskByStatus(taskStatus);
    }



    @PutMapping(value = "/{taskId}/change-status")
    public Task changeTaskStatus(@PathVariable String taskId,
                                 @RequestBody TaskStatusSet taskStatusSet){
        return taskService.changeTaskStatus(taskId,taskStatusSet.getNewStatus());
    }
}
