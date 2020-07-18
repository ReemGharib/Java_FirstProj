package com.example.FirstProj.NonconformityClassification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("NonconformityClassification")
@CrossOrigin(allowedHeaders = "*" , origins = "*")
@RestController
public class NonconformityClassificationController {
    @Autowired
    NonconformityClassificationService service;

    @GetMapping
    public List<NonconformityClassificationEntity> getAll(){
        List<NonconformityClassificationEntity> list = service.getAll();
        return list;
    }

    @GetMapping("getNonConClassification/{id}")
    public NonconformityClassificationEntity get(@PathVariable("id") String id)throws Exception{
        NonconformityClassificationEntity entity = service.get(id);
        return entity;
    }
    @PostMapping("addNonConfClassification")
    public NonconformityClassificationEntity add(@RequestBody NonconformityClassificationEntity entity){
        NonconformityClassificationEntity classificationEntity =service.addEntity(entity);
        return entity;
    }
}
