package com.example.FirstProj.folder;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@RestController
@RequestMapping("folder")
@CrossOrigin(allowedHeaders = "*" , origins = "*")
public class FolderController {
    @Autowired
    FolderService service;
    @Autowired
    FolderRepository repository;

    @GetMapping
    public List<FolderEntity> getAll(){
        List<FolderEntity> list=service.getAll();
        return list;
    }
    @GetMapping("getFolder/{id}")
    public FolderEntity getFolder(@PathVariable("id")String id)throws Exception{
        FolderEntity entity=service.getFolder(id);

        return entity;
    }
    @PostMapping("addFolder/{program_id}")
    public  FolderEntity addFolder(@RequestBody FolderEntity entity, @PathVariable("program_id")String program_id)throws Exception{
        FolderEntity folder=service.addFolder(entity, program_id);
        return folder;
    }
    @GetMapping("getAllByType/{type}/{program_id}")
    public List<FolderEntity> getAllByType(@PathVariable("type") String type, @PathVariable("program_id")String program_id)throws Exception{
        List<FolderEntity> list=service.getAllFolderType(type, program_id);
        return list;
    }
//    @GetMapping("checkFolderExists/{folderName}")
//    public String check(@PathVariable("folderName") String folderName)throws Exception {
//        List<FolderEntity> folderEntity;
//        File file = new File("./" + folderName);
//        try{
//            folderEntity = repository.findByFolderName(folderName);
//        }catch (NoSuchElementException e){
//            throw new Exception("is not exists in db");
//        }
//        if(!file.exists()){
//            repository.deleteAll(folderEntity);
//            return "deleted";
//        }
//        else{
//            return "is exists";
//        }
//    }

    @GetMapping("/listFiles/{dir}")
    public Set<String> listFilesUsingDirectoryStream(@PathVariable("dir")String dir) throws IOException {
        Set<String> fileList = new HashSet<>();
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get("project/" + dir))) {
            for (Path path : stream) {
                if (!Files.isDirectory(path)) {
                    fileList.add(path.getFileName()
                            .toString());
                }
            }
        }
        return fileList;
    }
    @DeleteMapping("deleteFolder/{id}")
    public void delete(@PathVariable("id") String id)throws Exception{
        service.delete(id);
    }

}