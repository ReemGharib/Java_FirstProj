package com.example.FirstProj.AuditeeComplaintAssignedTo;

import com.example.FirstProj.AuditeeComplaint.AuditeeComplaintEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.xml.bind.v2.model.core.ID;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
@Entity
@Table(name="auditeecomplaintsassignedto")
public class AuditeeComplaintsAssignedToEntity {
    @Id
    @Column(name = "id")
    String id;
    @Column(name = "first_name")
    String firstName;
    @Column(name = "last_name")
    String lastName;
    @Column(name = "date")
    Date date;
    @Column(name = "date_stamp")
    Date dateStamp;

    @OneToMany(targetEntity=AuditeeComplaintEntity.class,mappedBy = "auditeeComplaintsAssignedToEntity", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
            @JsonIgnore
    List<AuditeeComplaintEntity> auditeeComplaintEntityList;

    public void setId(String id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDateStamp(Date dateStamp) {
        this.dateStamp = dateStamp;
    }

    public void setAuditeeComplaintEntityList(List<AuditeeComplaintEntity> auditeeComplaintEntityList) {
        this.auditeeComplaintEntityList = auditeeComplaintEntityList;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getDate() {
        return date;
    }

    public Date getDateStamp() {
        return dateStamp;
    }

    public List<AuditeeComplaintEntity> getAuditeeComplaintEntityList() {
        return auditeeComplaintEntityList;
    }
}
