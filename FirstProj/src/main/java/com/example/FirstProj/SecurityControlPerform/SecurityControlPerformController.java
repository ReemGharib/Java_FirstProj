package com.example.FirstProj.SecurityControlPerform;

import com.example.FirstProj.SecurityControl.SecurityControlEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("SecurityControlPerform")
@RestController
@CrossOrigin(allowedHeaders = "*" , origins = "*")
public class SecurityControlPerformController {
    @Autowired
    SecurityControlPerformService service;


    @GetMapping("/{id}")
    public List<SecurityControlPerformEntity> getAll(@PathVariable("id")String id){
        return service.getAlll(id);
    }
    @PostMapping("getAllSecurity/{framework_id}/{program_id}")
    public List<SecurityControlPerformEntity> getAllSecurityPerform(@PathVariable("framework_id")String framework_id, @PathVariable("program_id")String program_id)throws Exception{
        List<SecurityControlPerformEntity> list=service.getAllSecurityControl(framework_id,program_id);
        return list;
    }
    @GetMapping("getAllToProgram/{program_id}")
    public List<SecurityControlPerformEntity> getAllToProgram(@PathVariable("program_id")String program_id)throws Exception{
        List<SecurityControlPerformEntity> list=service.getAllToProgram(program_id);
        return list;
    }
    @GetMapping("getSecurityPerform/{id}")
    public SecurityControlPerformEntity getSecurityPerform(@PathVariable("id")String id)throws Exception{
        SecurityControlPerformEntity security=service.getSecurityControl(id);
        return security;
    }
    //update
    @PostMapping("updateSecurityControlPerform")
    public SecurityControlPerformEntity addSecurityControlPerform(@RequestBody SecurityControlPerformEntity security_entity)throws Exception{
        SecurityControlPerformEntity entity=service.update(security_entity);
        return entity;
    }
    @DeleteMapping("deleteSecurityControl/{id}")
    public String delete(@PathVariable("id") String id)throws Exception{
        return service.deleteSecurityControl(id);
    }
}
