package com.example.FirstProj.MandatoryClauseNote;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MandatoryClauseNoteRepository extends JpaRepository<MandatoryClauseNoteEntity, String> {
    List<MandatoryClauseNoteEntity> findByProgramInitiationEntity_id(String id);
}
