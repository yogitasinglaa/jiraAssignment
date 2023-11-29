package com.tekion.jiraassignment.entity;

import com.tekion.jiraassignment.Enums.TaskStatus;
import lombok.Data;

@Data
public class TaskStatusSet {
    private TaskStatus newStatus;
}
