package com.example.FirstProj.FrameworkProgramInitiation;


import com.example.FirstProj.Mandatory.MandatoryEntity;
import com.example.FirstProj.ProgramInitiation.ProgramInitiationEntity;
import com.example.FirstProj.SecurityControl.SecurityControlEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="frameworkprograminitiation")
public class FrameworkProgramInitiationEntity {
    @Id
    @Column(name="id")
    String id;
    @Column(name="framework")
    String framework;

    @OneToMany(mappedBy = "frameworkProgramInitiationEntity", targetEntity= ProgramInitiationEntity.class, fetch=FetchType.LAZY)
    @JsonIgnore
    List<ProgramInitiationEntity> programInitiationEntityList;

    @OneToMany(mappedBy = "frameworkEntity", targetEntity = SecurityControlEntity.class, fetch=FetchType.LAZY)
    @JsonIgnore
    List<SecurityControlEntity> securityControlEntityList;

    @OneToMany(mappedBy = "frameworkEntity", targetEntity = MandatoryEntity.class, fetch=FetchType.LAZY)
    @JsonIgnore
    List<MandatoryEntity> frameworkEntity;

    public List<SecurityControlEntity> getSecurityControlEntityList() {
        return securityControlEntityList;
    }

    public void setSecurityControlEntityList(List<SecurityControlEntity> securityControlEntityList) {
        this.securityControlEntityList = securityControlEntityList;
    }

    public void setProgramInitiationEntityList(List<ProgramInitiationEntity> programInitiationEntityList) {
        this.programInitiationEntityList = programInitiationEntityList;
    }
    public List<ProgramInitiationEntity> getProgramInitiationEntityList() {
        return programInitiationEntityList;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public void setFramework(String framework) {
        this.framework = framework;
    }

    public String getFramework() {
        return framework;
    }
}
