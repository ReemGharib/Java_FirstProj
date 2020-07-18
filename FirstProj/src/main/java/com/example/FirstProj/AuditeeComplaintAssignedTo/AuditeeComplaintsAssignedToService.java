package com.example.FirstProj.AuditeeComplaintAssignedTo;

import com.example.FirstProj.ProgramAssignedTo.ProgramAssignedToEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class AuditeeComplaintsAssignedToService {
    @Autowired AuditeeComplaintsAssignedToRepository repository;
    public List<AuditeeComplaintsAssignedToEntity> getAllProgramAssigned(){
        List<AuditeeComplaintsAssignedToEntity> list=repository.findAll();
        if(list.size() > 0){
            return list;
        }else{
            return new ArrayList<AuditeeComplaintsAssignedToEntity>();
        }
    }
    public AuditeeComplaintsAssignedToEntity getProgramAssigned(String id)throws Exception{
        AuditeeComplaintsAssignedToEntity programAssigned;
        try {
            programAssigned = repository.findById(id).get();
        }catch (NoSuchElementException e){
            throw new Exception("record is not found!");
        }
        return programAssigned;
    }
    public AuditeeComplaintsAssignedToEntity addProgramAssigned(AuditeeComplaintsAssignedToEntity entity){
        AuditeeComplaintsAssignedToEntity entity_note;
        try {
            entity_note = repository.findById(entity.getId()).get();
        }catch (NoSuchElementException e) {
            String myId= UUID.randomUUID().toString();
            entity.setId(myId);
            entity=repository.save(entity);
            return entity;
        }
            AuditeeComplaintsAssignedToEntity newEntity=entity_note;
            newEntity.setFirstName(entity.getFirstName());
            newEntity.setLastName(entity.getLastName());
            newEntity.setDate(entity.getDate());
            newEntity.setDateStamp(entity.getDateStamp());
            newEntity=repository.save(newEntity);
            return  newEntity;
    }
}
