package com.example.FirstProj.NonconformityAttachment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class NonconformityAttachmentService {
    @Autowired
    NonconformityAttachmentRepository repository;

    public List<NonconformityAttachmentEntity> getAllNonconformityAttachment(){
        List<NonconformityAttachmentEntity> list;
        try {
            list=repository.findAll();
        }catch (NoSuchElementException e){
            return new ArrayList<NonconformityAttachmentEntity>();
        }
        return list;
    }
}

