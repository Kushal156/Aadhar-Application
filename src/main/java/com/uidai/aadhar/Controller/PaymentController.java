package com.uidai.aadhar.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uidai.aadhar.DTO.PayCollectReqDTO;
import com.uidai.aadhar.Service.PayService;

import java.io.FileNotFoundException;
import java.security.NoSuchAlgorithmException;

import javax.validation.Valid;

@RequestMapping("/pay")
@RestController
public class PaymentController {
	
	@Autowired
	PayService service;
	
	@PostMapping("/payment-collection")
	public ResponseEntity<?> payCollect(@Valid @RequestBody PayCollectReqDTO request) 
			throws NoSuchAlgorithmException, FileNotFoundException {
		return service.payCollect(request);
	}
	
	@PostMapping("/call-back")
	public ResponseEntity<?> callBack(
			@RequestParam("encResp") String encResp){
		return service.callBack(encResp);
	}

}
