package com.tekion.jiraassignment.entity;
import com.tekion.jiraassignment.Enums.TaskStatus;
import com.tekion.jiraassignment.Enums.TaskType;
import com.tekion.jiraassignment.dto.TaskDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "task")
public class Task {

    @Id
    private String id;
    private String taskId;
    private String title;
    private String description;
    private TaskType taskType;
    private TaskStatus status;
    private String reporter;
    private String assignee;
    private String priority;
    private LocalDate dueDate;
    private LocalDate createdAt;
    private LocalDate lastModified;
    private String sprintId;
    //private List<Task> subTaskId;



    public Task(TaskDto taskDto)
    {
        this.taskId = taskDto.getTaskId();
        this.title = taskDto.getTitle();
        this.description = taskDto.getDescription();
        this.taskType = TaskType.valueOf(taskDto.getTaskType().toUpperCase());
        this.status = TaskStatus.valueOf(taskDto.getTaskStatus().toUpperCase());
        this.reporter = taskDto.getReporter();
        this.assignee = taskDto.getAssignee();
        this.priority = taskDto.getPriority();
        this.dueDate = taskDto.getDueDate();
        this.createdAt = LocalDate.now();
        this.lastModified = LocalDate.now();
        //this.subTaskId = taskDto.getSubTaskId();

    }
}