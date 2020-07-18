package com.example.FirstProj.AuditeeComplaintsNotes;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuditeeComplaintNoteRepository extends JpaRepository<AuditeeComplaintNoteEntity, String> {
    List<AuditeeComplaintNoteEntity> findByProgramInitiationEntity_id(String id);
}
