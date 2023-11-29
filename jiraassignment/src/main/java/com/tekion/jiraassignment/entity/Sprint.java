package com.tekion.jiraassignment.entity;
import com.tekion.jiraassignment.dto.SprintDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "sprint")
public class Sprint {

  @Id
   private String id;

   private String sprintId;
   private String name;
   private String goal;
   private LocalDate startTime;
   private LocalDate endTime;
   private List<String> taskIds;
   private LocalDate createdAt;
   private LocalDate lastModified;

    public  Sprint( SprintDto dto)
   {
        this.sprintId = dto.getSprintId();
        this.name = dto.getName();
        this.goal = dto.getGoal();
        this.startTime = dto.getStartTime();
        this.endTime = dto.getEndTime();
        this.taskIds = dto.getTaskId();
        this.createdAt = LocalDate.now();
        this.lastModified = LocalDate.now();
   }




}