package com.example.FirstProj.SecurityControl;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SecurityControlRepository extends JpaRepository<SecurityControlEntity, String> {
    List<SecurityControlEntity> findByframeworkEntity_id(String id);
}
