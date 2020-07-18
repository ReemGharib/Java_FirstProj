package com.example.FirstProj.CorrectiveAction;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CorrectiveActionRepository extends JpaRepository<CorrectiveActionEntity, String> {
    List<CorrectiveActionEntity> findByProgramInitiationEntity_id(String id);
}
