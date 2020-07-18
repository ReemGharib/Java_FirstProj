package com.example.FirstProj.SecurityControlsFiles;

import com.example.FirstProj.ProgramInitiationFile.ProgramInitiationFileEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
@Service
public class SecurityControlFileService {
    @Autowired
    SecurityControlFileRepository repository;

    public List<SecurityControlFileEntity> getFiles(){
        List<SecurityControlFileEntity> entities;
        try {
            entities = repository.findAll();
        }catch (NoSuchElementException e){
            return new ArrayList<SecurityControlFileEntity>();
        }
        return entities;
    }
}
