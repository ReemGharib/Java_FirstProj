package com.example.FirstProj.MandatoryClausePerform;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MandatoryClausePerformRepository extends JpaRepository<MandatoryClausePerformEntity, String> {
    List<MandatoryClausePerformEntity> findByProgramInitiationEntity_id(String id);
    List<MandatoryClausePerformEntity> findByProgramInitiationEntity_frameworkProgramInitiationEntity_id(String id);
}
