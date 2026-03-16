package com.uidai.aadhar.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uidai.aadhar.Service.DashBoardService;

@RestController
@RequestMapping("/dashboard")
@CrossOrigin(origins = "*")
//@CrossOrigin(
//	    origins = "http://localhost:5173",
//	    methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS, RequestMethod.PUT },
//	    allowedHeaders = "*",
//	    allowCredentials = "true",
//	    maxAge = 3600
//	)
public class DashboardController {
	
	@Autowired
	DashBoardService service;
	
	
//	@GetMapping("/data")
//	public ResponseEntity<?> dashData() {
//		return service.dashData();
//	}
	
	@GetMapping("/data/{agencyCode}")
	public ResponseEntity<?> dashData(@PathVariable String agencyCode) {
		return service.dashData(agencyCode);
	}

	@GetMapping("login-info/{username}")
	public ResponseEntity<?> loginInfo(@PathVariable String username){
		return service.loginInfo(username);
	}
	
	@GetMapping("/agency-list")
	public ResponseEntity<?> agencyList(){
		return service.agencyList();
	}
}
