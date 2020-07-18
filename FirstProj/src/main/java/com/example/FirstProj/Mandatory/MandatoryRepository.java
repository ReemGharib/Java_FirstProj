package com.example.FirstProj.Mandatory;

import com.example.FirstProj.SecurityControl.SecurityControlEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MandatoryRepository extends JpaRepository<MandatoryEntity, String> {
    List<MandatoryEntity> findByframeworkEntity_id(String id);
}
