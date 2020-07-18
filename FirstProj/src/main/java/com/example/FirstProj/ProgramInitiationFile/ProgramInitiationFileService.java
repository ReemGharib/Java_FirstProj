package com.example.FirstProj.ProgramInitiationFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProgramInitiationFileService {
    @Autowired
    ProgramInitiationFileRepository repository;

    public List<ProgramInitiationFileEntity> getFiles(){
        List<ProgramInitiationFileEntity> entities;
       try {
            entities = repository.findAll();
       }catch (NoSuchElementException e){
           return new ArrayList<ProgramInitiationFileEntity>();
       }
       return entities;
    }
//    public ProgramInitiationFileEntity createOrUpdateFileEntity(ProgramInitiationFileEntity entity) {
//        ProgramInitiationFileEntity file_entity;
//        try {
//            file_entity = repository.findById(entity.id).get();
//        } catch (NoSuchElementException e) {
//            String myId = UUID.randomUUID().toString();
//            entity.id = myId;
//            entity = repository.save(entity);
//            return entity;
//        }
//        //update
//        ProgramInitiationFileEntity file = file_entity;
//        file.date = entity.date;
//        file.dateStamp = entity.dateStamp;
//        file=repository.save(file);
//        return file;
//    }

}
