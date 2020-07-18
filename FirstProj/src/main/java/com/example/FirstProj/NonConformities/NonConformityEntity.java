package com.example.FirstProj.NonConformities;


import com.example.FirstProj.NonconformityAttachment.NonconformityAttachmentEntity;
import com.example.FirstProj.NonconformityClassification.NonconformityClassificationEntity;
import com.example.FirstProj.ProgramInitiation.ProgramInitiationEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table(name="nonconformities")
public class NonConformityEntity {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "domain")
    private String domain;
    @Column(name = "clause_number")
    private int clauseNumber;
    @Column(name = "reference")
    private float reference;
    @Column(name = "audit_criteria")
    private String auditCriteria;
    @Column(name = "findings")
    private String findings;
    @Column(name = "acknowledgment_auditee")
    private String acknowledgmentAuditee;
    @Column(name = "identifying_date")
    private Date identifyingDate;
    @Column(name = "date_stamp")
    private Date dateStamp;

    @OneToMany(mappedBy = "nonConformityEntity")
    @JsonIgnore
    private List<NonconformityAttachmentEntity> attachmentEntityList;

    @ManyToOne
    @JoinColumn(name="nonconformityclassification_id")
    NonconformityClassificationEntity nonconformityClassificationEntity;

    @ManyToOne
    @JoinColumn(name="program_id")
    private ProgramInitiationEntity programInitiationEntity;

    public ProgramInitiationEntity getProgramInitiationEntity() {
        return programInitiationEntity;
    }

    public void setProgramInitiationEntity(ProgramInitiationEntity programInitiationEntity) {
        this.programInitiationEntity = programInitiationEntity;
    }

    public NonconformityClassificationEntity getNonconformityClassificationEntity() {
        return nonconformityClassificationEntity;
    }

    public void setNonconformityClassificationEntity(NonconformityClassificationEntity nonconformityClassificationEntity) {
        this.nonconformityClassificationEntity = nonconformityClassificationEntity;
    }

    public List<NonconformityAttachmentEntity> getAttachmentEntityList() {
        return attachmentEntityList;
    }

    public void setAttachmentEntityList(List<NonconformityAttachmentEntity> attachmentEntityList) {
        this.attachmentEntityList = attachmentEntityList;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public void setClauseNumber(int clauseNumber) {
        this.clauseNumber = clauseNumber;
    }

    public void setReference(float reference) {
        this.reference = reference;
    }

    public void setAuditCriteria(String auditCriteria) {
        this.auditCriteria = auditCriteria;
    }

    public void setFindings(String findings) {
        this.findings = findings;
    }

    public void setAcknowledgmentAuditee(String acknowledgmentAuditee) {
        this.acknowledgmentAuditee = acknowledgmentAuditee;
    }

    public void setIdentifyingDate(Date identifyingDate) {
        this.identifyingDate = identifyingDate;
    }

    public void setDateStamp(Date dateStamp) {
        this.dateStamp = dateStamp;
    }



    public String getId() {
        return id;
    }

    public String getDomain() {
        return domain;
    }

    public int getClauseNumber() {
        return clauseNumber;
    }

    public float getReference() {
        return reference;
    }

    public String getAuditCriteria() {
        return auditCriteria;
    }

    public String getFindings() {
        return findings;
    }

    public String getAcknowledgmentAuditee() {
        return acknowledgmentAuditee;
    }

    public Date getIdentifyingDate() {
        return identifyingDate;
    }

    public Date getDateStamp() {
        return dateStamp;
    }

}
