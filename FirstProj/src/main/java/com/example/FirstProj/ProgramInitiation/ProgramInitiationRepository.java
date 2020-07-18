package com.example.FirstProj.ProgramInitiation;

import com.example.FirstProj.ProgramAssignedTo.ProgramAssignedToEntity;
import com.example.FirstProj.ProgramInitiation.ProgramInitiationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProgramInitiationRepository extends JpaRepository<ProgramInitiationEntity, String> {
//    Optional<ProgramInitiationEntity> findByProgramAssignedToId(String id);
//    Optional<ProgramInitiationEntity> findByIdAndByProgramAssignedToId(String id, String assign_id);
@Query("select p from ProgramAssignedToEntity p  where id= :id")
ProgramAssignedToEntity getProgramAssignedTo(String id);
}
