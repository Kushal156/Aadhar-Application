package com.uidai.aadhar.Service;

import java.time.LocalDate;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import com.uidai.aadhar.DTO.NewOperatorRequestDto;
import com.uidai.aadhar.Entity.UidaiOperatorMasterEntity;

public interface OperatorService {

	public ResponseEntity<?> newOperator(NewOperatorRequestDto request);
	public ResponseEntity<?> operatorData(String operatorId);
	public ResponseEntity<?> editOperator(String id, NewOperatorRequestDto request);
	Page<UidaiOperatorMasterEntity> view(String search, Integer status, Pageable pageable, String agencyCode, LocalDate fromDate,
            LocalDate toDate);
	public ResponseEntity<?> mapOperator(Map<String, Object> request);
	
	public ResponseEntity<?> operatorInfo(Map<String, Object> request);
	public ResponseEntity<?> operatorSpecificInfo(Map<String, Object> request);
	public ResponseEntity<?> activateOperator(String operatorId, Integer status);
	public ResponseEntity<?> pendingOperators();
}
