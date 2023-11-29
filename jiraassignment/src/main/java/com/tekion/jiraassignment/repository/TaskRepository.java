package com.tekion.jiraassignment.repository;

import com.tekion.jiraassignment.Enums.TaskStatus;
import com.tekion.jiraassignment.dto.TaskDto;
import com.tekion.jiraassignment.entity.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TaskRepository extends MongoRepository<Task, String> {

    List<Task> findByStatus(TaskStatus status);

    List<Task> findBySprintId(String sprintId);


    List<Task> findByDueDateBefore(LocalDate currentDate);

}
