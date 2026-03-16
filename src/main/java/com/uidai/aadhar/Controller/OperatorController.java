package com.uidai.aadhar.Controller;

import java.time.LocalDate;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
import org.springframework.web.bind.annotation.RequestParam;

import com.uidai.aadhar.DTO.NewOperatorRequestDto;
import com.uidai.aadhar.Service.OperatorService;

@Controller
@RequestMapping("/operator")
@CrossOrigin(origins = "*")
public class OperatorController {
	
	@Autowired
	OperatorService service;

	@PostMapping("/new") 
	public ResponseEntity<?> newOperator(@ModelAttribute NewOperatorRequestDto request) {
		return service.newOperator(request);
	}
	
	@GetMapping("/view")
	public ResponseEntity<?> viewOperator(
			@RequestParam(required = false) String search,
	        @RequestParam(required = false) Integer status,
	        @RequestParam(defaultValue = "1") int page,
	        @RequestParam(defaultValue = "10") int limit,
	        @RequestParam(defaultValue = "createdAt") String sortBy,
	        @RequestParam(defaultValue = "desc") String order,
	        @RequestParam(required = false) String agencyCode,
	        @RequestParam(required = false)
	        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fromDate,
	        @RequestParam(required = false)
	        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate toDate
	) {
		
		Sort sort = order.equalsIgnoreCase("desc")
	            ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();

	    Pageable pageable = PageRequest.of(page - 1, limit, sort);

		return new ResponseEntity(service.view(search, status, pageable, agencyCode, fromDate, toDate), HttpStatus.OK);	
	}
	
	@GetMapping("/view/{operatorId}")
	public ResponseEntity<?> operatorData(@PathVariable String operatorId) {
		return service.operatorData(operatorId);
	}
	
	@PostMapping(value = "/view/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<?> updateOperator(
	        @PathVariable String id, @ModelAttribute NewOperatorRequestDto request) {
	    return service.editOperator(id, request);
	}
	
	@PostMapping("map-operator")
	public ResponseEntity<?> mapOperator(@RequestBody Map<String, Object> request) {
		return service.mapOperator(request);
	}
	
	@PostMapping("/activate/{operatorId}/{status}")
	public ResponseEntity<?> activateOperator(@PathVariable String operatorId, @PathVariable Integer status){
		return service.activateOperator(operatorId, status);
	}
	
	@GetMapping("/pending-list")
	public ResponseEntity<?> pendingOperators(){
		return service.pendingOperators();
	}
	
	//abhay sir api 
	@PostMapping("/info")
	public ResponseEntity<?> operatorInfo(@RequestBody Map<String, Object> request){
		return service.operatorInfo(request);
	}
 
	@PostMapping("/specific-info")
	public ResponseEntity<?> operatorSpecificInfo(@RequestBody Map<String, Object> request){
		return service.operatorSpecificInfo(request);
	}
}
