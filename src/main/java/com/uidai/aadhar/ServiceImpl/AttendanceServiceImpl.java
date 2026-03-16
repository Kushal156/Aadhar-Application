package com.uidai.aadhar.ServiceImpl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.uidai.aadhar.DTO.ApplyLeaveDTO;
import com.uidai.aadhar.DTO.AttendanceRequestDTO;
import com.uidai.aadhar.Entity.AttendanceEntity;
import com.uidai.aadhar.Entity.LeaveHistoryEntity;
import com.uidai.aadhar.Repository.AttendanceRepository;
import com.uidai.aadhar.Repository.LeaveHistoryRepository;
import com.uidai.aadhar.Service.AttendanceService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AttendanceServiceImpl implements AttendanceService {

	@Autowired
	AttendanceRepository repo;
	
	@Autowired
	LeaveHistoryRepository leaveRepo;

	@Override
	public ResponseEntity<?> attendance(AttendanceRequestDTO request) {
		log.info("Attendance Request :: {}", request.toString());
		String status = repo.spSaveUidaiAttendance(request.getOperatorId(), request.getDeviceMacAddress());
		log.info("SP Result :: {}", status);
		return new ResponseEntity(status, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> viewReport() {

		List<AttendanceEntity> data = repo.findAll();
		log.info("data for attendance :: {}", data.toString());

		return new ResponseEntity(data, HttpStatus.OK);
	}

	public ResponseEntity<?> agencyAttendance(String agencyCode) {

		log.info("Agency Wise Report :: {}", agencyCode);

		List<AttendanceEntity> data = repo.findByAgencyCode(agencyCode);
		log.info("data for attendance :: {}", data.toString());

		return new ResponseEntity(data, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> mobAttendance(AttendanceRequestDTO request) {

		Map<String, Object> response = new LinkedHashMap();
		log.info("Attendance Request :: {}", request.toString());
		String status = repo.spSaveUidaiAttendance(request.getOperatorId(), request.getDeviceMacAddress());
		log.info("SP Result :: {}", status);

		if ("in".equalsIgnoreCase(status)) {
			response.put("status", true);
			response.put("punchStatus", status);
			response.put("message", "Punched in successfully");
		} else if ("out".equalsIgnoreCase(status)) {
			response.put("status", true);
			response.put("punchStatus", status);
			response.put("message", "Punched out successfully");
		}
		return new ResponseEntity(response, HttpStatus.OK);
	}

	/* Leave Management */
	@Override
	public ResponseEntity<?> applyLeave(ApplyLeaveDTO request) {
		log.info("Apply Leave Request :: {}", request.toString());
		Map<String, Object> response = new LinkedHashMap();
		
		try {
			
			List<LeaveHistoryEntity> duplicate =
	                leaveRepo.findOverlappingLeave(
	                        request.getOperatorId(),
	                        request.getLeaveFrom(),
	                        request.getLeaveTo());

	        if (!duplicate.isEmpty()) {

	            response.put("status", false);
	            response.put("message", "Leave already exists for selected date range");

	            return ResponseEntity.ok(response);
	        }

	        LeaveHistoryEntity entity = new LeaveHistoryEntity();

	        entity.setOperatorId(request.getOperatorId());
	        entity.setAgencyCode(request.getAgencyCode());
	        entity.setReason(request.getRemarks());
	        entity.setNoOfDays(request.getDays().doubleValue());
	        entity.setLeaveFrom(request.getLeaveFrom());
	        entity.setLeaveTo(request.getLeaveTo());
	        entity.setLeaveType(request.getLeaveType());
	        entity.setHalfDayStatus(request.getHalfDayStatus());
	        entity.setStatus(1); // Pending

	        leaveRepo.save(entity);
	        
	        response.put("status", true);
	        response.put("message", "Leave applied successfully");

	        return ResponseEntity.ok(response);

	    } catch (Exception e) {

	        log.error("Error applying leave :: {}", e.getMessage());
	        response.put("status", false);
	        response.put("message", "Error occurred while applying Leave");
	        return ResponseEntity.ok(response);
	    }		
	}

	@Override
	public ResponseEntity<?> viewLeave(String agencyCode) {
		log.info("View Leave Request for agency :: {}", agencyCode);
		try {

	        List<LeaveHistoryEntity> leaveList = leaveRepo.findByAgencyCodeOrderByCreatedAtDesc(agencyCode);

	        return ResponseEntity.ok(leaveList);

	    } catch (Exception e) {

	        log.error("Error fetching leave history :: {}", e.getMessage());

	        return ResponseEntity.status(HttpStatus.OK).body("Error while fetching leave history");
	    }
	}
}