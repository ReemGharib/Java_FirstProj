package com.example.FirstProj.CorrectiveActionAttachment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CorrectiveActionAttachmentService {
    @Autowired
    CorrectiveActionAttachmentRepository repository;

    public List<CorrectiveActionAttachmentEntity> getAll(){
        List<CorrectiveActionAttachmentEntity> entity_list;
        try{
            entity_list=repository.findAll();
        }catch(NoSuchElementException e){
            return new ArrayList<CorrectiveActionAttachmentEntity>();
        }
        return  entity_list;
    }
}
