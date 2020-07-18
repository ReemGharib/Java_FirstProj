package com.example.FirstProj.FrameworkProgramInitiation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class FrameworkProgramInitiationService {
    @Autowired
    FrameworkProgramInitiationRepository repository;

    public List<FrameworkProgramInitiationEntity> getAll(){
        List<FrameworkProgramInitiationEntity> list;
        try{
            list=repository.findAll();
        }catch(NoSuchElementException e){
            return new ArrayList<FrameworkProgramInitiationEntity>();
        }
        return list;
    }

    public FrameworkProgramInitiationEntity getFramework(String id) throws Exception{
        FrameworkProgramInitiationEntity entity;
        try{
            entity = repository.findById(id).get();
        }catch (NoSuchElementException e){
            throw new Exception("not found record");
        }
        return entity;
    }

    public FrameworkProgramInitiationEntity addFramework(FrameworkProgramInitiationEntity entity){
        FrameworkProgramInitiationEntity framework_entity;
        try{
            framework_entity=repository.findById(entity.getId()).get();
        }catch (NoSuchElementException e){
            String myId= UUID.randomUUID().toString();
            entity.setId(myId);
            return repository.save(entity);
        }
        FrameworkProgramInitiationEntity update_entity=framework_entity;
        update_entity.setFramework(entity.getFramework());
        return repository.save(update_entity);
    }
    public void delete(String id)throws Exception{
        FrameworkProgramInitiationEntity entity;
        try{
            entity = repository.findById(id).get();
        }catch (NoSuchElementException e){
            throw new Exception("not found record");
        }
        repository.deleteById(id);
    }


}
