package com.example.FirstProj.ProgramInitiationNote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ProgramInitiationNote")
@CrossOrigin(allowedHeaders = "*" , origins = "*")

public class ProgramInitiationNoteController {
    @Autowired
    ProgramInitiationNoteService service;

    @GetMapping
    public List<ProgramInitiationNoteEntity> getAllNotes()throws Exception{
        List<ProgramInitiationNoteEntity> list = service.getAllNotes();
        return list;
    }
    @PostMapping("addNote")
    public ProgramInitiationNoteEntity newNote(@RequestBody ProgramInitiationNoteEntity note)throws Exception{
        ProgramInitiationNoteEntity entity=service.createOrUpdateNote(note);
        return entity;
    }
    @DeleteMapping("deleteNote/{id}")
    public HttpStatus deleteNote(@PathVariable("id")String id){
        service.deleteNote(id);
        return HttpStatus.OK;
    }
}
