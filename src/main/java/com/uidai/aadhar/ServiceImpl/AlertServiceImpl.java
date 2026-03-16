package com.uidai.aadhar.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.uidai.aadhar.DTO.AlertRequestDTO;
import com.uidai.aadhar.DTO.AlertResponseDTO;
import com.uidai.aadhar.Entity.AuditTrailEntity;
import com.uidai.aadhar.Entity.GPSStatusEntity;
import com.uidai.aadhar.Repository.AuditTrailRepopsitory;
import com.uidai.aadhar.Repository.GPSStatusRepository;
import com.uidai.aadhar.Service.AlertService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AlertServiceImpl implements AlertService {

	@Autowired
	private AuditTrailRepopsitory auditTrailRepopsitory;

	@Autowired
	private GPSStatusRepository gpsRepo;

	public AlertResponseDTO saveAuditTrail(AlertRequestDTO requestDTO) {
		AlertResponseDTO responseDto = new AlertResponseDTO();
		try {
			AuditTrailEntity entity = new AuditTrailEntity();
			entity.setUserId(requestDTO.getUser_id());
			entity.setMacId(requestDTO.getMac_id());
			entity.setLatitude(requestDTO.getLatitude());
			entity.setLongitude(requestDTO.getLongitude());
			entity.setDistrict(requestDTO.getDistrict());
			entity = auditTrailRepopsitory.save(entity);
			log.info("Saved AuditTrailEntity :: {}", entity.toString());
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Exception occured while saving AuditTrailData :: {}", e.getMessage());
			responseDto.setResponse_message("Exception occured:" + e.getMessage());
			responseDto.setStatus(false);
		}
		responseDto.setResponse_message("Data Saved successfully");
		responseDto.setStatus(true);
		return responseDto;
	}

	public AlertResponseDTO saveGPSStatus(AlertRequestDTO request) {

		log.info("Save GPS Status Request :: {}", request.toString());
		AlertResponseDTO responseDto = new AlertResponseDTO();
		try {

			Object response = gpsRepo.insertGps(request.getUser_id(), request.getMac_id(), request.getGps_status(),
					request.getGpsFlag());

			if (response != null) {

				Object[] row = (Object[]) response;

				if (row[0] != null) {

					log.info("Saved GPS Procedure :: ID = {}", row[0]);

					responseDto.setResponse_message("Data Saved Successfully");
					responseDto.setStatus(true);
					return responseDto;
				}
			}
			responseDto.setResponse_message("Failed to save GPS status");
			responseDto.setStatus(false);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Exception occured while saving GPSStatusEntity :: {}", e.getMessage());
			responseDto.setResponse_message("Exception occured:" + e.getMessage());
			responseDto.setStatus(false);
		}
		return responseDto;
	}

	@Override
	public ResponseEntity<?> viewGPSStatus(String agencyCode) {
		log.info("Agency Code for Alerts :: {}", agencyCode);

		List<GPSStatusEntity> alerts = gpsRepo.findByAgencyCode(agencyCode);

		return ResponseEntity.ok(alerts);
	}

	@Override
	public ResponseEntity<?> viewAllGPSStatus() {
		log.info("Inside view all GPS Status.................");
		
		List<GPSStatusEntity> alerts = gpsRepo.findAll();
		return ResponseEntity.ok(alerts);
	}
}
