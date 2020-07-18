package com.example.FirstProj.PolicyProcedureNote;

import com.example.FirstProj.PolicyProcedureNote.PolicyProcedureNoteEntity;
import com.example.FirstProj.PolicyProcedureNote.PolicyProcedureNoteRepository;
import com.example.FirstProj.ProgramInitiation.ProgramInitiationEntity;
import com.example.FirstProj.ProgramInitiation.ProgramInitiationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PolicyProcedureNoteService {
    @Autowired
    PolicyProcedureNoteRepository repository;
    @Autowired
    ProgramInitiationRepository programRepository;

    public List<PolicyProcedureNoteEntity> getAllPolicyProcedureNotes(){
        List<PolicyProcedureNoteEntity> list=repository.findAll();
        if(list.size() > 0){
            return list;
        }else{
            return new ArrayList<PolicyProcedureNoteEntity>();
        }
    }
    public List<PolicyProcedureNoteEntity> getAllToProgram(String program_id)throws Exception{
        List<PolicyProcedureNoteEntity> list=repository.findByProgramInitiationEntity_id(program_id);
        ProgramInitiationEntity program;
        if(list.size() > 0){
            return list;
        }else{
            return new ArrayList<PolicyProcedureNoteEntity>();
        }
    }
    public PolicyProcedureNoteEntity getPolicyProcedureNote(String id)throws Exception{
        Optional<PolicyProcedureNoteEntity> entity_note=repository.findById(id);
        if(entity_note.isPresent()){
            return entity_note.get();
        }else {
            throw new Exception("record is not found");
        }
    }
    public PolicyProcedureNoteEntity addNote(PolicyProcedureNoteEntity entity, String program_id){
        Optional<PolicyProcedureNoteEntity> entity_note=repository.findById(entity.getId());
        ProgramInitiationEntity program = programRepository.findById(program_id).get();
        if(entity_note.isPresent()){
            PolicyProcedureNoteEntity newEntity=entity_note.get();
            newEntity.setDate(entity.getDate());
            newEntity.setDateStamp(entity.getDateStamp());
            newEntity.setNotes(entity.getNotes());
            newEntity.setProgramInitiationEntity(program);
            newEntity=repository.save(newEntity);
            return  newEntity;
        }else{
            String entity_id= UUID.randomUUID().toString();
            entity.setId(entity_id);
            entity.setProgramInitiationEntity(program);
            entity=repository.save(entity);
            return entity;
        }
    }
    public String delete(String id)throws Exception{
        PolicyProcedureNoteEntity entity;
        try{
            entity=repository.findById(id).get();
        }catch(NoSuchElementException e){
            throw new Exception("not found record");
        }
        repository.delete(entity);
        return "Successfully Deleted";
    }
}
