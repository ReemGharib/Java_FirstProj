package com.example.FirstProj.SecurityControlPerform;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SecurityControlPerformRepository extends JpaRepository<SecurityControlPerformEntity, String> {
    List<SecurityControlPerformEntity> findByProgramInitiationEntity_id(String id);
    List<SecurityControlPerformEntity> findByProgramInitiationEntity_frameworkProgramInitiationEntity_id(String id);

}
