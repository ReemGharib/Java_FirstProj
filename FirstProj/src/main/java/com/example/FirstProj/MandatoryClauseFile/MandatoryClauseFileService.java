package com.example.FirstProj.MandatoryClauseFile;

import com.example.FirstProj.MandatoryClausePerform.MandatoryClausePerformRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class MandatoryClauseFileService {
    @Autowired
    MandatoryClauseFileRepository repository;
    public List<MandatoryClauseFileEntity> getAllMandatoryFile(){
        List<MandatoryClauseFileEntity> list;
        try{
            list=repository.findAll();
        }catch (NoSuchElementException e){
            return new ArrayList<MandatoryClauseFileEntity>();
        }
        return list;
    }
    public MandatoryClauseFileEntity getMandatoryFile(String id)throws Exception{
        MandatoryClauseFileEntity entity;
        try{
            entity=repository.findById(id).get();
        }catch (NoSuchElementException e){
            throw new Exception("not found record!");
        }
        return entity;
    }
}
