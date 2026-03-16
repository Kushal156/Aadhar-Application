package com.uidai.aadhar.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.uidai.aadhar.DTO.ApplyLeaveDTO;
import com.uidai.aadhar.DTO.AttendanceRequestDTO;

public interface AttendanceService {

	public ResponseEntity<?> attendance(AttendanceRequestDTO request);
	public ResponseEntity<?> viewReport();
	public ResponseEntity<?> mobAttendance(AttendanceRequestDTO request);
	public ResponseEntity<?> agencyAttendance(String agencyCode);
	
	public ResponseEntity<?> applyLeave(ApplyLeaveDTO request);
	public ResponseEntity<?> viewLeave(String agencyCode);
}