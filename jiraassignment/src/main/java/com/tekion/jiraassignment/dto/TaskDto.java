package com.tekion.jiraassignment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {

    private String id;
    private String taskId;
    private String title;
    private String description;
    private String taskType;
    private String taskStatus;
    private String reporter;
    private String assignee;
    private String priority;
    private LocalDate dueDate;
    private List<String> subTaskId;


}


