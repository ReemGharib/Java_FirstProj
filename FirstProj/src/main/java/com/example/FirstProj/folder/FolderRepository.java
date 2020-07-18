package com.example.FirstProj.folder;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FolderRepository extends JpaRepository<FolderEntity, String> {
    List<FolderEntity> findByFolderType(String folderType);
    List<FolderEntity> findByFolderName(String folderName);
    List<FolderEntity> findByFolderTypeAndProgramInitiationEntity_id(String folderType, String programId);
}
