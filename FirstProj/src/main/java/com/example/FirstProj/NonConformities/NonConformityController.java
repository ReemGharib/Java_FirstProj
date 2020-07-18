package com.example.FirstProj.NonConformities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("NonConformity")
@CrossOrigin(allowedHeaders = "*" , origins = "*")
public class NonConformityController {
    @Autowired
    NonConformityService service;

    @GetMapping
    public List<NonConformityEntity> getAllNonConformities(){
        List<NonConformityEntity> list=service.getAllNonConformity();
        return list;
    }
    @GetMapping("getAllToProgram/{program_id}")
    public List<NonConformityEntity> getAllToProgram(@PathVariable("program_id")String program_id){
        List<NonConformityEntity> list=service.getAllNonConformityToProgram(program_id);
        return list;
    }
    @GetMapping("NonConformityEntity/{id}")
    public NonConformityEntity getNonConformityEntity(@PathVariable("id")String id)throws Exception{
        NonConformityEntity entity=service.getNonConformity(id);
        return entity;
    }
    @PostMapping("addNonConformity/{classification_id}/{program_id}")
    public NonConformityEntity addNonConformity(@RequestBody NonConformityEntity e,
                                                @PathVariable("classification_id") String classification_id,
                                                @PathVariable("program_id")String program_id)throws Exception{
        NonConformityEntity entity=service.addEntity(e,classification_id, program_id);
        return entity;
    }
    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable("id")String id)throws Exception{
        return service.delete(id);
    }
}
