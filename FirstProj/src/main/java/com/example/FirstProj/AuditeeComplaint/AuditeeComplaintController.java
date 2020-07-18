package com.example.FirstProj.AuditeeComplaint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("AuditeeComplaint")
@CrossOrigin(allowedHeaders = "*" , origins = "*")
public class AuditeeComplaintController {
    @Autowired
    AuditeeComplaintService service;

    @GetMapping
    public List<AuditeeComplaintEntity> getAllAuditeeComplaints(){
        List<AuditeeComplaintEntity> list=service.getAllAuditeeComplaints();
        return list;
    }

    @GetMapping("getAllToProgram/{program_id}")
    public List<AuditeeComplaintEntity> getAllToProgram(@PathVariable("program_id")String program_id){
        List<AuditeeComplaintEntity> list=service.getAllAuditeeComplaintsToProgram(program_id);
        return list;
    }
    @GetMapping("getAuditeeComplaint/{id}")
    public AuditeeComplaintEntity getAuditeeComplaint(@PathVariable("id")String id)throws Exception{
        AuditeeComplaintEntity entity=service.getAuditeeComplaint(id);
        return entity;
    }
    @PostMapping("addAuditeeComplaint/{id}/{program_id}")
    public AuditeeComplaintEntity addAuditeeComplaint(@RequestBody AuditeeComplaintEntity entity,
                                                      @PathVariable("id")String id,
                                                      @PathVariable("program_id")String program_id)throws Exception{
        AuditeeComplaintEntity complaintEntity=service.addAuditeeComplaint(entity, id, program_id);
        return complaintEntity;
    }
    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable("id") String id)throws Exception{
        return service.delete(id);
    }
}
