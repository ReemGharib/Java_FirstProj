package com.example.FirstProj.CorrectiveAssignedTo;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("CorrectiveAssignedTo")
@CrossOrigin(allowedHeaders = "*" , origins = "*")
public class CorrectiveAssignedToController {
    @Autowired
    CorrectiveAssignedToService service;

    @GetMapping
    public List<CorrectiveAssignedToEntity> getAllAssignedEntities(){
        List<CorrectiveAssignedToEntity> list=service.getAll();
        return list;
    }
    @GetMapping("getCorrectiveAssignedTo/{id}")
    public CorrectiveAssignedToEntity getCorrectiveAssignedTo(@PathVariable("id")String id)throws Exception{
        CorrectiveAssignedToEntity programAssignedToEntity=service.getCorrectiveAssignedTo(id);
        return programAssignedToEntity;
    }
    @PostMapping("addProgramAssignedTo")
    public CorrectiveAssignedToEntity addProgramAssignedTo(@RequestBody CorrectiveAssignedToEntity entity){
        CorrectiveAssignedToEntity correctiveAssignedTo=service.addCorrectiveAssignedTo(entity);
       return correctiveAssignedTo;
    }
}
