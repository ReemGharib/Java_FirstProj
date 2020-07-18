package com.example.FirstProj.NonconformityClassification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class NonconformityClassificationService {
    @Autowired
    NonconformityClassificationRepository repository;
    public List<NonconformityClassificationEntity> getAll() {
        List<NonconformityClassificationEntity> list;
        try{
            list=repository.findAll();
        }catch (NoSuchElementException e){
            return new ArrayList<NonconformityClassificationEntity>();
        }
        return list;
    }

    public NonconformityClassificationEntity get(String id)throws Exception{
        NonconformityClassificationEntity entity;
        try{
            entity = repository.findById(id).get();
        }catch (NoSuchElementException e){
            throw new Exception("no record found");
        }
        return entity;
    }

    public NonconformityClassificationEntity addEntity(NonconformityClassificationEntity entity){
        String myId = UUID.randomUUID().toString();
        NonconformityClassificationEntity classificationEntity;
        try{
            classificationEntity = repository.findById(entity.getId()).get();
        }catch (NoSuchElementException e){
            entity.setId(myId);
            return repository.save(entity);
        }
        classificationEntity.setNonconformityClassification(entity.getNonconformityClassification());
        return classificationEntity;
    }
}
