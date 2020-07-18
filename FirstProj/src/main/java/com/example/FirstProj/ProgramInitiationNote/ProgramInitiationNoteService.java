package com.example.FirstProj.ProgramInitiationNote;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class ProgramInitiationNoteService {
    @Autowired
    ProgramInitiationNoteRepository repository;
    public List<ProgramInitiationNoteEntity> getAllNotes()throws Exception{
        List<ProgramInitiationNoteEntity> notes;
        try {
             notes = repository.findAll();
        }catch (NoSuchElementException e){
            return new ArrayList<ProgramInitiationNoteEntity>();
        }
        return notes;
    }
    public ProgramInitiationNoteEntity createOrUpdateNote(ProgramInitiationNoteEntity program)throws Exception{
        ProgramInitiationNoteEntity entity;
        try {
             entity = repository.findById(program.getId()).get();
        }catch (NoSuchElementException e){
            String myId= UUID.randomUUID().toString();
            program.setId(myId);
           program=repository.save(program);
           return program;
        }
        //update
        entity.setDate(program.getDate());
        entity.setDateStamp(program.getDateStamp());
        entity.setNotes(program.getNotes());
        entity=repository.save(entity);
        return entity;
    }
    public void deleteNote(String id){
        repository.deleteById(id);
    }
}
