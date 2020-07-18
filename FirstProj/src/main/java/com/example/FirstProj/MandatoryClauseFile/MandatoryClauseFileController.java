package com.example.FirstProj.MandatoryClauseFile;

import com.example.FirstProj.ProgramInitiationFile.ProgramInitiationFileEntity;
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
@RequestMapping("MandatoryClauseFile")
@CrossOrigin(allowedHeaders = "*" , origins = "*")
public class MandatoryClauseFileController {
    @Autowired
    MandatoryClauseFileService service;
    @Autowired
    MandatoryClauseFileRepository repository;

    @GetMapping
    public List<MandatoryClauseFileEntity> getAllMandatoryFile(){
        List<MandatoryClauseFileEntity> list=service.getAllMandatoryFile();
        return list;
    }
    @GetMapping("getMandatoryFile/{id}")
    public MandatoryClauseFileEntity getMandatoryFile(@PathVariable("id")String id)throws Exception{
        MandatoryClauseFileEntity entity=service.getMandatoryFile(id);
        return entity;
    }


    @PostMapping("makeDirectory/{folder_name}")
    public void createFolder(@PathVariable("folder_name")String folder_name){
        File file = new File("./project/"+ folder_name);
        if (!file.exists()) {
            if (file.mkdir()) {
                System.out.println("Directory is created!");
            } else {
                System.out.println("Failed to create directory!");
            }
        }
    }

    @PostMapping(value = "uploadFileToFolder/{folderName}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<MandatoryClauseFileEntity> uploadFile(@RequestParam("file") MultipartFile file, @PathVariable("folderName") String folderName)throws Exception{
        MandatoryClauseFileEntity newEntity=new MandatoryClauseFileEntity();
        String my_id= UUID.randomUUID().toString();
        newEntity.setFileName(my_id + file.getOriginalFilename());
        newEntity.setId(my_id);
        newEntity=repository.save(newEntity);
        File convertFile=new File("./project/" + folderName + "/" + my_id + file.getOriginalFilename());
        convertFile.createNewFile();
        FileOutputStream f_out=new FileOutputStream(convertFile);
        f_out.write(file.getBytes());
        f_out.close();
        return new ResponseEntity<MandatoryClauseFileEntity>(newEntity, new HttpHeaders(), HttpStatus.OK);
    }
}
