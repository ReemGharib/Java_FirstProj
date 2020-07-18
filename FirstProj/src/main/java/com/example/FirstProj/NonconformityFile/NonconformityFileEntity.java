package com.example.FirstProj.NonconformityFile;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
@Entity
@Table(name="nonconformitiesfiles")
public class NonconformityFileEntity {
    @Id
    @Column(name="id")
    private String id;
    @Column(name="file_name")
    private String fileName;
    @Column(name="date")
    private Date date;
    @Column(name = "date_stamp")
    private  Date dateStamp;

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
