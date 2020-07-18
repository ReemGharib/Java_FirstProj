package com.example.FirstProj.MandatoryClausePerform;

import com.example.FirstProj.Mandatory.MandatoryEntity;
import com.example.FirstProj.Mandatory.MandatoryRepository;
import com.example.FirstProj.ProgramInitiation.ProgramInitiationEntity;
import com.example.FirstProj.ProgramInitiation.ProgramInitiationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class MandatoryClausePerformService {
    @Autowired
    MandatoryClausePerformRepository repository;
    @Autowired
    ProgramInitiationRepository programInitiationRepository;
    @Autowired
    MandatoryRepository mandatoryRepository;

    public List<MandatoryClausePerformEntity> getAll(String f_id){
        return repository.findByProgramInitiationEntity_frameworkProgramInitiationEntity_id(f_id);
    }
    public List<MandatoryClausePerformEntity> getAllToProgram(String program_id){
        List<MandatoryClausePerformEntity> list;
        try{
            list=repository.findByProgramInitiationEntity_id(program_id);
        }catch (NoSuchElementException e){
            return new ArrayList<MandatoryClausePerformEntity>();
        }
        return list;
    }
    public List<MandatoryClausePerformEntity> getAllMandatory(String framework_id, String program_id)throws Exception{
        List<MandatoryClausePerformEntity> s;
        s = repository.findByProgramInitiationEntity_id(program_id);
        if(s.size() > 0){//don't insert to db
            return getAllToProgram(program_id);
        }
        else{
            List<MandatoryEntity> list;
            List<MandatoryClausePerformEntity> perform_list;
            perform_list = new ArrayList<MandatoryClausePerformEntity>();
            list=mandatoryRepository.findByframeworkEntity_id(framework_id);
            for(int i=0;i<list.size();i++){
                perform_list.add(
                        addMandatoryPerform(list.get(i).getRequirement(),
                                list.get(i).getClauses(),
                                list.get(i).getTestingSteps(),
                                list.get(i).getComplaint(),
                                list.get(i).getEvidence(),
                                list.get(i).getTitleMandatoryClauses(),
                                list.get(i).getReference(),program_id)

                );

            }
            System.out.println("perform_list");
            return perform_list;
        }

    }

    public List<MandatoryClausePerformEntity> getAllMandatoryPerform(){
        List<MandatoryClausePerformEntity> list;
        try{
            list=repository.findAll();
        }catch (NoSuchElementException e){
            return new ArrayList<MandatoryClausePerformEntity>();
        }
        return list;
    }
//    public List<MandatoryClausePerformEntity> getAllToProgram(String program_id){
//        List<MandatoryClausePerformEntity> list;
//        try{
//            list=repository.findByProgramInitiationEntity_id(program_id);
//        }catch (NoSuchElementException e){
//            return new ArrayList<MandatoryClausePerformEntity>();
//        }
//        return list;
//    }
    public MandatoryClausePerformEntity getMandatory(String id)throws Exception{
        MandatoryClausePerformEntity entity;
        try{
            entity=repository.findById(id).get();
        }catch (NoSuchElementException e){
            throw new Exception("no record found!");
        }
        return entity;
    }
    public MandatoryClausePerformEntity addMandatoryPerform(String req,Float clauses,String testingSteps,
                                                            Boolean complaint,String ev,String title,int reference,  String program_id)throws Exception{
        MandatoryClausePerformEntity mandatory = new MandatoryClausePerformEntity();
        ProgramInitiationEntity programInitiationEntity;
        try{
            programInitiationEntity = programInitiationRepository.findById(program_id).get();
        }catch (NoSuchElementException e){
            throw new Exception("not found program");
        }
        String id = UUID.randomUUID().toString();
        mandatory.setId(id);
        mandatory.setRequirement(req);
        mandatory.setClauses(clauses);
        mandatory.setTestingSteps(testingSteps);
        mandatory.setComplaint(complaint);
        mandatory.setEvidence(ev);
        mandatory.setTitleMandatoryClauses(title);
        mandatory.setReference(reference);
        mandatory.setProgramInitiationEntity(programInitiationEntity);
        return repository.save(mandatory);
    }
    public MandatoryClausePerformEntity update(MandatoryClausePerformEntity entity)throws Exception{
        MandatoryClausePerformEntity mandatory;
        try{
            mandatory=repository.findById(entity.getId()).get();
        }catch (NoSuchElementException e){
            throw new Exception("not found record");
        }
        mandatory.setClauses(entity.getClauses());
        mandatory.setComplaint(entity.getComplaint());
        mandatory.setEvidence(entity.getEvidence());
        mandatory.setReference(entity.getReference());
        mandatory.setRequirement(entity.getRequirement());
        mandatory.setTestingSteps(entity.getTestingSteps());
        mandatory.setTitleMandatoryClauses(entity.getTitleMandatoryClauses());
        mandatory=repository.save(mandatory);
        return mandatory;
    }
    public String delete(String id)throws Exception{
        try{
            repository.findById(id);
        }catch (NoSuchElementException e){
            throw new Exception("not found record");
        }
        repository.deleteById(id);
        return "Successfully";
    }

}
