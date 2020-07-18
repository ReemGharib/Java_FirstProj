package com.example.FirstProj.SecurityControlPerform;

import com.example.FirstProj.FrameworkProgramInitiation.FrameworkProgramInitiationRepository;
import com.example.FirstProj.ProgramInitiation.ProgramInitiationEntity;
import com.example.FirstProj.ProgramInitiation.ProgramInitiationRepository;
import com.example.FirstProj.SecurityControl.SecurityControlEntity;
import com.example.FirstProj.SecurityControl.SecurityControlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
@Service
public class SecurityControlPerformService {
    @Autowired
    SecurityControlPerformRepository repository;
    @Autowired
    FrameworkProgramInitiationRepository frameworkRepository;
    @Autowired
    ProgramInitiationRepository programInitiationRepository;
    @Autowired
    SecurityControlRepository securityControlRepository;

    public List<SecurityControlPerformEntity> getAlll(String f_id){
        return repository.findByProgramInitiationEntity_frameworkProgramInitiationEntity_id(f_id);
    }
    public List<SecurityControlPerformEntity> getAllToProgram(String program_id){
        List<SecurityControlPerformEntity> list;
        try{
            list=repository.findByProgramInitiationEntity_id(program_id);
        }catch (NoSuchElementException e){
            return new ArrayList<SecurityControlPerformEntity>();
        }
        return list;
    }
    public List<SecurityControlPerformEntity> getAllSecurityControl(String framework_id, String program_id)throws Exception{

       // s =repository.findByProgramInitiationEntity_frameworkProgramInitiationEntity_id(framework_id);
        List<SecurityControlPerformEntity> s;
        s = repository.findByProgramInitiationEntity_id(program_id);
        if(s.size() > 0){//don't insert to db
            return getAllToProgram(program_id);//or should return list s;
        }
        else{
            List<SecurityControlEntity> list;
            List<SecurityControlPerformEntity> perform_list;
            perform_list = new ArrayList<SecurityControlPerformEntity>();
            list=securityControlRepository.findByframeworkEntity_id(framework_id);
            for(int i=0;i<list.size();i++){//add to sec control perform
                perform_list.add(
                        addSecurityControl(list.get(i).getId(),list.get(i).getControlAccording(),
                                list.get(i).getInitialAssessmentPoint(),
                                list.get(i).getTestingSteps(),
                                list.get(i).getConformity(),
                                list.get(i).getEvidence(),
                                list.get(i).getControlImplemented(),
                                list.get(i).getTitleSecurityControl(),
                                program_id)
                );
            }
            System.out.println("perform_list");
            return perform_list;
        }

    }
    public SecurityControlPerformEntity addSecurityControl(String id,String ControlAccording,
                    String InitialAssessmentPoint, String TestingSteps, String Conformity, String Evidence, String ControlImplemented,String title,String program_id)throws Exception{

        SecurityControlPerformEntity securityEntity = new SecurityControlPerformEntity();
        ProgramInitiationEntity programInitiationEntity;
        try{
            programInitiationEntity = programInitiationRepository.findById(program_id).get();
        }catch (NoSuchElementException e){
            throw new Exception("not found program");
        }
        String my_id= UUID.randomUUID().toString();
        securityEntity.setId(id);
        securityEntity.setConformity(Conformity);
        securityEntity.setControlAccording(ControlAccording);
        securityEntity.setEvidence(Evidence);
        securityEntity.setInitialAssessmentPoint(InitialAssessmentPoint);
        securityEntity.setTestingSteps(TestingSteps);
        securityEntity.setControlImplemented(ControlImplemented);
        securityEntity.setTitleSecurityControl(title);
        securityEntity.setId(my_id);
        securityEntity.setProgramInitiationEntity(programInitiationEntity);
        securityEntity=repository.save(securityEntity);
        return securityEntity;

    }


    public SecurityControlPerformEntity getSecurityControl(String id)throws Exception{
        SecurityControlPerformEntity securityControlPerfomEntity;
        try{
            securityControlPerfomEntity=repository.findById(id).get();
        }catch (NoSuchElementException e){
            throw new Exception("no record fou ns");
        }
        return securityControlPerfomEntity;
    }

    public SecurityControlPerformEntity update(SecurityControlPerformEntity entity)throws Exception{
        SecurityControlPerformEntity securityEntity;
        securityEntity=repository.findById(entity.getId()).get();
        SecurityControlPerformEntity controlPerformEntity=securityEntity;
        controlPerformEntity.setConformity(entity.getConformity());
        controlPerformEntity.setControlAccording(entity.getControlAccording());
        controlPerformEntity.setEvidence(entity.getEvidence());
        controlPerformEntity.setInitialAssessmentPoint(entity.getInitialAssessmentPoint());
        controlPerformEntity.setTestingSteps(entity.getTestingSteps());
        controlPerformEntity.setControlImplemented(entity.getControlImplemented());
        controlPerformEntity.setTitleSecurityControl(entity.getTitleSecurityControl());
        controlPerformEntity=repository.save(controlPerformEntity);
        return controlPerformEntity;
    }
    public String deleteSecurityControl(String id)throws Exception{
        SecurityControlPerformEntity entity;
        try{
            entity=repository.findById(id).get();
        }catch (NoSuchElementException e){
            throw new Exception("not found record");
        }
        repository.delete(entity);
        return "Successfuly deleted";
    }
}
