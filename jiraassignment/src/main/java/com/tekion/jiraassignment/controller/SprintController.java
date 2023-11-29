package com.tekion.jiraassignment.controller;

import com.tekion.jiraassignment.dto.SprintDto;
import com.tekion.jiraassignment.entity.Sprint;
import com.tekion.jiraassignment.entity.Task;
import com.tekion.jiraassignment.repository.SprintRepository;
import com.tekion.jiraassignment.service.SprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sprint")
public class SprintController {

    @Autowired
    SprintService sprintService;

    @PostMapping("/createSprint")
    public Sprint createSprint(@RequestBody SprintDto sprint){
        return sprintService.createSprint(sprint);
    }

    @GetMapping("/allsprints")
    public List<Sprint> getAllSprints(){
        return sprintService.findAllSprints();
    }

    @GetMapping("/{sprintId}")
    public Sprint findSprintById(@PathVariable String sprintId){
        return sprintService.findSprintById(sprintId);
    }
    @PostMapping("/{sprintId}/tasks/{taskId}")
    public void addToSprint(@PathVariable String sprintId, @PathVariable String taskId){
        sprintService.addToSprint(sprintId,taskId);
    }

    @DeleteMapping("/{sprintId}/tasks/{taskId}")
    public void removeFromSprint(@PathVariable String sprintId, @PathVariable String taskId){
        sprintService.removeFromSprint(sprintId,taskId);
    }

    @GetMapping(value = "/{sprintId}/tasks")
    public List<Task> getTasksBySprint(@PathVariable String sprintId){
        return sprintService.getTasksBySprint(sprintId);
    }



    //    @Autowired
//    SprintRepository sprintRepository;
//
//    @PostMapping("/add")
//    public String addSprint(SprintDto sprint)
//    {
//        sprintRepository.save(sprint);
//        return "data saved";
//    }
//
//    @GetMapping("/allsprints")
//    public List<SprintDto> allSprints(SprintDto sprint)
//    {
//       return sprintRepository.findAll();
//    }

}

