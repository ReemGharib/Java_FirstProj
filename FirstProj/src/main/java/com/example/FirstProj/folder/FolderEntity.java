package com.example.FirstProj.folder;

import com.example.FirstProj.ProgramInitiation.ProgramInitiationEntity;

import javax.persistence.*;

@Entity
@Table(name="folder")
public class FolderEntity {
    @Id
    @Column(name="id")
    String id;
    @Column(name="folder_name")
    String folderName;
    @Column(name="folder_type")
    String folderType;

    @ManyToOne
    @JoinColumn(name="program_id")
    private ProgramInitiationEntity programInitiationEntity;


    public ProgramInitiationEntity getProgramInitiationEntity() {
        return programInitiationEntity;
    }

    public void setProgramInitiationEntity(ProgramInitiationEntity programInitiationEntity) {
        this.programInitiationEntity = programInitiationEntity;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    public void setFolderType(String folderType) {
        this.folderType = folderType;
    }

    public String getId() {
        return id;
    }

    public String getFolderName() {
        return folderName;
    }

    public String getFolderType() {
        return folderType;
    }
}
