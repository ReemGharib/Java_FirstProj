package com.example.FirstProj.PolicyProcedureNote;

import com.example.FirstProj.PolicyProcedureNote.PolicyProcedureNoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PolicyProcedureNoteRepository extends JpaRepository<PolicyProcedureNoteEntity, String> {
    List<PolicyProcedureNoteEntity> findByProgramInitiationEntity_id(String id);
}
