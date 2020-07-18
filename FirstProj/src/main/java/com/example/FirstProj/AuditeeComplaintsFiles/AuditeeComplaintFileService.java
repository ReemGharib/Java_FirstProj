package com.example.FirstProj.AuditeeComplaintsFiles;

import com.example.FirstProj.SecurityControlsFiles.SecurityControlFileEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AuditeeComplaintFileService {
    @Autowired
    AuditeeComplaintFileRepository repository;

    public List<AuditeeComplaintFileEntity> getFiles(){
        List<AuditeeComplaintFileEntity> entities;
        try {
            entities = repository.findAll();
        }catch (NoSuchElementException e){
            return new ArrayList<AuditeeComplaintFileEntity>();
        }
        return entities;
    }
}
