package com.example.FirstProj.StatusProgramInitiation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("StatusProgramInitiation")
@CrossOrigin(allowedHeaders = "*" , origins = "*")
public class StatusProgramInitiationController {
    @Autowired
    StatusProgramInitiationService service;

    @GetMapping
    public List<StatusProgramInitiationEntity> getAll(){
        List<StatusProgramInitiationEntity> list=service.getAll();
        return list;
    }
    @GetMapping("getStatus/{id}")
    public StatusProgramInitiationEntity getStatus(@PathVariable("id")String id)throws Exception{
        StatusProgramInitiationEntity entity=service.getStatus(id);
        return entity;
    }
    @PostMapping("addStatus")
    public StatusProgramInitiationEntity add(@RequestBody StatusProgramInitiationEntity entity){
        StatusProgramInitiationEntity myEntity = service.addStatus(entity);
        return myEntity;
    }
}
