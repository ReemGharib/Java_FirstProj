package com.example.FirstProj.CorrectiveActionAttachment;

import com.example.FirstProj.CorrectiveAction.CorrectiveActionEntity;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="correctiveactionattachments")
public class CorrectiveActionAttachmentEntity {
    @Id
    @Column(name="id")
    private String id;
    @Column(name="file_name")
    private String fileName;
    @Column(name="file_url")
    private String fileUrl;
    @Column(name="date")
    private Date date;
    @Column(name="date_stamp")
    private Date dateStamp;
    @ManyToOne
    @JoinColumn(name="correctiveaction_id")
    private CorrectiveActionEntity correctiveActionEntity;

    public void setId(String id) {
        this.id = id;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
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

    public void setCorrectiveActionEntity(CorrectiveActionEntity correctiveActionEntity) {
        this.correctiveActionEntity = correctiveActionEntity;
    }

    public String getId() {
        return id;
    }

    public String getFileName() {
        return fileName;
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

    public CorrectiveActionEntity getCorrectiveActionEntity() {
        return correctiveActionEntity;
    }
}
