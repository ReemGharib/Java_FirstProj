package com.example.FirstProj.AuditeeComplaintAssignedTo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("AuditeeComplaintsAssignedTo")
@CrossOrigin(allowedHeaders = "*" , origins = "*")
public class AuditeeComplaintsAssignedToController {
    @Autowired
    AuditeeComplaintsAssignedToService service;

    @GetMapping
    public List<AuditeeComplaintsAssignedToEntity> getAllAssigned(){
        List<AuditeeComplaintsAssignedToEntity> list=service.getAllProgramAssigned();
        return list;
    }
    @GetMapping("getAuditeAssignedTo/{id}")
    public AuditeeComplaintsAssignedToEntity getAuditeeAssignedTo(@PathVariable("id") String id)throws Exception{
        AuditeeComplaintsAssignedToEntity entity=service.getProgramAssigned(id);
        return entity;
    }
    @PostMapping("addAuditeeAssignedTo")
    public AuditeeComplaintsAssignedToEntity addAuditeeAssignedTo(@RequestBody AuditeeComplaintsAssignedToEntity entity){
        AuditeeComplaintsAssignedToEntity assignedToEntity=service.addProgramAssigned(entity);
        return assignedToEntity;
    }

}
