package com.uidai.aadhar.Service;

import org.springframework.http.ResponseEntity;
import com.uidai.aadhar.DTO.FileUploadRequestDTO;


public interface FileUploadService {

	public ResponseEntity<?> fileUpload(FileUploadRequestDTO request);
	public ResponseEntity<?> fileUploadStatus(String uidaiID);
}
