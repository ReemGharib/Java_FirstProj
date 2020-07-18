package com.example.FirstProj.NonconformityAttachment;

import com.example.FirstProj.NonConformities.NonConformityEntity;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "nonconformitiesattachments")
public class NonconformityAttachmentEntity {
    @Id
    @Column(name="id")
    String id;
    @Column(name="file_name")
    String filename;
    @Column(name="file_uRL")
    String fileUrl;
    @Column(name="date")
    Date date;
    @Column(name="date_stamp")
    Date dateStamp;
    @ManyToOne
    @JoinColumn(name="nonconformities_id")
    NonConformityEntity nonConformityEntity;

    public void setId(String id) {
        this.id = id;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDateStamp(Date dateStamp) {
        this.dateStamp = dateStamp;
    }

    public void setNonConformityEntity(NonConformityEntity nonConformityEntity) {
        this.nonConformityEntity = nonConformityEntity;
    }

    public String getId() {
        return id;
    }

    public String getFilename() {
        return filename;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public Date getDate() {
        return date;
    }

    public Date getDateStamp() {
        return dateStamp;
    }

    public NonConformityEntity getNonConformityEntity() {
        return nonConformityEntity;
    }
}
