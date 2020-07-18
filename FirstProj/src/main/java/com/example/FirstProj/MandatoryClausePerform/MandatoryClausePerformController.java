package com.example.FirstProj.MandatoryClausePerform;

import com.example.FirstProj.SecurityControlPerform.SecurityControlPerformEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("MandatoryClausePerform")
@CrossOrigin(allowedHeaders = "*" , origins = "*")

public class MandatoryClausePerformController {
    @Autowired
    MandatoryClausePerformService service;

    @GetMapping
    public List<MandatoryClausePerformEntity> getAllMandatoryPerform(){
        List<MandatoryClausePerformEntity> list=service.getAllMandatoryPerform();
        return list;
    }
    @GetMapping("getAllToProgram/{program_id}")
    public List<MandatoryClausePerformEntity> getAllToProgram(@PathVariable("program_id")String program_id){
        List<MandatoryClausePerformEntity> list=service.getAllToProgram(program_id);
        return list;
    }
    @GetMapping("getMandatoryPerform/{id}")
    public MandatoryClausePerformEntity getMandatoryPerform(@PathVariable("id") String id)throws Exception{
        MandatoryClausePerformEntity entity=service.getMandatory(id);
        return entity;
    }
    @PostMapping("getAllMandatory/{framework_id}/{program_id}")
    public List<MandatoryClausePerformEntity> getAllSecurityPerform(@PathVariable("framework_id")String framework_id, @PathVariable("program_id")String program_id)throws Exception{
        List<MandatoryClausePerformEntity> list=service.getAllMandatory(framework_id,program_id);
        return list;
    }
    @DeleteMapping("deleteMandatory/{id}")
    public String deleteMandatory(@PathVariable("id") String id)throws Exception{
        return service.delete(id);
    }
}
