package com.example.FirstProj.SecurityControl;

import com.example.FirstProj.FrameworkProgramInitiation.FrameworkProgramInitiationEntity;
import com.example.FirstProj.FrameworkProgramInitiation.FrameworkProgramInitiationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class SecurityControlService {
    @Autowired
    SecurityControlRepository repository;
    @Autowired
    FrameworkProgramInitiationRepository frameworkRepository;
    public List<SecurityControlEntity> getAllSecurityControl(){
        List<SecurityControlEntity> list;
        try{
            list=repository.findAll();
        }catch (NoSuchElementException e){
            return new ArrayList<SecurityControlEntity>();
        }
        return list;
    }
    public SecurityControlEntity getSecurityControl(String id)throws Exception{
        SecurityControlEntity securityControlEntity;
        try{
            securityControlEntity=repository.findById(id).get();
        }catch (NoSuchElementException e){
            throw new Exception("no record fou ns");
        }
        return securityControlEntity;
    }
    public SecurityControlEntity addSecurityControl(SecurityControlEntity entity, String framework_id)throws Exception{
        SecurityControlEntity securityEntity;
        FrameworkProgramInitiationEntity framework;
        try{
            framework = frameworkRepository.findById(framework_id).get();
        }catch (NoSuchElementException e){
            throw new Exception("not found framework");
        }
        try {
            securityEntity=repository.findById(entity.getId()).get();
        }catch (NoSuchElementException e){
            String my_id= UUID.randomUUID().toString();
            entity.setId(my_id);
            entity.setFrameworkEntity(framework);
            entity=repository.save(entity);
            return entity;
        }
        SecurityControlEntity controlPerformEntity=securityEntity;
        controlPerformEntity.setConformity(entity.getConformity());
        controlPerformEntity.setControlAccording(entity.getControlAccording());
        controlPerformEntity.setEvidence(entity.getEvidence());
        controlPerformEntity.setInitialAssessmentPoint(entity.getInitialAssessmentPoint());
        controlPerformEntity.setTestingSteps(entity.getTestingSteps());
        controlPerformEntity.setControlImplemented(entity.getControlImplemented());
        controlPerformEntity.setTitleSecurityControl(entity.getTitleSecurityControl());
        controlPerformEntity.setFrameworkEntity(framework);
        controlPerformEntity=repository.save(controlPerformEntity);
        return controlPerformEntity;
    }
    public String deleteSecurityControl(String id)throws Exception{
        SecurityControlEntity entity;
        try{
            entity=repository.findById(id).get();
        }catch (NoSuchElementException e){
            throw new Exception("not found record");
        }
        repository.delete(entity);
        return "Successfully deleted";
    }
}
