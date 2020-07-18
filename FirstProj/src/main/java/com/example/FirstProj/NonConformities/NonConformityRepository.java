package com.example.FirstProj.NonConformities;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NonConformityRepository extends JpaRepository<NonConformityEntity, String> {
    List<NonConformityEntity> findByProgramInitiationEntity_id(String id);
}
