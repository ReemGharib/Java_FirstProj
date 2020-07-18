package com.example.FirstProj.Mandatory;

import com.example.FirstProj.FrameworkProgramInitiation.FrameworkProgramInitiationEntity;
import com.example.FirstProj.FrameworkProgramInitiation.FrameworkProgramInitiationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class MandatoryService {
    @Autowired
    MandatoryRepository repository;
    @Autowired
    FrameworkProgramInitiationRepository frameworkRepository;

    public List<MandatoryEntity> getAllMandatory(){
        List<MandatoryEntity> list;
        try{
            list=repository.findAll();
        }catch (NoSuchElementException e){
            return new ArrayList<MandatoryEntity>();
        }
        return list;
    }

    public MandatoryEntity getMandatory(String id)throws Exception{
        MandatoryEntity entity;
        try{
            entity=repository.findById(id).get();
        }catch (NoSuchElementException e){
            throw new Exception("no record found!");
        }
        return entity;
    }
    public MandatoryEntity addMandatoryPerform(MandatoryEntity entity, String framework_id)throws Exception{
        MandatoryEntity mandatory;
        FrameworkProgramInitiationEntity framework;
        try{
            framework = frameworkRepository.findById(framework_id).get();
        }catch (NoSuchElementException e){
            throw new Exception("not found framework");
        }
        try{
            mandatory=repository.findById(entity.getId()).get();
        }catch (NoSuchElementException e){
            String myId= UUID.randomUUID().toString();
            entity.setId(myId);
            entity.setFrameworkEntity(framework);
            entity=repository.save(entity);
            return entity;
        }
        mandatory.setClauses(entity.getClauses());
        mandatory.setComplaint(entity.getComplaint());
        mandatory.setEvidence(entity.getEvidence());
        mandatory.setReference(entity.getReference());
        mandatory.setRequirement(entity.getRequirement());
        mandatory.setTestingSteps(entity.getTestingSteps());
        mandatory.setFrameworkEntity(framework);
        mandatory.setTitleMandatoryClauses(entity.getTitleMandatoryClauses());

        mandatory=repository.save(mandatory);
        return mandatory;
    }
    public String delete(String id)throws Exception{
        try{
            repository.findById(id);
        }catch (NoSuchElementException e){
            throw new Exception("not found record");
        }
        repository.deleteById(id);
        return "Successfully";
    }
}
