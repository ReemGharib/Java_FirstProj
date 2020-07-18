package com.example.FirstProj.PolicyProcedureFile;

import com.example.FirstProj.folder.FolderEntity;
import com.example.FirstProj.folder.FolderRepository;
import com.example.FirstProj.folder.FolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.IntStream;

import static java.nio.file.StandardOpenOption.CREATE;

@RestController
@RequestMapping("policyprocedures")
@CrossOrigin(allowedHeaders = "*" , origins = "*")
public class PolicyProcedureController {
    @Autowired
    PolicyProcedureFileService service;
    @Autowired
    PolicyProcedureFileRepository repository;
    @Autowired
    FolderRepository folderRepository;

    @Autowired
    FolderService folderService;

    @GetMapping
    public List<PolicyProcedureFileEntity> getAllPolicyProcedureFiles() {
        return service.getAllPolicyFile();
//        return new ResponseEntity<List<PolicyProcedureFileEntity>>(list , new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @GetMapping("getProcedureFile/{id}")
    public ResponseEntity<PolicyProcedureFileEntity> getProcedureFile(@PathVariable("id") String id) throws Exception {
        PolicyProcedureFileEntity entity = service.getProcedureEntity(id);
        return new ResponseEntity<PolicyProcedureFileEntity>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping("CreateOrUpdateEntity")
    public ResponseEntity<PolicyProcedureFileEntity> createOrUpdateEntity(@RequestBody PolicyProcedureFileEntity entity) {
        PolicyProcedureFileEntity fileEntity = service.createOrUpdateEntity(entity);
        return new ResponseEntity<PolicyProcedureFileEntity>(fileEntity, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping("makeDirectory/{folder_name}")
    public void createFolder(@PathVariable("folder_name") String folder_name) throws IOException {
        FolderEntity folder;
        File file = new File("./project/" + folder_name);
        if (!file.exists()) {
            if (file.mkdir()) {
                System.out.println("Directory is created!");

            } else {
                System.out.println("Failed to create directory!");
            }
        }
    }


    @PostMapping(value = "uploadFileToFolder/{folderName}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<PolicyProcedureFileEntity> uploadFile(@RequestParam("file") MultipartFile file, @PathVariable("folderName") String folderName) throws Exception {
        PolicyProcedureFileEntity newEntity = new PolicyProcedureFileEntity();
        String my_id = UUID.randomUUID().toString();
        newEntity.setFileName(my_id + file.getOriginalFilename());
        newEntity.setId(my_id);
        newEntity = repository.save(newEntity);
        File convertFile = new File("./project/" + folderName + "/" + my_id + file.getOriginalFilename());
        convertFile.createNewFile();
        FileOutputStream f_out = new FileOutputStream(convertFile);
        f_out.write(file.getBytes());
        f_out.close();
        return new ResponseEntity<PolicyProcedureFileEntity>(newEntity, new HttpHeaders(), HttpStatus.OK);
    }

}