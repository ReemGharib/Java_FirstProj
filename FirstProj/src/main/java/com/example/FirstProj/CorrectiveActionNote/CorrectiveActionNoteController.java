package com.example.FirstProj.CorrectiveActionNote;
import com.example.FirstProj.AuditeeComplaintsNotes.AuditeeComplaintNoteEntity;
import com.example.FirstProj.NonconformityNote.NonconformityNoteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("CorrectiveActionNote")
@CrossOrigin(allowedHeaders = "*" , origins = "*")
public class CorrectiveActionNoteController {
    @Autowired
    CorrectiveActionNoteService service;

    @GetMapping("getAllNoteToProgram/{program_id}")
    public List<CorrectiveActionNoteEntity> getAll(@PathVariable("program_id")String program_id)throws Exception{
        List<CorrectiveActionNoteEntity> list = service.getAllNoteToProgram(program_id);
        return list;
    }

    @GetMapping
    public List<CorrectiveActionNoteEntity> getAllCorrectiveActionNote()throws Exception{
        List<CorrectiveActionNoteEntity> list=service.getAllNotes();
        return list;
    }
    @GetMapping("getCorrectiveActionNote/{id}")
    public CorrectiveActionNoteEntity getNote(@PathVariable("id") String id)throws Exception{
        CorrectiveActionNoteEntity noteEntity=service.getNote(id);
        return noteEntity;
    }
    @PostMapping("addNote/{program_id}")
    public CorrectiveActionNoteEntity createOrUpdateNote(@RequestBody CorrectiveActionNoteEntity entity, @PathVariable("program_id")String program_id)throws Exception{
        CorrectiveActionNoteEntity note=service.createOrUpdateNote(entity,program_id);
        return note;
    }
    @DeleteMapping("deleteNote/{id}")
    public String deleteNote(@PathVariable("id") String id)throws Exception{
        return service.deleteNote(id);
    }

}
