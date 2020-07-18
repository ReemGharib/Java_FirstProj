package com.example.FirstProj.AuditeeComplaint;

import com.example.FirstProj.AuditeeComplaintAssignedTo.AuditeeComplaintsAssignedToEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AuditeeComplaintRepository extends JpaRepository<AuditeeComplaintEntity, String> {
//    Optional<AuditeeComplaintsAssignedToEntity> findByAuditeeComplaintsAssignedToId(String id);
//    Optional<AuditeeComplaintEntity> findByIdAndByAuditeeAssignedToId(String id, String i);
    List<AuditeeComplaintEntity> findByProgramInitiationEntity_id(String id);
}
