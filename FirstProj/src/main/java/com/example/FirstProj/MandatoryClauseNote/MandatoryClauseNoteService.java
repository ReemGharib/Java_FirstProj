package com.example.FirstProj.MandatoryClauseNote;

import com.example.FirstProj.ProgramInitiation.ProgramInitiationEntity;
import com.example.FirstProj.ProgramInitiation.ProgramInitiationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
@Service
public class MandatoryClauseNoteService {
    @Autowired
    MandatoryClauseNoteRepository repository;
    @Autowired
    ProgramInitiationRepository repositoryProgram;

    public List<MandatoryClauseNoteEntity> getAllNoteToProgram(String program_id)throws Exception{
        List<MandatoryClauseNoteEntity> notes;
        try {
            notes = repository.findByProgramInitiationEntity_id(program_id);
        }catch (NoSuchElementException e){
            return new ArrayList<MandatoryClauseNoteEntity>();
        }
        return notes;
    }
    public List<MandatoryClauseNoteEntity> getAllNotes()throws Exception{
        List<MandatoryClauseNoteEntity> notes;
        try {
            notes = repository.findAll();
        }catch (NoSuchElementException e){
            return new ArrayList<MandatoryClauseNoteEntity>();
        }
        return notes;
    }
    public MandatoryClauseNoteEntity getMandatoryClauseNote(String id)throws Exception{
        MandatoryClauseNoteEntity note;
        try{
            note=repository.findById(id).get();
        }catch(NoSuchElementException e){
            throw new Exception("not found record");
        }
        return note;

    }
    public MandatoryClauseNoteEntity createOrUpdateNote(MandatoryClauseNoteEntity note, String program_id)throws Exception{
        MandatoryClauseNoteEntity entity;
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
            MandatoryClauseNoteEntity entity=repository.findById(id).get();
        }catch (NoSuchElementException e){
            throw new Exception("not found record!");
        }
        repository.deleteById(id);
        return "Successfully deleted note!";
    }
}
