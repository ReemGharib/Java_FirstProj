package com.example.FirstProj.MandatoryClauseNote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("MandatoryClauseNote")
@CrossOrigin(allowedHeaders = "*" , origins = "*")
public class MandatoryClauseNoteController {
    @Autowired
    MandatoryClauseNoteService service;

    @GetMapping("getAllNoteToProgram/{program_id}")
    public List<MandatoryClauseNoteEntity> getAll(@PathVariable("program_id")String program_id)throws Exception{
        List<MandatoryClauseNoteEntity> list = service.getAllNoteToProgram(program_id);
        return list;
    }

    @GetMapping
    public List<MandatoryClauseNoteEntity> getAllMandatoryNotes()throws Exception{
        List<MandatoryClauseNoteEntity> list=service.getAllNotes();
        return list;
    }
    @GetMapping("getMandatoryClauseNote/{id}")
    public MandatoryClauseNoteEntity getMandatoryClauseNote(@PathVariable("id") String id)throws Exception{
        MandatoryClauseNoteEntity noteEntity=service.getMandatoryClauseNote(id);
        return noteEntity;
    }
    @PostMapping("addNote/{program_id}")
    public MandatoryClauseNoteEntity createOrUpdateNote(@RequestBody MandatoryClauseNoteEntity entity, @PathVariable("program_id")String program_id)throws Exception{

        MandatoryClauseNoteEntity note=service.createOrUpdateNote(entity, program_id);
        return note;
    }
    @DeleteMapping("deleteNote/{id}")
    public String deleteNote(@PathVariable("id") String id)throws Exception{
        return service.deleteNote(id);
    }
}
