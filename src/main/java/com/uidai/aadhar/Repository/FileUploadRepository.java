package com.uidai.aadhar.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uidai.aadhar.Entity.FileUploadEntity;

@Repository
public interface FileUploadRepository extends JpaRepository<FileUploadEntity, Integer>{

	Optional<FileUploadEntity> findByUidaiID(String uidaiID); 
}
