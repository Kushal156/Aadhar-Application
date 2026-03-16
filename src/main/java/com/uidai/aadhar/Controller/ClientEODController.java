package com.uidai.aadhar.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uidai.aadhar.DTO.ClientEODRequest;
import com.uidai.aadhar.Service.ClientEODService;

@RestController
@RequestMapping("/clientEOD")
@CrossOrigin(
	    origins = "http://localhost:5173",
	    methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS, RequestMethod.PUT },
	    allowedHeaders = "*",
	    allowCredentials = "true",
	    maxAge = 3600
	)
public class ClientEODController {
	
	@Autowired
	ClientEODService service;

	@PostMapping("get-enrollment")
	public ResponseEntity<?> getEnrollment(@RequestBody ClientEODRequest request){
		return service.getEnrollment(request);
	}
	
	@GetMapping("get-all-enrollment")
	public ResponseEntity<?>getAllEnrollment(){
		return service.getEnrollmentFullData();
	}
	
	@GetMapping("get-machineid")
	public ResponseEntity<?>getmachineId(){
		return service.getMachineId();
	}
}