package com.example.FirstProj.ProgramAssignedTo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProgramAssignedToService {
    @Autowired
    ProgramAssignedToRepository repository;
    public List<ProgramAssignedToEntity> getAllProgramAssigned(){
        List<ProgramAssignedToEntity> list=repository.findAll();
        if(list.size() > 0){
            return list;
        }else{
            return new ArrayList<ProgramAssignedToEntity>();
        }
    }
    public ProgramAssignedToEntity getProgramAssigned(String id)throws Exception{
        ProgramAssignedToEntity programAssigned;
        try {
            programAssigned = repository.findById(id).get();
        }catch (NoSuchElementException e){
            throw new Exception("record is not found!");
        }
        return programAssigned;
    }
    public ProgramAssignedToEntity addProgramAssigned(ProgramAssignedToEntity entity){
        Optional<ProgramAssignedToEntity> entity_note=repository.findById(entity.getId());
        if(entity_note.isPresent()){
            ProgramAssignedToEntity newEntity=entity_note.get();
            newEntity.setFirstName(entity.getFirstName());
            newEntity.setLastName(entity.getLastName());
            newEntity.setDate(entity.getDate());
            newEntity.setDateStamp(entity.getDateStamp());
            newEntity=repository.save(newEntity);
            return  newEntity;
        }
        else{
            String myId= UUID.randomUUID().toString();
            entity.setId(myId);
            entity=repository.save(entity);
            return entity;
        }
    }
}
