package com.example.FirstProj.AuditeeComplaint;

import com.example.FirstProj.AuditeeComplaintAssignedTo.AuditeeComplaintsAssignedToEntity;
import com.example.FirstProj.ProgramInitiation.ProgramInitiationEntity;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name="auditeecomplaints")
public class AuditeeComplaintEntity {
    @Id
    @Column(name="id")
    private String id;
    @Column(name="Status")
    private String status;
    @Column(name="person_reported")
    private String personReported;
    @Column(name="complaint_description")
    private String complaintDescription;
    @Column(name="action_for_treating")
    private String actionForTreating;
    @Column(name="attachments")
    private String attachments;
    @Column(name="date")
    private Date date;
    @Column(name="date_stamp")
    private Date dateStamp;

    @ManyToOne
    @JoinColumn(name="assigned_to_id")
    private AuditeeComplaintsAssignedToEntity auditeeComplaintsAssignedToEntity;

    @ManyToOne
    @JoinColumn(name="program_id")
    private ProgramInitiationEntity programInitiationEntity;

    public ProgramInitiationEntity getProgramInitiationEntity() {
        return programInitiationEntity;
    }

    public void setProgramInitiationEntity(ProgramInitiationEntity programInitiationEntity) {
        this.programInitiationEntity = programInitiationEntity;
    }

    public AuditeeComplaintsAssignedToEntity getAuditeeComplaintsAssignedToEntity() {
        return auditeeComplaintsAssignedToEntity;
    }

    public void setAuditeeComplaintsAssignedToEntity(AuditeeComplaintsAssignedToEntity auditeeComplaintsAssignedToEntity) {
        this.auditeeComplaintsAssignedToEntity = auditeeComplaintsAssignedToEntity;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPersonReported(String personReported) {
        this.personReported = personReported;
    }

    public void setComplaintDescription(String complaintDescription) {
        this.complaintDescription = complaintDescription;
    }

    public void setActionForTreating(String actionForTreating) {
        this.actionForTreating = actionForTreating;
    }

    public void setAttachments(String attachments) {
        this.attachments = attachments;
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

    public String getPersonReported() {
        return personReported;
    }

    public String getComplaintDescription() {
        return complaintDescription;
    }

    public String getActionForTreating() {
        return actionForTreating;
    }

    public String getAttachments() {
        return attachments;
    }

    public Date getDate() {
        return date;
    }

    public Date getDateStamp() {
        return dateStamp;
    }

}
