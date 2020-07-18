package com.example.FirstProj.AuditeeComplaintAssignedTo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuditeeComplaintsAssignedToRepository extends JpaRepository<AuditeeComplaintsAssignedToEntity, String > {
}
