package com.example.FirstProj.folder;


import com.example.FirstProj.ProgramInitiation.ProgramInitiationEntity;
import com.example.FirstProj.ProgramInitiation.ProgramInitiationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class FolderService {
    @Autowired
    FolderRepository repository;
    @Autowired
    ProgramInitiationRepository programRepository;

    public List<FolderEntity> getAll(){
        List<FolderEntity> list;
        try{
            list=repository.findAll();
        }catch(NoSuchElementException e){
            return new ArrayList<FolderEntity>();
        }
        return list;
    }

    public FolderEntity getFolder(String id)throws Exception{
        FolderEntity entity;
        try{
            entity = repository.findById(id).get();
        }catch (NoSuchElementException e){
            throw new Exception("not found record");
        }
        return entity;
    }
    public FolderEntity addFolder(FolderEntity entity,String program_id) throws IOException {
        String myId= UUID.randomUUID().toString();
        FolderEntity folderEntity;
        ProgramInitiationEntity program;
        program = programRepository.findById(program_id).get();

        try{
            folderEntity=repository.findById(entity.getId()).get();
        }catch (NoSuchElementException e){
            entity.setId(myId);
            entity.setProgramInitiationEntity(program);
            return repository.save(entity);
        }
        folderEntity.setFolderName(entity.getFolderName());
        folderEntity.setFolderType(entity.getFolderType());
        folderEntity.setProgramInitiationEntity(program);
        return repository.save(folderEntity);
    }
    public List<FolderEntity> getAllFolderType(String type, String program_id)throws Exception{
        List<FolderEntity> list;
        ProgramInitiationEntity program;
        try{
            program = programRepository.findById(program_id).get();
        }catch (NoSuchElementException e){
            throw new Exception("not found program");
        }
//        try{
//            list=repository.findByFolderType(type);
//        }catch (NoSuchElementException e){
//            throw new Exception("not found record");
//        }
        try{
            list = repository.findByFolderTypeAndProgramInitiationEntity_id(type, program_id);
        }catch (NoSuchElementException e){
            throw new Exception("not found records");
        }

        return list;
    }
    public void delete(String id)throws Exception{
        FolderEntity entity;
        try{
            entity = repository.findById(id).get();
        }catch (NoSuchElementException e){
            throw new Exception("record not found!");
        }
         repository.delete(entity);
    }
}
