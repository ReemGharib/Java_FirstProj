package com.example.FirstProj.NonconformityFile;

import com.example.FirstProj.SecurityControlsFiles.SecurityControlFileEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class NonconformityFileService {
    @Autowired
    NonconformityFileRepository repository;

    public List<NonconformityFileEntity> getFiles(){
        List<NonconformityFileEntity> entities;
        try {
            entities = repository.findAll();
        }catch (NoSuchElementException e){
            return new ArrayList<NonconformityFileEntity>();
        }
        return entities;
    }


}
