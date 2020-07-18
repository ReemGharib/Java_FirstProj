package com.example.FirstProj.SecurityControlsNotes;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SecurityControlNoteRepository extends JpaRepository<SecurityControlNoteEntity, String > {
    List<SecurityControlNoteEntity> findByProgramInitiationEntity_id(String id);
}
