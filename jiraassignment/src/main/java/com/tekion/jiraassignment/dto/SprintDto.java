package com.tekion.jiraassignment.dto;

import com.tekion.jiraassignment.entity.Task;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "sprint")
public class SprintDto {

        private String sprintId;
        private String name;
        private String goal;
        private LocalDate startTime;
        private LocalDate endTime;
        private List<String> taskId;

}
