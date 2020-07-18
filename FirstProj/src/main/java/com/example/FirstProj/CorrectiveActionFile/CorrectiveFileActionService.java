package com.example.FirstProj.CorrectiveActionFile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
@Service
public class CorrectiveFileActionService {
    @Autowired
    CorrectiveFileActionRepository repository;

    public List<CorrectiveActionFileEntity> getFiles(){
        List<CorrectiveActionFileEntity> entities;
        try {
            entities = repository.findAll();
        }catch (NoSuchElementException e){
            return new ArrayList<CorrectiveActionFileEntity>();
        }
        return entities;
    }
}
