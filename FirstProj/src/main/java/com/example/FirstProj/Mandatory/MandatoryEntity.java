package com.example.FirstProj.Mandatory;

import com.example.FirstProj.FrameworkProgramInitiation.FrameworkProgramInitiationEntity;

import javax.persistence.*;


@Entity
@Table(name="mandatory")
public class MandatoryEntity {
    @Id
    @Column(name="id")
    private String id;
    @Column(name="requirement")
    private String requirement;
    @Column(name="clauses")
    private Float clauses;
    @Column(name="testing_steps")
    private String testingSteps;
    @Column(name="complaint")
    private Boolean complaint;
    @Column(name="evidence")
    private String evidence;
    @Column(name="reference")
    private int Reference;
    @Column(name="title_mandatory_clauses")
    String titleMandatoryClauses;

    @ManyToOne
    @JoinColumn(name = "framework_id")
    private FrameworkProgramInitiationEntity frameworkEntity;

    public FrameworkProgramInitiationEntity getFrameworkEntity() {
        return frameworkEntity;
    }

    public void setFrameworkEntity(FrameworkProgramInitiationEntity frameworkEntity) {
        this.frameworkEntity = frameworkEntity;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public void setClauses(Float clauses) {
        this.clauses = clauses;
    }

    public void setTestingSteps(String testingSteps) {
        this.testingSteps = testingSteps;
    }

    public void setComplaint(Boolean complaint) {
        this.complaint = complaint;
    }

    public void setEvidence(String evidence) {
        this.evidence = evidence;
    }

    public void setReference(int reference) {
        Reference = reference;
    }

    public void setTitleMandatoryClauses(String titleMandatoryClauses) {
        this.titleMandatoryClauses = titleMandatoryClauses;
    }

//    public void setFrameworkProgramInitiationEntity(FrameworkProgramInitiationEntity frameworkProgramInitiationEntity) {
//        this.frameworkProgramInitiationEntity = frameworkProgramInitiationEntity;
//    }

    public String getId() {
        return id;
    }

    public String getRequirement() {
        return requirement;
    }

    public Float getClauses() {
        return clauses;
    }

    public String getTestingSteps() {
        return testingSteps;
    }

    public Boolean getComplaint() {
        return complaint;
    }

    public String getEvidence() {
        return evidence;
    }

    public int getReference() {
        return Reference;
    }

    public String getTitleMandatoryClauses() {
        return titleMandatoryClauses;
    }

//    public FrameworkProgramInitiationEntity getFrameworkProgramInitiationEntity() {
//        return frameworkProgramInitiationEntity;
//    }
}
