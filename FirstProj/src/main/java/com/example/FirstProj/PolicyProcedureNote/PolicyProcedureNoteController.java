package com.example.FirstProj.PolicyProcedureNote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("PolicyProcedureNote")
@CrossOrigin(allowedHeaders = "*" , origins = "*")
public class PolicyProcedureNoteController {
    @Autowired
    PolicyProcedureNoteService service;

    @GetMapping
    public ResponseEntity<List<PolicyProcedureNoteEntity>> getAllPolicyProcedureNotes(){
        List<PolicyProcedureNoteEntity> entity_list=service.getAllPolicyProcedureNotes();
        return new ResponseEntity<List<PolicyProcedureNoteEntity>>(entity_list, new HttpHeaders(), HttpStatus.OK);
    }
    @GetMapping("getPolicyNote/{id}")
    public ResponseEntity<PolicyProcedureNoteEntity> getPolicyProcedureNoteEntity(@PathVariable("id")String id)throws Exception{
        PolicyProcedureNoteEntity entity=service.getPolicyProcedureNote(id);
        return new ResponseEntity<PolicyProcedureNoteEntity>(entity, new HttpHeaders(), HttpStatus.OK);
    }
    @PostMapping("newNote/{program_id}")
    public ResponseEntity<PolicyProcedureNoteEntity> addNote(@RequestBody PolicyProcedureNoteEntity entity, @PathVariable("program_id") String program_id){
        PolicyProcedureNoteEntity myEntity=service.addNote(entity, program_id);
        return new ResponseEntity<PolicyProcedureNoteEntity>(myEntity, new HttpHeaders(), HttpStatus.OK);
    }
    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable("id")String id)throws Exception{
        service.delete(id);
    }
}
