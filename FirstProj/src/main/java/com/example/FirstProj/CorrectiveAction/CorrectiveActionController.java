package com.example.FirstProj.CorrectiveAction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("CorrectiveAction")
@CrossOrigin(allowedHeaders = "*" , origins = "*")
public class CorrectiveActionController {
    @Autowired
    CorrectiveActionService service;

    @GetMapping
    public List<CorrectiveActionEntity> getAll(){
        List<CorrectiveActionEntity> list=service.getAll();
        return list;
    }
    @GetMapping("getAllToProgram/{program_id}")
    public List<CorrectiveActionEntity> getAllToProgram(@PathVariable("program_id")String program_id){
        List<CorrectiveActionEntity> list=service.getAllToProgram(program_id);
        return list;
    }
    @GetMapping("getCorrectiveAction/{id}")
    public CorrectiveActionEntity getCorrectiveAction(@PathVariable("id")String id)throws Exception{
        CorrectiveActionEntity entity=service.getCorrectiveAction(id);
        return entity;
    }
    @PostMapping("addCorrectiveAction/{reviewer_id}/{assign_id}/{program_id}")
    public CorrectiveActionEntity addCorrectiveAction(@RequestBody CorrectiveActionEntity entity,
                                                      @PathVariable("reviewer_id")String reviewer_id,
                                                      @PathVariable("assign_id")String assign_id,
                                                      @PathVariable("program_id")String program_id)throws Exception{
        CorrectiveActionEntity actionEntity=service.add(entity,reviewer_id,assign_id, program_id);
        return actionEntity;
    }
    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable("id")String id)throws Exception{
        return service.delete(id);
    }
}
