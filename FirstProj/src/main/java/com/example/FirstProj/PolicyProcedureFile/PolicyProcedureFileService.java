package com.example.FirstProj.PolicyProcedureFile;

import com.example.FirstProj.PolicyProcedureFile.PolicyProcedureFileEntity;
import com.example.FirstProj.PolicyProcedureFile.PolicyProcedureFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

@Service
public class PolicyProcedureFileService {
    @Autowired
    PolicyProcedureFileRepository repository;

    public List<PolicyProcedureFileEntity> getAllPolicyFile(){
        List<PolicyProcedureFileEntity> list=repository.findAll();
        if(list.size() > 0){
            return list;
        }
        else{
            return new ArrayList<PolicyProcedureFileEntity>();
        }
    }
    public PolicyProcedureFileEntity getProcedureEntity(String id)throws Exception{
        Optional<PolicyProcedureFileEntity> entity=repository.findById(id);
        if(entity.isPresent()){
            return entity.get();
        }else{
            throw new Exception("record not found");
        }

    }
    public PolicyProcedureFileEntity createOrUpdateEntity(PolicyProcedureFileEntity entity){
        Optional<PolicyProcedureFileEntity> updateEntity=repository.findById(entity.getId());
        if(updateEntity.isPresent()){
            PolicyProcedureFileEntity newEntity=updateEntity.get();
            newEntity.setFileName(entity.getFileName());
            newEntity.setDate(entity.getDate());
            newEntity.setDateStamp(entity.getDateStamp());
            newEntity=repository.save(newEntity);
            return newEntity;
        }
        else {
            String my_id=UUID.randomUUID().toString();
            entity.setId(my_id);
            entity=repository.save(entity);
            return entity;
        }
    }
    public Stream<Path> loadAll() throws Exception{
        Path rootLocation = Paths.get("./uploaded");
//        try {
            return Files.walk(rootLocation, 1).filter(path -> !path.equals(rootLocation)).map(rootLocation::relativize);
//        } catch (NoSuchElementException e) {
//            e.printStackTrace();
//        }
    }
}
