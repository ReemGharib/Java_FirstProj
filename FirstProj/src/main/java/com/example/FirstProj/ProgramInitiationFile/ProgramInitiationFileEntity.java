package com.example.FirstProj.ProgramInitiationFile;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="programinitiationfiles")
public class ProgramInitiationFileEntity {
    @Id
    @Column(name="id")
    private String id;
    @Column(name = "file_name")
    private String fileName;
    @Column(name="date")
    private String date;
    @Column(name = "date_stamp")
    String dateStamp;

    public void setId(String id) {
        this.id = id;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDateStamp(String dateStamp) {
        this.dateStamp = dateStamp;
    }

    public String getId() {
        return id;
    }

    public String getFileName() {
        return fileName;
    }

    public String getDate() {
        return date;
    }

    public String getDateStamp() {
        return dateStamp;
    }
}
