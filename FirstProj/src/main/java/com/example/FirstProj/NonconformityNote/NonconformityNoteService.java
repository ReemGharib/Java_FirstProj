package com.example.FirstProj.NonconformityNote;

import com.example.FirstProj.MandatoryClauseNote.MandatoryClauseNoteEntity;
import com.example.FirstProj.ProgramInitiation.ProgramInitiationEntity;
import com.example.FirstProj.ProgramInitiation.ProgramInitiationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class NonconformityNoteService {
    @Autowired
    NonconformityNoteRepository repository;
    @Autowired
    ProgramInitiationRepository repositoryProgram;


    public List<NonconformityNoteEntity> getAllNoteToProgram(String program_id)throws Exception{
        List<NonconformityNoteEntity> notes;
        try {
            notes = repository.findByProgramInitiationEntity_id(program_id);
        }catch (NoSuchElementException e){
            return new ArrayList<NonconformityNoteEntity>();
        }
        return notes;
    }

    public List<NonconformityNoteEntity> getAllNotes()throws Exception{
        List<NonconformityNoteEntity> notes;
        try {
            notes = repository.findAll();
        }catch (NoSuchElementException e){
            return new ArrayList<NonconformityNoteEntity>();
        }
        return notes;
    }
    public NonconformityNoteEntity getNote(String id)throws Exception{
        NonconformityNoteEntity note;
        try{
            note=repository.findById(id).get();
        }catch(NoSuchElementException e){
            throw new Exception("not found record");
        }
        return note;

    }
    public NonconformityNoteEntity createOrUpdateNote(NonconformityNoteEntity note, String program_id)throws Exception{
        NonconformityNoteEntity entity;
        ProgramInitiationEntity program;
        try{
            program = repositoryProgram.findById(program_id).get();
        }catch (NoSuchElementException e){
            throw new Exception("not found program");
        }
        try {
            entity = repository.findById(note.getId()).get();
        }catch (NoSuchElementException e){
            String myId= UUID.randomUUID().toString();
            note.setId(myId);
            note.setProgramInitiationEntity(program);
            note=repository.save(note);
            return note;
        }
        //update
        entity.setDate(note.date);
        entity.setDateStamp(note.getDateStamp());
        entity.setNotes(note.getNotes());
        entity.setProgramInitiationEntity(program);
        entity=repository.save(entity);
        return entity;
    }
    public String deleteNote(String id)throws Exception{
        try{
            NonconformityNoteEntity entity=repository.findById(id).get();
        }catch (NoSuchElementException e){
            throw new Exception("not found record!");
        }
        repository.deleteById(id);
        return "Successfully deleted note!";
    }

}
