package com.example.FirstProj;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration

@EnableAutoConfiguration
public class MvcConfig implements WebMvcConfigurer {
//    @Autowired
//    FolderRepository folderRepository;
//    @Autowired
//    PolicyProcedureController policyProcedureController ;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        List<FolderEntity> folderEntityList = folderRepository.findAll();
//        for (int i = 0; i < folderEntityList.size(); i++) {
//            registry.addResourceHandler("/" + folderEntityList.get(i).getFolderName() + "/**")
//                    .addResourceLocations("/resources", "file:" + folderEntityList.get(i).getFolderName() + "/").setCachePeriod(0);
//            System.out.println("folder name ----" + folderEntityList.get(i).getFolderName());
//
//        }
        registry.addResourceHandler("/project/**")
                    .addResourceLocations("/resources", "file:project/").setCachePeriod(0);

    }

}
