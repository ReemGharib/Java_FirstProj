package com.example.FirstProj.ProgramInitiationNote;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name="programinitiationnotes")
@Entity
public class ProgramInitiationNoteEntity {
    @Id
    @Column(name="id")
    private String id;
    @Column(name="notes")
    private String notes;
    @Column(name = "date_stamp")
    private Date dateStamp;
    @Column(name="date")
    Date date;


    public void setId(String id) {
        this.id = id;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setDateStamp(Date dateStamp) {
        this.dateStamp = dateStamp;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public String getNotes() {
        return notes;
    }

    public Date getDateStamp() {
        return dateStamp;
    }

    public Date getDate() {
        return date;
    }
}
