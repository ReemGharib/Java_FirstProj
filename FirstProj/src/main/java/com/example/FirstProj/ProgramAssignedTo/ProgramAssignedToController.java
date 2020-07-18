package com.example.FirstProj.ProgramAssignedTo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ProgramAssignedTo")
@CrossOrigin(allowedHeaders = "*" , origins = "*")

public class ProgramAssignedToController {
    @Autowired
    ProgramAssignedToService service;

    @GetMapping
    public ResponseEntity<List<ProgramAssignedToEntity>>getAllProgramAssignedEntities(){
        List<ProgramAssignedToEntity> list=service.getAllProgramAssigned();
        return new ResponseEntity<List<ProgramAssignedToEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }
    @GetMapping("getProgramAssigned/{id}")
    public ProgramAssignedToEntity programAssignedTo(@PathVariable("id")String id)throws Exception{
        ProgramAssignedToEntity programAssignedToEntity=service.getProgramAssigned(id);
        return programAssignedToEntity;
    }
    @PostMapping("addProgramAssignedTo")
    public ResponseEntity<ProgramAssignedToEntity> addProgramAssignedTo(@RequestBody ProgramAssignedToEntity entity){
        ProgramAssignedToEntity program_entity=service.addProgramAssigned(entity);
        return new ResponseEntity<ProgramAssignedToEntity>(program_entity, new HttpHeaders(), HttpStatus.OK);
    }
}
