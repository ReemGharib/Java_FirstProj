package com.example.FirstProj.NonconformityClassification;

import com.example.FirstProj.NonConformities.NonConformityEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="nonconformityclassification")
public class NonconformityClassificationEntity {
    @Id
    @Column(name="id")
    private String id;

    @Column(name="nonconformity_classification")
    private String nonconformityClassification;

    @OneToMany(mappedBy="nonconformityClassificationEntity")
    @JsonIgnore
    private List<NonConformityEntity> nonConformityEntityList;

    public List<NonConformityEntity> getNonConformityEntityList() {
        return nonConformityEntityList;
    }

    public void setNonConformityEntityList(List<NonConformityEntity> nonConformityEntityList) {
        this.nonConformityEntityList = nonConformityEntityList;
    }

    public String getId() {
        return id;
    }

    public String getNonconformityClassification() {
        return nonconformityClassification;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNonconformityClassification(String nonconformityClassification) {
        this.nonconformityClassification = nonconformityClassification;
    }
}
