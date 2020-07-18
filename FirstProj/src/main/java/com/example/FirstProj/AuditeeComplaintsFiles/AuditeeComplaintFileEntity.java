package com.example.FirstProj.AuditeeComplaintsFiles;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "auditeecomplaintsfiles")
public class AuditeeComplaintFileEntity {
    @Id
    @Column(name="id")
    String id;
    @Column(name="file_name")
    String file_name;
    @Column(name="date")
    Date date;
    @Column(name = "date_stamp")
    Date date_stamp;

    public void setId(String id) {
        this.id = id;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDate_stamp(Date date_stamp) {
        this.date_stamp = date_stamp;
    }

    public String getId() {
        return id;
    }

    public String getFile_name() {
        return file_name;
    }

    public Date getDate() {
        return date;
    }

    public Date getDate_stamp() {
        return date_stamp;
    }
}
