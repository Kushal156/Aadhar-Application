package com.uidai.aadhar.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uidai.aadhar.DTO.AlertRequestDTO;
import com.uidai.aadhar.DTO.AlertResponseDTO;
import com.uidai.aadhar.DTO.NewOperatorRequestDto;
import com.uidai.aadhar.Service.AlertService;
import com.uidai.aadhar.ServiceImpl.AlertServiceImpl;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/alert")
@CrossOrigin("*")
@Slf4j
public class AlertController {

	@Autowired
	AlertService service;
	
	@Autowired
	JdbcTemplate jdbc;

	// ---------------- GPS ----------------

	@PostMapping("/audit-trail")
	public ResponseEntity<AlertResponseDTO> saveAuditTrail(@RequestBody AlertRequestDTO request) {
		log.info("Saved AuditTrail RequestDto :: {}", request.toString());
		AlertResponseDTO responseDto = service.saveAuditTrail(request);
		log.info("Saved AuditTrail ResponseDto :: {}", responseDto.toString());
		return new ResponseEntity<AlertResponseDTO>(responseDto, HttpStatus.OK);
	}

	// ---------------- Geo Location ----------------

	@PostMapping("/gps-status")
	public ResponseEntity<?> saveGPSStatus(@RequestBody AlertRequestDTO request) {
		log.info("Saved GPSStatus RequestDto :: {}", request.toString());
		AlertResponseDTO responseDto = service.saveGPSStatus(request);
		log.info("Saved GPSStatus ResponseDto :: {}", responseDto.toString());
		return new ResponseEntity<AlertResponseDTO>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/view-gps-status/{agencyCode}")
	public ResponseEntity<?> viewGPSStatus(@PathVariable String agencyCode) {
		return service.viewGPSStatus(agencyCode);
	}
	
	@GetMapping("/view-gps-status")
	public ResponseEntity<?> viewAllGPSStatus() {
		return service.viewAllGPSStatus();
	}
}
