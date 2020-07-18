package com.example.FirstProj.CorrectiveActionNote;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CorrectiveActionNoteRepository extends JpaRepository<CorrectiveActionNoteEntity, String> {
    List<CorrectiveActionNoteEntity> findByProgramInitiationEntity_id(String id);

}
