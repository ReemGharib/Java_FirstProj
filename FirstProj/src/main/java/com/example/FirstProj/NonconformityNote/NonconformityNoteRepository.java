package com.example.FirstProj.NonconformityNote;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NonconformityNoteRepository extends JpaRepository<NonconformityNoteEntity, String> {
    List<NonconformityNoteEntity> findByProgramInitiationEntity_id(String id);
}
