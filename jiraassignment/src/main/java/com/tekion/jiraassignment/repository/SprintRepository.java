package com.tekion.jiraassignment.repository;

import com.tekion.jiraassignment.dto.SprintDto;
import com.tekion.jiraassignment.entity.Sprint;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SprintRepository extends MongoRepository<Sprint, String> {

    void deleteBySprintId( String sprintId);

}
