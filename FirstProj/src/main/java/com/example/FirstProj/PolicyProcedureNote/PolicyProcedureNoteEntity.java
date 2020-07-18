package com.example.FirstProj.PolicyProcedureNote;


import com.example.FirstProj.ProgramInitiation.ProgramInitiationEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="policiesproceduresnotes")
public class PolicyProcedureNoteEntity {

    @Id
    @Column(name="id")
    private String id;
    @Column(name="notes")
    private String notes;
    @Column(name = "date")
    private Date date;
    @Column(name = "datestamp")
    Date dateStamp;

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

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDateStamp(Date dateStamp) {
        this.dateStamp = dateStamp;
    }

    public String getId() {
        return id;
    }

    public String getNotes() {
        return notes;
    }

    public Date getDate() {
        return date;
    }

    public Date getDateStamp() {
        return dateStamp;
    }

}
