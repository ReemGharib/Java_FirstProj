package com.example.FirstProj.AuditeeComplaint;

import com.example.FirstProj.AuditeeComplaintAssignedTo.AuditeeComplaintsAssignedToEntity;
import com.example.FirstProj.AuditeeComplaintAssignedTo.AuditeeComplaintsAssignedToRepository;
import com.example.FirstProj.ProgramInitiation.ProgramInitiationEntity;
import com.example.FirstProj.ProgramInitiation.ProgramInitiationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AuditeeComplaintService {
    @Autowired
    AuditeeComplaintRepository repository;
    @Autowired
    AuditeeComplaintsAssignedToRepository assignedToRepository;
    @Autowired
    ProgramInitiationRepository programInitiationRepository;

    public List<AuditeeComplaintEntity> getAllAuditeeComplaints(){
        List<AuditeeComplaintEntity> list=repository.findAll();
        if(list.size() > 0){
            return list;
        }else{
            return new ArrayList<AuditeeComplaintEntity>();
        }
    }
    public List<AuditeeComplaintEntity> getAllAuditeeComplaintsToProgram(String program_id){
        List<AuditeeComplaintEntity> list=repository.findByProgramInitiationEntity_id(program_id);
        if(list.size() > 0){
            return list;
        }else{
            return new ArrayList<AuditeeComplaintEntity>();
        }
    }
    public AuditeeComplaintEntity getAuditeeComplaint(String id)throws Exception{
        Optional<AuditeeComplaintEntity> auditeeComplaintEntity=repository.findById(id);
        if (auditeeComplaintEntity.isPresent()){
            return auditeeComplaintEntity.get();
        }else{
            throw new Exception("not found record !");
        }
    }

    public AuditeeComplaintEntity addAuditeeComplaint(AuditeeComplaintEntity entity, String assign_to_id, String program_id)throws Exception{
        AuditeeComplaintsAssignedToEntity assigned_entity;
        AuditeeComplaintEntity auditeeComplaintEntity;
        ProgramInitiationEntity programInitiationEntity;
        try{
            programInitiationEntity = programInitiationRepository.findById(program_id).get();
        }catch (NoSuchElementException e){
            throw new Exception("not found program");
        }
        try {
            assigned_entity = assignedToRepository.findById(assign_to_id).get();
        }catch (NoSuchElementException e){
            throw new Exception("not found assigned entity");
        }
        try{
            auditeeComplaintEntity=repository.findById(entity.getId()).get();
        }catch (NoSuchElementException e1){
            String myId = UUID.randomUUID().toString();
            entity.setId(myId);
            entity.setAuditeeComplaintsAssignedToEntity(assigned_entity);
            entity.setProgramInitiationEntity(programInitiationEntity);
            entity = repository.save(entity);
            return entity;
        }
        AuditeeComplaintEntity newEntity = entity;
        newEntity.setActionForTreating(entity.getActionForTreating());
        newEntity.setAttachments(entity.getAttachments());
        newEntity.setDate(entity.getDate());
        newEntity.setDateStamp(entity.getDateStamp());
        newEntity.setAttachments(entity.getAttachments());
        newEntity.setStatus(entity.getStatus());
        newEntity.setAuditeeComplaintsAssignedToEntity(assigned_entity);
        newEntity.setProgramInitiationEntity(programInitiationEntity);
        newEntity=repository.save(newEntity);
        return newEntity;
    }
    public String delete(String id)throws Exception{
        AuditeeComplaintEntity entity;
        try {
            entity = repository.findById(id).get();
        }catch(NoSuchElementException e){
            throw new Exception ("not found record");
        }
        repository.delete(entity);
        return "Successfully deleted!";
    }

}
