package com.example.FirstProj.CorrectiveActionNote;

import com.example.FirstProj.ProgramInitiation.ProgramInitiationEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="correctiveactionnotes")
public class CorrectiveActionNoteEntity {
    @Id
    @Column(name="id")
    String id;
    @Column(name="date")
    Date date;
    @Column(name="date_stamp")
    Date dateStamp;
    @Column(name="notes")
    String notes;

    @ManyToOne
    @JoinColumn(name = "program_id")
    private ProgramInitiationEntity programInitiationEntity;

    public void setProgramInitiationEntity(ProgramInitiationEntity programInitiationEntity) {
        this.programInitiationEntity = programInitiationEntity;
    }

    public ProgramInitiationEntity getProgramInitiationEntity() {
        return programInitiationEntity;
    }

    public Date getDate() {
        return date;
    }

    public Date getDateStamp() {
        return dateStamp;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNotes() {
        return notes;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDateStamp(Date dateStamp) {
        this.dateStamp = dateStamp;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }



    public String getId() {
        return id;
    }

}
