package com.example.FirstProj.NonConformities;

import com.example.FirstProj.NonconformityClassification.NonconformityClassificationEntity;
import com.example.FirstProj.NonconformityClassification.NonconformityClassificationRepository;
import com.example.FirstProj.ProgramInitiation.ProgramInitiationEntity;
import com.example.FirstProj.ProgramInitiation.ProgramInitiationRepository;
import com.fasterxml.jackson.databind.deser.CreatorProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class NonConformityService {
    @Autowired
    NonConformityRepository repository;
    @Autowired
    NonconformityClassificationRepository classificationRepository;
    @Autowired
    ProgramInitiationRepository programInitiationRepository;

    public List<NonConformityEntity> getAllNonConformity(){
        List<NonConformityEntity> list;
        try{
            list= repository.findAll();
        }catch (NoSuchElementException e){
            return new ArrayList<NonConformityEntity>();
        }
        return list;
    }
    public List<NonConformityEntity> getAllNonConformityToProgram(String program_id){
        List<NonConformityEntity> list;
        try{
            list = repository.findByProgramInitiationEntity_id(program_id);
        }catch (NoSuchElementException e){
            return new ArrayList<NonConformityEntity>();
        }
        return list;
    }

    public NonConformityEntity getNonConformity(String id)throws Exception{
        NonConformityEntity entity;
        try{
            entity=repository.findById(id).get();
        }catch (NoSuchElementException e){
            throw new Exception("not found record");
        }
        return entity;
    }
    public NonConformityEntity addEntity(NonConformityEntity entity, String classification_id, String program_id)throws Exception{
        NonConformityEntity nonConformityEntity;
        NonconformityClassificationEntity classificationEntity;
        ProgramInitiationEntity programInitiationEntity;
        try {
            programInitiationEntity = programInitiationRepository.findById(program_id).get();
        }catch (NoSuchElementException e){
            throw new Exception("not found program");
        }
        try{
            classificationEntity = classificationRepository.findById(classification_id).get();
        }catch (NoSuchElementException e){
            throw new Exception("not found classification");
        }
        try {
            nonConformityEntity=repository.findById(entity.getId()).get();
        }catch (NoSuchElementException e){
            String idd= UUID.randomUUID().toString();
            entity.setId(idd);
            entity.setNonconformityClassificationEntity(classificationEntity);
            entity.setProgramInitiationEntity(programInitiationEntity);
            entity=repository.save(entity);
            return entity;
        }
        NonConformityEntity conformityEntity=entity;
        conformityEntity.setAcknowledgmentAuditee(entity.getAcknowledgmentAuditee());
        conformityEntity.setAuditCriteria(entity.getAuditCriteria());
        conformityEntity.setClauseNumber(entity.getClauseNumber());
        conformityEntity.setDateStamp(entity.getDateStamp());
        conformityEntity.setDomain(entity.getDomain());
        conformityEntity.setFindings(entity.getFindings());
        conformityEntity.setIdentifyingDate(entity.getIdentifyingDate());
        conformityEntity.setReference(entity.getReference());
        conformityEntity.setNonconformityClassificationEntity(classificationEntity);
        conformityEntity.setProgramInitiationEntity(programInitiationEntity);
        conformityEntity=repository.save(conformityEntity);
        return conformityEntity;
    }
    public String delete(String id)throws Exception{
        NonConformityEntity entity;
        try {
            entity=repository.findById(id).get();
        }catch (NoSuchElementException e){
            throw new Exception("no record found!");
        }
        repository.delete(entity);
        return "Successfully deleted!";
    }
}