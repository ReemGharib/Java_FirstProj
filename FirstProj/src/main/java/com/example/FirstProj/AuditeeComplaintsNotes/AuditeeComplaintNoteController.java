package com.example.FirstProj.AuditeeComplaintsNotes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("AuditeeComplaintNote")
@CrossOrigin(allowedHeaders = "*" , origins = "*")
public class AuditeeComplaintNoteController {
    @Autowired
    AuditeeComplaintNoteService service;

    @GetMapping("getAllNoteToProgram/{program_id}")
    public List<AuditeeComplaintNoteEntity> getAll(@PathVariable("program_id")String program_id)throws Exception{
        List<AuditeeComplaintNoteEntity> list = service.getAllNoteToProgram(program_id);
        return list;
    }
    @GetMapping
    public List<AuditeeComplaintNoteEntity> getAllNotes()throws Exception{
        List<AuditeeComplaintNoteEntity> list = service.getAllNotes();
        return list;
    }
    @PostMapping("addNote/{program_id}")
    public AuditeeComplaintNoteEntity newNote(@RequestBody AuditeeComplaintNoteEntity note, @PathVariable("program_id")String program_id)throws Exception{
        AuditeeComplaintNoteEntity entity=service.createOrUpdateNote(note, program_id);
        return entity;
    }
    @DeleteMapping("deleteNote/{id}")
    public String deleteNote(@PathVariable("id")String id)throws Exception{
        return service.deleteNote(id);
    }
}
