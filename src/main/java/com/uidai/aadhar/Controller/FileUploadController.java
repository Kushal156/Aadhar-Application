package com.uidai.aadhar.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uidai.aadhar.DTO.FileUploadRequestDTO;
import com.uidai.aadhar.Service.FileUploadService;

@RestController
@RequestMapping("/file-upload")
@CrossOrigin(origins = "*")
public class FileUploadController {
	
	@Autowired
	FileUploadService service;

	@PostMapping("/EOD")
	public ResponseEntity<?> fileUpload(@ModelAttribute FileUploadRequestDTO request) {
		return service.fileUpload(request);
	}
	
	@GetMapping("/EOD/Status/{uidaiID}")
	public ResponseEntity<?> fileUploadStatus(@PathVariable String uidaiID) {
		return service.fileUploadStatus(uidaiID);
	}
	
}
