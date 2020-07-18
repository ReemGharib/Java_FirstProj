package com.example.FirstProj.ProgramInitiation;

import com.example.FirstProj.ProgramInitiationFile.ProgramInitiationFileEntity;
import com.example.FirstProj.ProgramInitiationFile.ProgramInitiationFileRepository;
import com.example.FirstProj.SecurityControlsFiles.SecurityControlFileEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("ProgramInitiation")
@CrossOrigin(allowedHeaders = "*" , origins = "*")

public class ProgramInitiationController {
    @Autowired
    ProgramInitiationService service;
    @Autowired
    ProgramInitiationFileRepository repository;

    @GetMapping
    public ResponseEntity<List<ProgramInitiationEntity>> getAllProgramInitiations(){
        List<ProgramInitiationEntity> list=service.getAllProgramInitiations();
        return new ResponseEntity<List<ProgramInitiationEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }
    @GetMapping("getProgramInitiation/{id}")
    public ResponseEntity<ProgramInitiationEntity> getProgramInitiation(@PathVariable("id") String id)throws Exception{
        ProgramInitiationEntity program=service.getProgramInitiation(id);
        return new ResponseEntity<ProgramInitiationEntity>(program, new HttpHeaders(), HttpStatus.OK);
    }

//
//    @GetMapping("getByProgramAssignedToId/{id}")
//    public ProgramInitiationEntity getByProgramAssignedToId(@PathVariable("id") String id)throws Exception{
//        ProgramInitiationEntity program=service.getProgramByProgramAssignedToId(id);
//        return program;
//    }
//    @GetMapping("getByProgramAssignedToId/{p_id}/{pa_id}")
//    public ResponseEntity<ProgramInitiationEntity> getByProgramAssignedToId(@PathVariable("p_id") String p_id, @PathVariable("pa_id") String pa_id)throws Exception{
//        ProgramInitiationEntity program=service.getByProgramAndProgramAssignedId(p_id,pa_id);
//        return new ResponseEntity<ProgramInitiationEntity>(program, new HttpHeaders(), HttpStatus.OK);
//    }
    @PostMapping("addProgramInitiation/{assign_id}/{status_id}/{framework_id}")
    public ResponseEntity<ProgramInitiationEntity> addProgramInitiation(@RequestBody ProgramInitiationEntity entity,
                                                                        @PathVariable("assign_id") String assign_id,
                                                                        @PathVariable("status_id") String status_id,
                                                                        @PathVariable("framework_id")String framework_id)throws Exception{
        ProgramInitiationEntity programInitiationEntity=service.addProgramInitiation(entity,assign_id,status_id,framework_id);
        return new ResponseEntity<ProgramInitiationEntity>(programInitiationEntity, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("deleteProgram/{id}")
    public String deleteProgram(@PathVariable("id")String id)throws Exception{
        return service.delete(id);
    }

}
