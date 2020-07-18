package com.example.FirstProj.MandatoryClauseFile;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="mandatoryclausesfiles")
public class MandatoryClauseFileEntity {
    @Id
    @Column(name="id")
    String id;
    @Column(name="file_name")
    String fileName;
    @Column(name="date")
    Date date;
    @Column(name="date_stamp")
    Date dateStamp;

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
