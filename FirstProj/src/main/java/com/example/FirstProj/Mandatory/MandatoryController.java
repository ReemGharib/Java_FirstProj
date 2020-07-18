package com.example.FirstProj.Mandatory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Mandatory")
@CrossOrigin(allowedHeaders = "*" , origins = "*")
public class MandatoryController {
    @Autowired
    MandatoryService service;

    @GetMapping
    public List<MandatoryEntity> getAllMandatoryPerform(){
        List<MandatoryEntity> list=service.getAllMandatory();
        return list;
    }

    @GetMapping("getMandatoryPerform/{id}")
    public MandatoryEntity getMandatoryPerform(@PathVariable("id") String id)throws Exception{
        MandatoryEntity entity=service.getMandatory(id);
        return entity;
    }
    @PostMapping("addMandatoryPerform/{framework_id}")
    public MandatoryEntity addMandatoryPerform(@RequestBody MandatoryEntity entity,
                                                            @PathVariable("framework_id")String framework_id)throws Exception{
        MandatoryEntity mandatory=service.addMandatoryPerform(entity, framework_id);
        return mandatory;
    }
    @DeleteMapping("deleteMandatory/{id}")
    public String deleteMandatory(@PathVariable("id") String id)throws Exception{
        return service.delete(id);
    }
}
