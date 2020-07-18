package com.example.FirstProj.StatusProgramInitiation;

import com.example.FirstProj.FrameworkProgramInitiation.FrameworkProgramInitiationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class StatusProgramInitiationService {
    @Autowired
    StatusProgramInitiationRepository repository;

    public List<StatusProgramInitiationEntity> getAll(){
        List<StatusProgramInitiationEntity> list;
        try{
            list=repository.findAll();
        }catch(NoSuchElementException e){
            return new ArrayList<StatusProgramInitiationEntity>();
        }
        return list;
    }

    public StatusProgramInitiationEntity getStatus(String id) throws Exception{
        StatusProgramInitiationEntity entity;
        try{
            entity = repository.findById(id).get();
        }catch (NoSuchElementException e){
            throw new Exception("not found record");
        }
        return entity;
    }

    public StatusProgramInitiationEntity addStatus(StatusProgramInitiationEntity entity){
        StatusProgramInitiationEntity Status_entity;
        try{
            Status_entity=repository.findById(entity.getId()).get();
        }catch (NoSuchElementException e){
            String myId= UUID.randomUUID().toString();
            entity.setId(myId);
            return repository.save(entity);
        }
        StatusProgramInitiationEntity update_entity=Status_entity;
        update_entity.setStatus(entity.getStatus());
        return repository.save(update_entity);
    }
}
