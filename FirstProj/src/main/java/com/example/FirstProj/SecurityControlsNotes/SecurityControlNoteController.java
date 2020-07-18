package com.example.FirstProj.SecurityControlsNotes;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("SecurityControlNote")
@CrossOrigin(allowedHeaders = "*" , origins = "*")
public class SecurityControlNoteController {
    @Autowired
    SecurityControlNoteService service;


    @GetMapping("getAllNoteToProgram/{program_id}")
    public List<SecurityControlNoteEntity> getAll(@PathVariable("program_id")String program_id)throws Exception{
        List<SecurityControlNoteEntity> list = service.getAllNoteToProgram(program_id);
        return list;
    }

    @GetMapping
    public List<SecurityControlNoteEntity> getAllNotes()throws Exception{
        List<SecurityControlNoteEntity> list = service.getAllNotes();
        return list;
    }
    @PostMapping("addNote/{program_id}")
    public SecurityControlNoteEntity newNote(@RequestBody SecurityControlNoteEntity note, @PathVariable("program_id")String program_id)throws Exception{
        SecurityControlNoteEntity entity=service.createOrUpdateNote(note, program_id);
        return entity;
    }
    @DeleteMapping("deleteNote/{id}")
    public String deleteNote(@PathVariable("id")String id)throws Exception{
      return service.deleteNote(id);
    }


}
