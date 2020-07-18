package com.example.FirstProj.ProgramInitiation;


import com.example.FirstProj.AuditeeComplaint.AuditeeComplaintEntity;
import com.example.FirstProj.AuditeeComplaintsNotes.AuditeeComplaintNoteEntity;
import com.example.FirstProj.CorrectiveAction.CorrectiveActionEntity;
import com.example.FirstProj.CorrectiveActionNote.CorrectiveActionNoteEntity;
import com.example.FirstProj.FrameworkProgramInitiation.FrameworkProgramInitiationEntity;
import com.example.FirstProj.MandatoryClauseNote.MandatoryClauseNoteEntity;
import com.example.FirstProj.MandatoryClausePerform.MandatoryClausePerformEntity;
import com.example.FirstProj.NonConformities.NonConformityEntity;
import com.example.FirstProj.NonconformityNote.NonconformityNoteEntity;
import com.example.FirstProj.PolicyProcedureNote.PolicyProcedureNoteEntity;
import com.example.FirstProj.ProgramAssignedTo.ProgramAssignedToEntity;
import com.example.FirstProj.SecurityControlPerform.SecurityControlPerformEntity;
import com.example.FirstProj.SecurityControlsNotes.SecurityControlNoteEntity;
import com.example.FirstProj.StatusProgramInitiation.StatusProgramInitiationEntity;
import com.example.FirstProj.folder.FolderEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="programinitiations")
public class ProgramInitiationEntity {
    @Id
    @Column(name="id")
    private String id;
    @Column(name="date")
    private Date date;
    @Column(name="criteria_of_audit")
    private String criteriaOfAudit;
    @Column(name = "scope_of_audit")
    private String scopeOfAudit;
    @Column(name = "date_stamp")
    private Date dateStamp;

    @ManyToOne
    @JoinColumn(name="program_assigned_to_id")
    private ProgramAssignedToEntity programAssignedToEntity;

    @ManyToOne
    @JoinColumn(name="framework_id")
    private FrameworkProgramInitiationEntity frameworkProgramInitiationEntity;

    @ManyToOne
    @JoinColumn(name="status_id")
    private StatusProgramInitiationEntity statusProgramInitiationEntity;

    @OneToMany(targetEntity= AuditeeComplaintEntity.class, mappedBy="programInitiationEntity", fetch=FetchType.LAZY)
    @JsonIgnore
    List<AuditeeComplaintEntity> auditeeComplaintEntityList;

    @OneToMany(targetEntity= CorrectiveActionEntity.class, mappedBy="programInitiationEntity", fetch=FetchType.LAZY)
    @JsonIgnore
    List<CorrectiveActionEntity> correctiveActionEntityList;

    @OneToMany(targetEntity= MandatoryClausePerformEntity.class, mappedBy="programInitiationEntity", fetch=FetchType.LAZY)
    @JsonIgnore
    List<MandatoryClausePerformEntity> mandatoryClausePerformEntityList;

    @OneToMany(targetEntity= NonConformityEntity.class, mappedBy="programInitiationEntity", fetch=FetchType.LAZY)
    @JsonIgnore
    List<NonConformityEntity> nonConformityEntityList;

    @OneToMany(targetEntity= SecurityControlPerformEntity.class, mappedBy="programInitiationEntity", fetch=FetchType.LAZY)
    @JsonIgnore
    List<SecurityControlPerformEntity> securityControlPerformEntityList;

    @OneToMany(targetEntity= FolderEntity.class, mappedBy="programInitiationEntity", fetch=FetchType.LAZY)
    @JsonIgnore
    List<FolderEntity> folderEntityList;

    @OneToMany(targetEntity= PolicyProcedureNoteEntity.class, fetch=FetchType.LAZY, mappedBy = "programInitiationEntity")
    @JsonIgnore
    List<PolicyProcedureNoteEntity> policyProcedureNoteEntities;

    @OneToMany(targetEntity= AuditeeComplaintNoteEntity.class, fetch=FetchType.LAZY, mappedBy = "programInitiationEntity")
    @JsonIgnore
    List<AuditeeComplaintNoteEntity> auditeeComplaintNoteEntities;

    @OneToMany(targetEntity= NonconformityNoteEntity.class, fetch=FetchType.LAZY, mappedBy = "programInitiationEntity")
    @JsonIgnore
    List<NonconformityNoteEntity> nonconformityNoteEntities;

    @OneToMany(targetEntity= CorrectiveActionNoteEntity.class, fetch=FetchType.LAZY, mappedBy = "programInitiationEntity")
    @JsonIgnore
    List<CorrectiveActionNoteEntity> correctiveActionNoteEntities;

    @OneToMany(targetEntity= MandatoryClauseNoteEntity.class, fetch=FetchType.LAZY, mappedBy = "programInitiationEntity")
    @JsonIgnore
    List<MandatoryClauseNoteEntity> mandatoryClauseNoteEntities;

    @OneToMany(targetEntity= SecurityControlNoteEntity.class, fetch=FetchType.LAZY, mappedBy = "programInitiationEntity")
    @JsonIgnore
    List<SecurityControlNoteEntity> securityControlNoteEntities;

    public void setSecurityControlPerformEntityList(List<SecurityControlPerformEntity> securityControlPerformEntityList) {
        this.securityControlPerformEntityList = securityControlPerformEntityList;
    }

    public List<SecurityControlPerformEntity> getSecurityControlPerformEntityList() {
        return securityControlPerformEntityList;
    }

    public void setAuditeeComplaintEntityList(List<AuditeeComplaintEntity> auditeeComplaintEntityList) {
        this.auditeeComplaintEntityList = auditeeComplaintEntityList;
    }

    public void setCorrectiveActionEntityList(List<CorrectiveActionEntity> correctiveActionEntityList) {
        this.correctiveActionEntityList = correctiveActionEntityList;
    }

    public void setMandatoryClausePerformEntityList(List<MandatoryClausePerformEntity> mandatoryClausePerformEntityList) {
        this.mandatoryClausePerformEntityList = mandatoryClausePerformEntityList;
    }

    public void setNonConformityEntityList(List<NonConformityEntity> nonConformityEntityList) {
        this.nonConformityEntityList = nonConformityEntityList;
    }

    public List<AuditeeComplaintEntity> getAuditeeComplaintEntityList() {
        return auditeeComplaintEntityList;
    }

    public List<CorrectiveActionEntity> getCorrectiveActionEntityList() {
        return correctiveActionEntityList;
    }

    public List<MandatoryClausePerformEntity> getMandatoryClausePerformEntityList() {
        return mandatoryClausePerformEntityList;
    }

    public List<NonConformityEntity> getNonConformityEntityList() {
        return nonConformityEntityList;
    }

    public void setFrameworkProgramInitiationEntity(FrameworkProgramInitiationEntity frameworkProgramInitiationEntity) {
        this.frameworkProgramInitiationEntity = frameworkProgramInitiationEntity;
    }

    public void setStatusProgramInitiationEntity(StatusProgramInitiationEntity statusProgramInitiationEntity) {
        this.statusProgramInitiationEntity = statusProgramInitiationEntity;
    }

    public FrameworkProgramInitiationEntity getFrameworkProgramInitiationEntity() {
        return frameworkProgramInitiationEntity;
    }

    public StatusProgramInitiationEntity getStatusProgramInitiationEntity() {
        return statusProgramInitiationEntity;
    }

    public void setId(String id) {
        this.id = id;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public void setCriteriaOfAudit(String criteriaOfAudit) {
        this.criteriaOfAudit = criteriaOfAudit;
    }
    public void setScopeOfAudit(String scopeOfAudit) {
        this.scopeOfAudit = scopeOfAudit;
    }
    public void setDateStamp(Date dateStamp) {
        this.dateStamp = dateStamp;
    }
    public void setProgramAssignedToEntity(ProgramAssignedToEntity programAssignedToEntity) {
        this.programAssignedToEntity = programAssignedToEntity;
    }
    public String getId() {
        return id;
    }
    public Date getDate() {
        return date;
    }
    public String getCriteriaOfAudit() {
        return criteriaOfAudit;
    }
    public String getScopeOfAudit() {
        return scopeOfAudit;
    }
    public Date getDateStamp() {
        return dateStamp;
    }
    public ProgramAssignedToEntity getProgramAssignedToEntity() {
        return programAssignedToEntity;
    }
}
