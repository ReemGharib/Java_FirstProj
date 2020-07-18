package com.example.FirstProj.CorrectiveAssignedTo;

import com.example.FirstProj.ProgramAssignedTo.ProgramAssignedToEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CorrectiveAssignedToService {
    @Autowired
    CorrectiveAssignedToRepository repository;

    public List<CorrectiveAssignedToEntity> getAll(){
        List<CorrectiveAssignedToEntity> list=repository.findAll();
        if(list.size() > 0){
            return list;
        }else{
            return new ArrayList<CorrectiveAssignedToEntity>();
        }
    }
    public CorrectiveAssignedToEntity getCorrectiveAssignedTo(String id)throws Exception{
        CorrectiveAssignedToEntity correctiveAssignedToEntity;
        try {
            correctiveAssignedToEntity = repository.findById(id).get();
        }catch (NoSuchElementException e){
            throw new Exception("record is not found!");
        }
        return correctiveAssignedToEntity;
    }
    public CorrectiveAssignedToEntity addCorrectiveAssignedTo(CorrectiveAssignedToEntity entity){
        CorrectiveAssignedToEntity assignedToEntity;
        try {
            assignedToEntity=repository.findById(entity.getId()).get();
        }catch (NoSuchElementException e){
            String myId= UUID.randomUUID().toString();
            entity.setId(myId);
            entity=repository.save(entity);
            return entity;
        }
            CorrectiveAssignedToEntity newEntity=assignedToEntity;
            newEntity.setFirstName(entity.getFirstName());
            newEntity.setLastName(entity.getLastName());
            newEntity.setDate(entity.getDate());
            newEntity.setDateStamp(entity.getDateStamp());
            newEntity=repository.save(newEntity);
            return  newEntity;
        }
}
