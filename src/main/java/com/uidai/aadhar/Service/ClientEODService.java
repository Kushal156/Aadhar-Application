package com.uidai.aadhar.Service;

import org.springframework.http.ResponseEntity;

import com.uidai.aadhar.DTO.ClientEODRequest;

public interface ClientEODService {

	ResponseEntity<?> getEnrollment(ClientEODRequest request);
	ResponseEntity<?> getEnrollmentFullData();
	ResponseEntity<?> getMachineId();

}