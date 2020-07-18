package com.example.FirstProj.NonconformityNote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("NonconformityNote")
@CrossOrigin(allowedHeaders = "*" , origins = "*")
public class NonconformityNoteController {
    @Autowired
    NonconformityNoteService service;


    @GetMapping("getAllNoteToProgram/{program_id}")
    public List<NonconformityNoteEntity> getAll(@PathVariable("program_id")String program_id)throws Exception{
        List<NonconformityNoteEntity> list = service.getAllNoteToProgram(program_id);
        return list;
    }

    @GetMapping
    public List<NonconformityNoteEntity> getAllNonconformityNotes()throws Exception{
        List<NonconformityNoteEntity> list=service.getAllNotes();
        return list;
    }
    @GetMapping("getNonconformityNoteNote/{id}")
    public NonconformityNoteEntity getNote(@PathVariable("id") String id)throws Exception{
        NonconformityNoteEntity noteEntity=service.getNote(id);
        return noteEntity;
    }
    @PostMapping("addNote/{program_id}")
    public NonconformityNoteEntity createOrUpdateNote(@RequestBody NonconformityNoteEntity entity, @PathVariable("program_id")String program_id)throws Exception{
        NonconformityNoteEntity note=service.createOrUpdateNote(entity, program_id);
        return note;
    }
    @DeleteMapping("deleteNote/{id}")
    public String deleteNote(@PathVariable("id") String id)throws Exception{
        return service.deleteNote(id);
    }

}
