package com.example.FirstProj.SecurityControl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Security")
public class SecurityControlController {
    @Autowired
    SecurityControlService service;
    @GetMapping
    public List<SecurityControlEntity> getAllSecurityPerform(){
        List<SecurityControlEntity> list=service.getAllSecurityControl();
        return list;
    }

    @GetMapping("getSecurity/{id}")
    public SecurityControlEntity getSecurityPerform(@PathVariable("id")String id)throws Exception{
        SecurityControlEntity security=service.getSecurityControl(id);
        return security;
    }
    @PostMapping("addSecurityControl/{framework_id}")
    public SecurityControlEntity addSecurityControlPerform(@RequestBody SecurityControlEntity security_entity,
                                                                  @PathVariable("framework_id")String framework_id)throws Exception{
        SecurityControlEntity entity=service.addSecurityControl(security_entity, framework_id);
        return entity;
    }
    @DeleteMapping("deleteSecurityControl/{id}")
    public String delete(@PathVariable("id") String id)throws Exception{
        return service.deleteSecurityControl(id);
    }
}
