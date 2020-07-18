package com.example.FirstProj.SecurityControlsNotes;
import com.example.FirstProj.ProgramInitiation.ProgramInitiationEntity;
import com.example.FirstProj.ProgramInitiation.ProgramInitiationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class SecurityControlNoteService {
    @Autowired
    SecurityControlNoteRepository repository;
    @Autowired
    ProgramInitiationRepository repositoryProgram;

    public List<SecurityControlNoteEntity> getAllNoteToProgram(String program_id)throws Exception{
        List<SecurityControlNoteEntity> notes;
        try {
            notes = repository.findByProgramInitiationEntity_id(program_id);
        }catch (NoSuchElementException e){
            return new ArrayList<SecurityControlNoteEntity>();
        }
        return notes;
    }
    public List<SecurityControlNoteEntity> getAllNotes()throws Exception{
        List<SecurityControlNoteEntity> notes;
        try {
            notes = repository.findAll();
        }catch (NoSuchElementException e){
            return new ArrayList<SecurityControlNoteEntity>();
        }
        return notes;
    }
    public SecurityControlNoteEntity createOrUpdateNote(SecurityControlNoteEntity noteEntity, String program_id)throws Exception{
        SecurityControlNoteEntity entity;
        ProgramInitiationEntity program;
        try{
            program = repositoryProgram.findById(program_id).get();
        }catch (NoSuchElementException e){
            throw new Exception("not found program");
        }
        try {
            entity = repository.findById(noteEntity.getId()).get();
        }catch (NoSuchElementException e){
            String myId= UUID.randomUUID().toString();
            noteEntity.setId(myId);
            noteEntity.setProgramInitiationEntity(program);
            noteEntity=repository.save(noteEntity);
            return noteEntity;
        }
        //update
        entity.setNotes(noteEntity.getNotes());
        entity.setDate(noteEntity.getDate());
        entity.setDateStamp(noteEntity.getDateStamp());
        entity.setProgramInitiationEntity(program);
        entity=repository.save(entity);
        return entity;
    }
    public String deleteNote(String id)throws Exception{
        SecurityControlNoteEntity note;
        try{
           note= repository.findById(id).get();
        }catch (NoSuchElementException e){
            throw new Exception("no record found!");
        }
        repository.delete(note);
        return "Successfully deleted";
    }
}
