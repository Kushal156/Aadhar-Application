package com.uidai.aadhar.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.uidai.aadhar.DTO.ClientEODRequest;
import com.uidai.aadhar.Entity.GetEnrollmentFullEntity;
import com.uidai.aadhar.Repository.GetEnrollmentFullRepository;
import com.uidai.aadhar.Service.ClientEODService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ClientEODServiceImpl implements ClientEODService{
	
	@Autowired
	GetEnrollmentFullRepository fullRepo;

	@Override
	public ResponseEntity<?> getEnrollment(ClientEODRequest request) {
		
		log.info("request :: {}", request.toString());
		List<GetEnrollmentFullEntity> stats = fullRepo.getEnrollmentStats(request.getMachineNo(), request.getDate());
		log.info("Enrollment Stats :: {}", stats.toString());
		
		return new ResponseEntity(stats, HttpStatus.OK);
	}
	
	public ResponseEntity<?> getEnrollmentFullData() {
		
		List<GetEnrollmentFullEntity> data = fullRepo.findAll();
		log.info("Full Data :: {}", data.toString());
		return ResponseEntity.ok(data);
	}

	@Override
	public ResponseEntity<?> getMachineId() {
		List<Integer> machineNumbers = fullRepo.findDistinctMachineNumbers();
		return ResponseEntity.ok(machineNumbers);
	}

}