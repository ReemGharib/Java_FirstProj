package com.example.FirstProj.ProgramInitiation;

import com.example.FirstProj.FrameworkProgramInitiation.FrameworkProgramInitiationEntity;
import com.example.FirstProj.FrameworkProgramInitiation.FrameworkProgramInitiationRepository;
import com.example.FirstProj.ProgramAssignedTo.ProgramAssignedToEntity;
import com.example.FirstProj.ProgramInitiation.ProgramInitiationEntity;
import com.example.FirstProj.ProgramInitiation.ProgramInitiationRepository;
import com.example.FirstProj.StatusProgramInitiation.StatusProgramInitiationEntity;
import com.example.FirstProj.StatusProgramInitiation.StatusProgramInitiationRepository;
import com.example.FirstProj.StatusProgramInitiation.StatusProgramInitiationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProgramInitiationService {
    @Autowired
    ProgramInitiationRepository repository;
    @Autowired
    StatusProgramInitiationRepository status_repository;
    @Autowired
    FrameworkProgramInitiationRepository framework_repository;

    public List<ProgramInitiationEntity> getAllProgramInitiations(){
        List<ProgramInitiationEntity> list=repository.findAll();
        if(list.size() > 0){
            return list;
        }else{
            return new ArrayList<ProgramInitiationEntity>();
        }
    }
    public ProgramInitiationEntity getProgramInitiation(String id)throws Exception{
        Optional<ProgramInitiationEntity> program=repository.findById(id);
        if (program.isPresent()){
            return program.get();
        }else{
            throw new Exception("not found record !");
        }
    }
//    public ProgramInitiationEntity getProgramByProgramAssignedToId(String id)throws Exception {
//        ProgramInitiationEntity program;
//        try {
//             program = repository.findByProgramAssignedToId(id).get();
//        } catch (NoSuchElementException e) {
//            throw new Exception("programAssigned is not found");
//        }
//        return program;
//    }
//    public ProgramInitiationEntity getByProgramAndProgramAssignedId(String p_id, String pa_id)throws Exception{
//        Optional<ProgramInitiationEntity> program=repository.findByIdAndByProgramAssignedToId(p_id, pa_id);
//        if(program.isPresent()){
//            return program.get();
//        }else{
//            throw new Exception("record not found");
//        }
//    }
    public ProgramInitiationEntity addProgramInitiation(ProgramInitiationEntity entity, String assign_to_id, String status_id, String framework_id)throws Exception{
        ProgramAssignedToEntity assigned_entity;
        StatusProgramInitiationEntity status_entity;
        FrameworkProgramInitiationEntity framework_entity;
        ProgramInitiationEntity program;
        try{
            status_entity=status_repository.findById(status_id).get();
        }catch (NoSuchElementException e){
            throw new Exception("not found status");
        }
        try{
            framework_entity=framework_repository.findById(framework_id).get();
        }catch (NoSuchElementException e){
            throw new Exception("not found framework");
        }
         try {
             assigned_entity = repository.getProgramAssignedTo(assign_to_id);
        }catch (NoSuchElementException e){
            throw new Exception("not found assigned entity");
        }
        try{
            program=repository.findById(entity.getId()).get();
        }catch (NoSuchElementException e1){
            String myId = UUID.randomUUID().toString();
            entity.setId(myId);
            entity.setProgramAssignedToEntity(assigned_entity);
            entity.setFrameworkProgramInitiationEntity(framework_entity);
            entity.setStatusProgramInitiationEntity(status_entity);
            entity = repository.save(entity);
            return entity;
        }
                ProgramInitiationEntity newProgram = program;
                newProgram.setScopeOfAudit(entity.getScopeOfAudit());
                newProgram.setCriteriaOfAudit(entity.getCriteriaOfAudit());
                newProgram.setDate(entity.getDate());
                newProgram.setDateStamp (entity.getDateStamp());
                newProgram.setProgramAssignedToEntity(assigned_entity);
                newProgram = repository.save(newProgram);
                return newProgram;
    }
    public String delete(String id)throws Exception{
        ProgramInitiationEntity entity;
        try {
            entity = repository.findById(id).get();
        }catch(NoSuchElementException e){
            throw new Exception ("not found record");
        }
        repository.delete(entity);
        return "Successfully deleted!";
    }
}
