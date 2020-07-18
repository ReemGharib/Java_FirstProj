package com.example.FirstProj.NonconformityAttachment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("NonconformityAttachment")
public class NonconformityAttachmentController {
    @Autowired
    NonconformityAttachmentService service;
    @Autowired
    NonconformityAttachmentRepository repository;
    @GetMapping
    public List<NonconformityAttachmentEntity> getAllNonconformityAttachment(){
        List<NonconformityAttachmentEntity> list=service.getAllNonconformityAttachment();
        return list;
    }
    @PostMapping(value="attach", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public NonconformityAttachmentEntity attach(@RequestParam("file") MultipartFile file)throws Exception{
        String myId= UUID.randomUUID().toString();
        NonconformityAttachmentEntity entity=new NonconformityAttachmentEntity();
        entity.setId(myId);
        entity.setFilename(myId + file.getOriginalFilename());
        File convertFile=new File("./attachedFileNonconformity/" +entity.getFilename());
        convertFile.createNewFile();
        FileOutputStream f_out=new FileOutputStream(convertFile);
        f_out.write(file.getBytes());
        f_out.close();
        entity=repository.save(entity);
        return entity;
    }
}
