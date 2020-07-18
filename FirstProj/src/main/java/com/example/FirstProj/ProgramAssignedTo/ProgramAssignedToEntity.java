package com.example.FirstProj.ProgramAssignedTo;

import com.example.FirstProj.ProgramInitiation.ProgramInitiationEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name ="programassignedto")
public class ProgramAssignedToEntity {
    @Id
    @Column(name="id")
    private String id;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="date")
    private Date date;
    @Column(name = "date_stamp")
    private Date dateStamp;

    @OneToMany(targetEntity= ProgramInitiationEntity.class, mappedBy="programAssignedToEntity", fetch=FetchType.LAZY)
    @JsonIgnore
    private List<ProgramInitiationEntity> programInitiationEntityList;
    public void setId(String id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDateStamp(Date dateStamp) {
        this.dateStamp = dateStamp;
    }

    public void setProgramInitiationEntityList(List<ProgramInitiationEntity> programInitiationEntityList) {
        this.programInitiationEntityList = programInitiationEntityList;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getDate() {
        return date;
    }

    public Date getDateStamp() {
        return dateStamp;
    }

    public List<ProgramInitiationEntity> getProgramInitiationEntityList() {
        return programInitiationEntityList;
    }
}
