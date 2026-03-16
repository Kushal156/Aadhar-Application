package com.uidai.aadhar.Controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uidai.aadhar.DTO.DeviceRegistrationRequestDto;
import com.uidai.aadhar.DTO.DeviceRegistrationResponseDto;
import com.uidai.aadhar.Service.DeviceService;

@Controller
@RequestMapping("/device")
@CrossOrigin(origins = "*")
public class DeviceController {
	
	@Autowired
	private DeviceService service;

	@PostMapping("/new")
	public ResponseEntity<DeviceRegistrationResponseDto> deviceRegistration(@RequestBody DeviceRegistrationRequestDto requestDto){
		return new ResponseEntity<DeviceRegistrationResponseDto>
		(service.registerDevice(requestDto), HttpStatus.OK);
	}
	
	@GetMapping("/view")
	public ResponseEntity<?> deviceList(
			@RequestParam(required = false) String search,
	        @RequestParam(required = false) Integer status,
	        @RequestParam(defaultValue = "1") int page,
	        @RequestParam(defaultValue = "10") int limit,
	        @RequestParam(defaultValue = "registrationDate") String sortBy,
	        @RequestParam(defaultValue = "desc") String order,
	        @RequestParam(required = false) String agencyCode,
	        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fromDate,
	        @RequestParam(required = false)
	        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate toDate
	     ) {
		Sort sort = order.equalsIgnoreCase("desc")
	            ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();

	    Pageable pageable = PageRequest.of(page - 1, limit, sort);

		return new ResponseEntity(service.view(search, status, pageable, agencyCode, fromDate, toDate), HttpStatus.OK);
	}

	@GetMapping("/view/{deviceId}")
	public ResponseEntity<?> operatorData(@PathVariable String deviceId) {
		return service.deviceData(deviceId);
	}
	
	@PutMapping(value = "/view/{id}")
	public ResponseEntity<?> updateOperator(
	        @PathVariable String id, @RequestBody DeviceRegistrationRequestDto request) {
	    return service.editDevice(id, request);
	}
	
	@PostMapping("/activate/{deviceId}/{status}")
	public ResponseEntity<?> activateDevice(@PathVariable Long deviceId, @PathVariable Integer status){
		return service.activateDevice(deviceId, status);
	}
	
	@GetMapping("/pending-list")
	public ResponseEntity<?> pendingOperators(){
		return service.pendingDevices();
	}
}
