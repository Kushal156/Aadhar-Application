package com.uidai.aadhar.Controller;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

import com.uidai.aadhar.DTO.CenterRequestDTO;
import com.uidai.aadhar.Service.CenterService;

@Controller
@RequestMapping("/center")
@CrossOrigin(origins = "*")
public class CenterController {
	
	@Autowired
	CenterService service;

	@PostMapping("/new") 
	public ResponseEntity<?> newCenter(@RequestBody CenterRequestDTO request) {
		return service.newCenter(request);
	}
	
	@GetMapping("/view")
	public ResponseEntity<?> deviceList(
			@RequestParam(required = false) String search,
	        @RequestParam(required = false) Integer status,
	        @RequestParam(defaultValue = "1") int page,
	        @RequestParam(defaultValue = "10") int limit,
	        @RequestParam(defaultValue = "createdAt") String sortBy,
	        @RequestParam(defaultValue = "desc") String order,
	        @RequestParam(required = false) List<String> districtName
	     ) {
		Sort sort = order.equalsIgnoreCase("desc")
	            ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();

	    Pageable pageable = PageRequest.of(page - 1, limit, sort);

		return new ResponseEntity(service.view(search, status, pageable, districtName), HttpStatus.OK);
	}
	
	@GetMapping("/view/{district}")
	public ResponseEntity<?> districtWiseList(@PathVariable String district) {
		 
		String decodedDistrict = URLDecoder.decode(district);
		System.out.println("decodedDistrict :: {}" + decodedDistrict);
		return service.districtWiseList(district);
	}
	
	@GetMapping("/view/pending")
	public ResponseEntity<?> pendingCenters() {
		return service.pendingCenters();
	}
	
	@PutMapping("/update/{centerId}/{status}")
	public ResponseEntity<?> updateCenter(@PathVariable Integer centerId, @PathVariable Integer status){
		return service.updateCenter(centerId, status);
	}
}
