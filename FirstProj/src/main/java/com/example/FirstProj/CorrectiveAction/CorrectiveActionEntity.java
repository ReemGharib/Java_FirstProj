package com.example.FirstProj.CorrectiveAction;

import com.example.FirstProj.AuditeeComplaintAssignedTo.AuditeeComplaintsAssignedToEntity;
import com.example.FirstProj.CorrectiveActionAttachment.CorrectiveActionAttachmentEntity;
import com.example.FirstProj.CorrectiveAssignedTo.CorrectiveAssignedToEntity;
import com.example.FirstProj.CorrectiveReviewer.CorrectiveReviewerEntity;
import com.example.FirstProj.ProgramInitiation.ProgramInitiationEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="correctiveaction")
public class CorrectiveActionEntity {
    @Id
    @Column(name="id")
    private String id;
    @Column(name="status")
    private String  status;
    @Column(name="assigned_on_date")
    private Date assignedOnDate;
    @Column(name="related_nonconformities")
    private String relatedNonconformities;
    @Column(name="corrective_action")
    private String correctiveAction;
    @Column(name="informed_implemented_action")
    private String informedImplementedAction;
    @Column(name="related_customer_complaints")
    private String relatedCustomerComplaints;
    @Column(name="implementation_deadline_date")
    private Date implementationDeadlineDate;
    @Column(name="reviewed_on_date")
    private Date reviewedOnDate;
    @Column(name="date_stamp")
    private Date dateStamp;

    @ManyToOne
    @JoinColumn(name = "assigned_to_id")
    private CorrectiveAssignedToEntity correctiveAssignedToEntity;

    @ManyToOne
    @JoinColumn(name = "reviewer_id")
    private CorrectiveReviewerEntity correctiveReviewerEntity;

    @OneToMany(mappedBy = "correctiveActionEntity")
    @JsonIgnore
    private List<CorrectiveActionAttachmentEntity> entityList;

    @ManyToOne
    @JoinColumn(name="program_id")
    private ProgramInitiationEntity programInitiationEntity;

    public ProgramInitiationEntity getProgramInitiationEntity() {
        return programInitiationEntity;
    }

    public void setProgramInitiationEntity(ProgramInitiationEntity programInitiationEntity) {
        this.programInitiationEntity = programInitiationEntity;
    }

    public void setEntityList(List<CorrectiveActionAttachmentEntity> entityList) {
        this.entityList = entityList;
    }

    public List<CorrectiveActionAttachmentEntity> getEntityList() {
        return entityList;
    }

    public void setId(String id) {
        this.id = id;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public void setAssignedOnDate(Date assignedOnDate) {
        this.assignedOnDate = assignedOnDate;
    }

    public void setRelatedNonconformities(String relatedNonconformities) {
        this.relatedNonconformities = relatedNonconformities;
    }

    public void setCorrectiveAction(String correctiveAction) {
        this.correctiveAction = correctiveAction;
    }

    public void setInformedImplementedAction(String informedImplementedAction) {
        this.informedImplementedAction = informedImplementedAction;
    }

    public void setRelatedCustomerComplaints(String relatedCustomerComplaints) {
        this.relatedCustomerComplaints = relatedCustomerComplaints;
    }

    public void setImplementationDeadlineDate(Date implementationDeadlineDate) {
        this.implementationDeadlineDate = implementationDeadlineDate;
    }

    public void setReviewedOnDate(Date reviewedOnDate) {
        this.reviewedOnDate = reviewedOnDate;
    }

    public void setDateStamp(Date dateStamp) {
        this.dateStamp = dateStamp;
    }

    public void setCorrectiveAssignedToEntity(CorrectiveAssignedToEntity correctiveAssignedToEntity) {
        this.correctiveAssignedToEntity = correctiveAssignedToEntity;
    }

    public void setCorrectiveReviewerEntity(CorrectiveReviewerEntity correctiveReviewerEntity) {
        this.correctiveReviewerEntity = correctiveReviewerEntity;
    }

    public String getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public Date getAssignedOnDate() {
        return assignedOnDate;
    }

    public String getRelatedNonconformities() {
        return relatedNonconformities;
    }

    public String getCorrectiveAction() {
        return correctiveAction;
    }

    public String getInformedImplementedAction() {
        return informedImplementedAction;
    }

    public String getRelatedCustomerComplaints() {
        return relatedCustomerComplaints;
    }

    public Date getImplementationDeadlineDate() {
        return implementationDeadlineDate;
    }

    public Date getReviewedOnDate() {
        return reviewedOnDate;
    }

    public Date getDateStamp() {
        return dateStamp;
    }

    public CorrectiveAssignedToEntity getCorrectiveAssignedToEntity() {
        return correctiveAssignedToEntity;
    }

    public CorrectiveReviewerEntity getCorrectiveReviewerEntity() {
        return correctiveReviewerEntity;
    }
}
