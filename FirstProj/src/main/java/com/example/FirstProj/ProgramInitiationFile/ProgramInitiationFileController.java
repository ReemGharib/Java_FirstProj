package com.example.FirstProj.ProgramInitiationFile;

import com.example.FirstProj.PolicyProcedureFile.PolicyProcedureFileEntity;
import com.example.FirstProj.folder.FolderEntity;
import com.example.FirstProj.folder.FolderRepository;
import com.example.FirstProj.folder.FolderService;
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
@RequestMapping("ProgramInitiationFile")
@CrossOrigin(allowedHeaders = "*" , origins = "*")
public class ProgramInitiationFileController {
    @Autowired
    ProgramInitiationFileService service;
    @Autowired
    ProgramInitiationFileRepository repository;
    @Autowired
    FolderService folderService;

    @GetMapping
    public List<ProgramInitiationFileEntity> getProgramFileEntity(){
        List<ProgramInitiationFileEntity> files = service.getFiles();
        return files;
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
    public ResponseEntity<ProgramInitiationFileEntity> uploadFile(@RequestParam("file") MultipartFile file, @PathVariable("folderName") String folderName)throws Exception{
        ProgramInitiationFileEntity newEntity=new ProgramInitiationFileEntity();
        String my_id= UUID.randomUUID().toString();
        newEntity.setFileName(my_id + file.getOriginalFilename());
        newEntity.setId(my_id);
        newEntity=repository.save(newEntity);
        File convertFile=new File("./project/" + folderName + "/" + my_id + file.getOriginalFilename());
        convertFile.createNewFile();
        FileOutputStream f_out=new FileOutputStream(convertFile);
        f_out.write(file.getBytes());
        f_out.close();
        return new ResponseEntity<ProgramInitiationFileEntity>(newEntity, new HttpHeaders(), HttpStatus.OK);
    }
}
