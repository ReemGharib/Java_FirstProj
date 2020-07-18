package com.example.FirstProj.SecurityControlPerform;

import com.example.FirstProj.ProgramInitiation.ProgramInitiationEntity;

import javax.persistence.*;

@Entity
@Table(name="securitycontrolsperform")
public class SecurityControlPerformEntity {
    @Id
    @Column(name="id")
    private String id;
    @Column(name="controls_according")
    private String controlAccording;
    @Column(name = "initial_assessment_point")
    private String initialAssessmentPoint;
    @Column(name = "testing_steps")
    private String testingSteps;
    @Column(name = "conformity")
    private String conformity;
    @Column(name = "evidence")
    private String evidence;
    @Column(name =  "control_implemented")
    private String controlImplemented;
    @Column(name="title_security_control")
    String titleSecurityControl;

    @ManyToOne
    @JoinColumn(name="program_id")
    private ProgramInitiationEntity programInitiationEntity;

    public ProgramInitiationEntity getProgramInitiationEntity() {
        return programInitiationEntity;
    }

    public void setProgramInitiationEntity(ProgramInitiationEntity programInitiationEntity) {
        this.programInitiationEntity = programInitiationEntity;
    }

    public String getTitleSecurityControl() {
        return titleSecurityControl;
    }

    public void setTitleSecurityControl(String titleSecurityControl) {
        this.titleSecurityControl = titleSecurityControl;
    }

    public void setControlImplemented(String controlImplemented) {
        this.controlImplemented = controlImplemented;
    }

    public String getControlImplemented() {
        return controlImplemented;
    }

    public String getId() {
        return id;
    }

    public String getControlAccording() {
        return controlAccording;
    }

    public String getInitialAssessmentPoint() {
        return initialAssessmentPoint;
    }

    public String getTestingSteps() {
        return testingSteps;
    }

    public String getConformity() {
        return conformity;
    }

    public String getEvidence() {
        return evidence;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setControlAccording(String controlAccording) {
        this.controlAccording = controlAccording;
    }

    public void setInitialAssessmentPoint(String initialAssessmentPoint) {
        this.initialAssessmentPoint = initialAssessmentPoint;
    }

    public void setTestingSteps(String testingSteps) {
        this.testingSteps = testingSteps;
    }

    public void setConformity(String conformity) {
        this.conformity = conformity;
    }

    public void setEvidence(String evidence) {
        this.evidence = evidence;
    }
}
