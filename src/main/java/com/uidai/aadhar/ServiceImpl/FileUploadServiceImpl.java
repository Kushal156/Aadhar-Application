package com.uidai.aadhar.ServiceImpl;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.uidai.aadhar.DTO.FileUploadRequestDTO;
import com.uidai.aadhar.Entity.DeviceMasterEntity;
import com.uidai.aadhar.Entity.FileUploadEntity;
import com.uidai.aadhar.Entity.UidaiOperatorMasterEntity;
import com.uidai.aadhar.Repository.FileUploadRepository;
import com.uidai.aadhar.Repository.UidaiOperatorMasterRepository;
import com.uidai.aadhar.Service.FileUploadService;

import lombok.extern.slf4j.Slf4j;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;

@Service
@Slf4j
public class FileUploadServiceImpl implements FileUploadService {

	@Value("${EODFileUploadPath}")
	private String filePath;

	@Autowired
	FileUploadRepository fileRepository;

	@Autowired
	UidaiOperatorMasterRepository operatorRepo;

	@Override
	public ResponseEntity<?> fileUpload(FileUploadRequestDTO request) {

		Map<String, Object> response = new LinkedHashMap<>();
		try {

			MultipartFile file = request.getFile();

			if (file == null || file.isEmpty()) {

				response.put("status", false);
				response.put("message", "File is mandatory");
				return new ResponseEntity(response, HttpStatus.OK);
			}

			Optional<UidaiOperatorMasterEntity> opData = operatorRepo.findByUidaiId(request.getUidaiID());

			if (!opData.isPresent()) {

				response.put("status", false);
				response.put("message", "Machine ID not found for UIDAI ID : " + request.getUidaiID());
				return new ResponseEntity(response, HttpStatus.OK);
			}

			String machineId = opData.get().getMachineId();

			if (machineId == null || machineId.trim().isEmpty()) {
				response.put("status", false);
				response.put("message", "Machine ID is not mapped for UIDAI ID : " + request.getUidaiID());
				return new ResponseEntity(response, HttpStatus.OK);
			}

			LocalDate today = LocalDate.now();
			String todayFolderName = today.toString();

			Path machineFolderPath = Paths.get(filePath, machineId);
			Path dateFolderPath = machineFolderPath.resolve(todayFolderName);

			if (!Files.exists(dateFolderPath)) {
				Files.createDirectories(dateFolderPath);
			}

			String originalFileName = file.getOriginalFilename();
			if (originalFileName == null || originalFileName.trim().isEmpty()) {

				response.put("status", false);
				response.put("message", "Invalid file name");
				return new ResponseEntity(response, HttpStatus.OK);
			}

			Path fullFilePath = dateFolderPath.resolve(originalFileName);

			if (Files.exists(fullFilePath)) {

				response.put("status", false);
				response.put("message", "File already exists for this machine today");
				return new ResponseEntity(response, HttpStatus.OK);
			}

			Files.copy(file.getInputStream(), fullFilePath);

			FileUploadEntity entity = new FileUploadEntity();
			entity.setUidaiID(request.getUidaiID());
			entity.setMacID(request.getMacID());
			entity.setFileName(originalFileName);
			entity.setFilePath(fullFilePath.toString());
			entity.setUploadDate(today);
			entity.setCreatedAt(LocalDateTime.now());

			fileRepository.save(entity);

			response.put("status", true);
			response.put("message", "File uploaded successfully");
			response.put("filePath", fullFilePath.toString());
			return new ResponseEntity(response, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			
			response.put("status", false);
			response.put("message", "File upload failed");
			return new ResponseEntity(response, HttpStatus.OK);
		}
	}

	// Individual Employee File Upload Status
	@Override
	public ResponseEntity<?> fileUploadStatus(String uidaiID) {
		Map<String, Object> response = new LinkedHashMap<>();
		log.info("UIDAI ID :: {}", uidaiID);
		try {

			Optional<FileUploadEntity> data = fileRepository.findByUidaiID(uidaiID);

			if (!data.isPresent()) {
				response.put("status", false);
				response.put("message", "Device not found");
				response.put("data", Collections.emptyMap());
				return new ResponseEntity<>(response, HttpStatus.OK);
			}

			response.put("status", true);
			response.put("message", "EOD File Upload data retrieved successfully");
			response.put("data", data.get());

		} catch (Exception e) {
			log.error("Exception in file upload status :: {}", e.getMessage());

			response.put("status", false);
			response.put("message", "Error while fetching EOD File Upload data");
			response.put("data", Collections.emptyMap());
		}

		return new ResponseEntity(response, HttpStatus.OK);
	}

}