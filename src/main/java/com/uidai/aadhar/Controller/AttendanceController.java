package com.uidai.aadhar.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uidai.aadhar.DTO.ApplyLeaveDTO;
import com.uidai.aadhar.DTO.AttendanceRequestDTO;
import com.uidai.aadhar.Service.AttendanceService;

@RestController
@RequestMapping("/attendance")
@CrossOrigin(origins = "*")
public class AttendanceController {
	
	@Autowired
	AttendanceService service;

	@PostMapping("/punch") 
	public ResponseEntity<?> attendace(@RequestBody AttendanceRequestDTO request) {
		return service.attendance(request);
	}
	
	@GetMapping("/view")
	public ResponseEntity<?> viewReport() {
		return service.viewReport();
	}
	
	@GetMapping("/view/{agencyCode}")
	public ResponseEntity <?> viewAgencyWiseReport(@PathVariable String agencyCode){
		return service.agencyAttendance(agencyCode);
	}
	
	/* Leave API's */
	@PostMapping("/apply-leave")
	public ResponseEntity<?> applyLeave(@RequestBody ApplyLeaveDTO request){
		return service.applyLeave(request);
	}
	
	@GetMapping("/view-leave/{agencyCode}")
	public ResponseEntity<?> viewLeave(@PathVariable String agencyCode){
		return service.viewLeave(agencyCode);
	}
	
	/* Mobile APi*/
	@PostMapping("/mob-punch") 
	public ResponseEntity<?> mobileAttendace(@RequestBody AttendanceRequestDTO request) {
		return service.mobAttendance(request);
	}
}