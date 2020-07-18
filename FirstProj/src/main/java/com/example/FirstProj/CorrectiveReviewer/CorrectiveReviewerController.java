package com.example.FirstProj.CorrectiveReviewer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("CorrectiveReviewer")
@CrossOrigin(allowedHeaders = "*" , origins = "*")
public class CorrectiveReviewerController {
    @Autowired
    CorrectiveReviewerService service;

    @GetMapping
    public List<CorrectiveReviewerEntity> getAllCorrectiveReviewers(){
        List<CorrectiveReviewerEntity> entity=service.getAll();
        return entity;
    }
    @GetMapping("getCorrectiveReviewer/{id}")
    public CorrectiveReviewerEntity getCorrectiveReviewer(@PathVariable("id")String id)throws Exception{
        CorrectiveReviewerEntity entity=service.getReviewer(id);
        return entity;
    }
    @PostMapping("addCorrectiveReviewer")
    public CorrectiveReviewerEntity addCorrectiveReviewer(@RequestBody CorrectiveReviewerEntity entity){
        CorrectiveReviewerEntity reviewerEntity=service.addReviewer(entity);
        return reviewerEntity;
    }
    @DeleteMapping("deleteCorrectiveReviewer/{id}")
    public String delete(@PathVariable("id")String id)throws Exception{
        return service.delete(id);
    }
}
