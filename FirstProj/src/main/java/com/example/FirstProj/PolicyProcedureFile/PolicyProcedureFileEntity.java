package com.example.FirstProj.PolicyProcedureFile;


import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name="policiesproceduresfiles")
public class PolicyProcedureFileEntity {
    @Id
    @Column(name="id")
    private String id;
    @Column(name="filename")
    private String fileName;
    @Column(name="date")
    private Date date;
    @Column(name="datestamp")
    private Date dateStamp;

    public void setId(String id) {
        this.id = id;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
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

    public String getFileName() {
        return fileName;
    }

    public Date getDate() {
        return date;
    }

    public Date getDateStamp() {
        return dateStamp;
    }
}
