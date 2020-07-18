package com.example.FirstProj.CorrectiveAction;

import com.example.FirstProj.AuditeeComplaint.AuditeeComplaintEntity;
import com.example.FirstProj.CorrectiveAssignedTo.CorrectiveAssignedToEntity;
import com.example.FirstProj.CorrectiveAssignedTo.CorrectiveAssignedToRepository;
import com.example.FirstProj.CorrectiveReviewer.CorrectiveReviewerEntity;
import com.example.FirstProj.CorrectiveReviewer.CorrectiveReviewerRepository;
import com.example.FirstProj.ProgramInitiation.ProgramInitiationEntity;
import com.example.FirstProj.ProgramInitiation.ProgramInitiationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class CorrectiveActionService {
    @Autowired
    CorrectiveActionRepository repository;
    @Autowired
    CorrectiveAssignedToRepository assignedToRepository;
    @Autowired
    CorrectiveReviewerRepository reviewerRepository;
    @Autowired
    ProgramInitiationRepository programInitiationRepository;

    public List<CorrectiveActionEntity> getAll(){
        List<CorrectiveActionEntity> list;
        try {
            list=repository.findAll();
        }catch (NoSuchElementException e){
            return new ArrayList<CorrectiveActionEntity>();
        }
        return list;
    }
    public List<CorrectiveActionEntity> getAllToProgram(String id){
        List<CorrectiveActionEntity> list;
        try {
            list=repository.findByProgramInitiationEntity_id(id);
        }catch (NoSuchElementException e){
            return new ArrayList<CorrectiveActionEntity>();
        }
        return list;
    }

    public CorrectiveActionEntity getCorrectiveAction(String id)throws Exception{
        CorrectiveActionEntity entity;
        try {
            entity=repository.findById(id).get();
        }catch (NoSuchElementException e){
            throw new Exception("not found record");
        }
        return entity;
    }
    public CorrectiveActionEntity add(CorrectiveActionEntity entity, String reviewer_id,String assignedTo_id,String program_id)throws Exception{
        CorrectiveAssignedToEntity correctiveAssignedToEntity;
        CorrectiveReviewerEntity correctiveReviewerEntity;
        CorrectiveActionEntity myEntity;
        ProgramInitiationEntity programInitiationEntity;
        try{
            programInitiationEntity = programInitiationRepository.findById(program_id).get();
        }catch (NoSuchElementException e){
            throw new Exception("not found program");
        }
        try{
            correctiveAssignedToEntity=assignedToRepository.findById(assignedTo_id).get();
        }catch (NoSuchElementException e){
            throw new Exception("not found correctiveAssignedToEntity");
        }
        try{
            correctiveReviewerEntity=reviewerRepository.findById(reviewer_id).get();
        }catch (NoSuchElementException e){
            throw new Exception("not found correctiveAssignedToEntity");
        }
        try {
            myEntity=repository.findById(entity.getId()).get();
        }catch (NoSuchElementException e){
            String myId= UUID.randomUUID().toString();
            entity.setId(myId);
            entity.setCorrectiveReviewerEntity(correctiveReviewerEntity);
            entity.setCorrectiveAssignedToEntity(correctiveAssignedToEntity);
            entity.setProgramInitiationEntity(programInitiationEntity);
            return repository.save(entity);
        }
        //update
        CorrectiveActionEntity update_entity=myEntity;
        update_entity.setAssignedOnDate(entity.getAssignedOnDate());
        update_entity.setCorrectiveAction(entity.getCorrectiveAction());
        update_entity.setDateStamp(entity.getDateStamp());
        update_entity.setImplementationDeadlineDate(entity.getImplementationDeadlineDate());
        update_entity.setRelatedCustomerComplaints(entity.getRelatedCustomerComplaints());
        update_entity.setInformedImplementedAction(entity.getInformedImplementedAction());
        update_entity.setReviewedOnDate(entity.getReviewedOnDate());
        update_entity.setStatus(entity.getStatus());
        update_entity.setCorrectiveAssignedToEntity(correctiveAssignedToEntity);
        update_entity.setCorrectiveReviewerEntity(correctiveReviewerEntity);
        update_entity.setProgramInitiationEntity(programInitiationEntity);
        return repository.save(update_entity);
    }
    public String delete(String id)throws Exception{
         CorrectiveActionEntity entity;
        try {
            entity = repository.findById(id).get();
        }catch(NoSuchElementException e){
            throw new Exception ("not found record");
        }
        repository.delete(entity);
        return "Successfully deleted!";
    }
}
