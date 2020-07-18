package com.example.FirstProj.CorrectiveReviewer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class CorrectiveReviewerService {
    @Autowired
    CorrectiveReviewerRepository repository;

    public List<CorrectiveReviewerEntity> getAll(){
        List<CorrectiveReviewerEntity> list;
        try{
            list=repository.findAll();
        }catch (NoSuchElementException e){
            return new ArrayList<CorrectiveReviewerEntity>();
        }
        return list;
    }
    public CorrectiveReviewerEntity getReviewer(String id)throws Exception{
        CorrectiveReviewerEntity entity;
        try {
            entity=repository.findById(id).get();
        }catch (NoSuchElementException e){
            throw new Exception("not found record");
        }
        return entity;
    }
    public CorrectiveReviewerEntity addReviewer(CorrectiveReviewerEntity reviewerEntity){
        CorrectiveReviewerEntity entity;
        try{
            entity=repository.findById(reviewerEntity.getId()).get();
        }catch (NoSuchElementException e){
            String myId= UUID.randomUUID().toString();
            reviewerEntity.setId(myId);
            return repository.save(reviewerEntity);
        }
        CorrectiveReviewerEntity correctiveReviewerEntity=reviewerEntity;
        correctiveReviewerEntity.setDate(reviewerEntity.getDate());
        correctiveReviewerEntity.setDateStamp(reviewerEntity.getDateStamp());
        correctiveReviewerEntity.setFirstName(reviewerEntity.getFirstName());
        correctiveReviewerEntity.setLastName(reviewerEntity.getLastName());
        return repository.save(correctiveReviewerEntity);
    }
    public String delete(String id)throws Exception{
        CorrectiveReviewerEntity entity;
        try{
            entity=repository.findById(id).get();
        }catch (NoSuchElementException e){
            throw new Exception("not found record");
        }
        repository.delete(entity);
        return "Successfully deleted entity";
    }
}
