package com.example.FirstProj.CorrectiveActionNote;

import com.example.FirstProj.NonconformityNote.NonconformityNoteEntity;
import com.example.FirstProj.ProgramInitiation.ProgramInitiationEntity;
import com.example.FirstProj.ProgramInitiation.ProgramInitiationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class CorrectiveActionNoteService {
    @Autowired
    CorrectiveActionNoteRepository repository;
    @Autowired
    ProgramInitiationRepository repositoryProgram;

    public List<CorrectiveActionNoteEntity> getAllNoteToProgram(String program_id)throws Exception{
        List<CorrectiveActionNoteEntity> notes;
        try {
            notes = repository.findByProgramInitiationEntity_id(program_id);
        }catch (NoSuchElementException e){
            return new ArrayList<CorrectiveActionNoteEntity>();
        }
        return notes;
    }
    public List<CorrectiveActionNoteEntity> getAllNotes()throws Exception{
        List<CorrectiveActionNoteEntity> notes;
        try {
            notes = repository.findAll();
        }catch (NoSuchElementException e){
            return new ArrayList<CorrectiveActionNoteEntity>();
        }
        return notes;
    }
    public CorrectiveActionNoteEntity getNote(String id)throws Exception{
        CorrectiveActionNoteEntity note;
        try{
            note=repository.findById(id).get();
        }catch(NoSuchElementException e){
            throw new Exception("not found record");
        }
        return note;

    }
    public CorrectiveActionNoteEntity createOrUpdateNote(CorrectiveActionNoteEntity note, String program_id)throws Exception{
        CorrectiveActionNoteEntity entity;
        ProgramInitiationEntity programInitiationEntity;
        try{
            programInitiationEntity = repositoryProgram.findById(program_id).get();
        }catch (NoSuchElementException e){
            throw new Exception("not found program");
        }
        try {
            entity = repository.findById(note.getId()).get();
        }catch (NoSuchElementException e){
            String myId= UUID.randomUUID().toString();
            note.setId(myId);
            note.setProgramInitiationEntity(programInitiationEntity);
            note=repository.save(note);
            return note;
        }
        //update
        entity.setDate(note.date);
        entity.setDateStamp(note.getDateStamp());
        entity.setNotes((note.getNotes()));
        entity.setProgramInitiationEntity(programInitiationEntity);
        entity=repository.save(entity);
        return entity;
    }
    public String deleteNote(String id)throws Exception{
        try{
            CorrectiveActionNoteEntity entity=repository.findById(id).get();
        }catch (NoSuchElementException e){
            throw new Exception("not found record!");
        }
        repository.deleteById(id);
        return "Successfully deleted note!";
    }


}
