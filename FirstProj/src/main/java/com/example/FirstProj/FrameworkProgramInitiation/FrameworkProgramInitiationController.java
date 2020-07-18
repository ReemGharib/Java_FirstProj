package com.example.FirstProj.FrameworkProgramInitiation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("FrameworkProgramInitiation")
@CrossOrigin(allowedHeaders = "*" , origins = "*")
public class FrameworkProgramInitiationController {
    @Autowired
    FrameworkProgramInitiationService service;

    @GetMapping
    public List<FrameworkProgramInitiationEntity> getAll(){
        List<FrameworkProgramInitiationEntity> list=service.getAll();
        return list;
    }
    @GetMapping("getFramework/{id}")
    public FrameworkProgramInitiationEntity getFramework(@PathVariable("id")String id)throws Exception{
        FrameworkProgramInitiationEntity entity=service.getFramework(id);
        return entity;
    }
    @PostMapping("addframework")
    public FrameworkProgramInitiationEntity add(@RequestBody FrameworkProgramInitiationEntity entity){
        FrameworkProgramInitiationEntity myEntity = service.addFramework(entity);
        return myEntity;
    }
    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable("id")String id)throws Exception{
        service.delete(id);
    }

}
