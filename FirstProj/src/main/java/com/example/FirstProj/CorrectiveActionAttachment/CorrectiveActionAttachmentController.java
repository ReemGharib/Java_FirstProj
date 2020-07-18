package com.example.FirstProj.CorrectiveActionAttachment;

import com.example.FirstProj.CorrectiveAction.CorrectiveActionEntity;
import com.example.FirstProj.CorrectiveAction.CorrectiveActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
@RequestMapping("CorrectiveActionAttachment")
public class CorrectiveActionAttachmentController {
    @Autowired
    CorrectiveActionAttachmentService service;
    @Autowired
    CorrectiveActionAttachmentRepository repository;
    @Autowired
    CorrectiveActionRepository actionRepository;

    @GetMapping
    public List<CorrectiveActionAttachmentEntity> getAll(){
        List<CorrectiveActionAttachmentEntity> list=service.getAll();
        return list;
    }
    @PostMapping(value="uploadFile/{action_id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public CorrectiveActionAttachmentEntity uploadFile(@RequestParam("file") MultipartFile file, @PathVariable("action_id")String action_id)throws Exception{
        CorrectiveActionEntity actionEntity;
        try {
            actionEntity = actionRepository.findById(action_id).get();
        }catch(NoSuchElementException e){
            throw new Exception("not found action corr");
        }
        String myId= UUID.randomUUID().toString();
        CorrectiveActionAttachmentEntity entity=new CorrectiveActionAttachmentEntity();
        entity.setId(myId);
        entity.setFileName(myId + file.getOriginalFilename());
        entity.setCorrectiveActionEntity(actionEntity);
        entity=repository.save(entity);
        File convertFile=new File("./attachedFileNonconformity/" + myId + file.getOriginalFilename());
        convertFile.createNewFile();
        FileOutputStream f_out=new FileOutputStream(convertFile);
        f_out.write(file.getBytes());
        f_out.close();
        return entity;
    }
}
