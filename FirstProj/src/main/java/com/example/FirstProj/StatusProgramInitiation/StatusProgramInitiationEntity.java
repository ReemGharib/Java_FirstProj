package com.example.FirstProj.StatusProgramInitiation;

import com.example.FirstProj.ProgramInitiation.ProgramInitiationEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="statusprograminitiation")
public class StatusProgramInitiationEntity {
    @Id
    @Column(name="id")
    String id;
    @Column(name="status")
    String status;

    @OneToMany(mappedBy = "statusProgramInitiationEntity", targetEntity= ProgramInitiationEntity.class, fetch=FetchType.LAZY)
    @JsonIgnore
    List<ProgramInitiationEntity> programInitiationEntities;

    public List<ProgramInitiationEntity> getProgramInitiationEntities() {
        return programInitiationEntities;
    }

    public void setProgramInitiationEntities(List<ProgramInitiationEntity> programInitiationEntities) {
        this.programInitiationEntities = programInitiationEntities;
    }

    public String getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
