package com.uidai.aadhar.Service;

import org.springframework.http.ResponseEntity;

import com.uidai.aadhar.DTO.AlertRequestDTO;
import com.uidai.aadhar.DTO.AlertResponseDTO;

public interface AlertService {

	public AlertResponseDTO saveAuditTrail(AlertRequestDTO requestDTO);
	public AlertResponseDTO saveGPSStatus(AlertRequestDTO requestDTO);
	public ResponseEntity<?> viewGPSStatus(String agencyCode);
	public ResponseEntity<?> viewAllGPSStatus();
}
