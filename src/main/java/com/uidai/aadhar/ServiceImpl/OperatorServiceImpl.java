package com.uidai.aadhar.ServiceImpl;

import static org.springframework.data.jpa.domain.Specification.where;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.uidai.aadhar.DTO.NewOperatorRequestDto;
import com.uidai.aadhar.DTO.UidaiOperatorMasterEntityDto;
import com.uidai.aadhar.Entity.CenterMasterEntity;
import com.uidai.aadhar.Entity.DeviceMasterEntity;
import com.uidai.aadhar.Entity.OperatorMasterSPEntity;
import com.uidai.aadhar.Entity.UidaiOperatorMasterEntity;
import com.uidai.aadhar.Repository.DeviceMasterRepository;
import com.uidai.aadhar.Repository.OperatorMasterSPRepository;
import com.uidai.aadhar.Repository.UidaiOperatorMasterRepository;
import com.uidai.aadhar.Service.OperatorService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OperatorServiceImpl implements OperatorService {

	@Autowired
	UidaiOperatorMasterRepository operatorRepo;
	
	@Autowired
	private OperatorMasterSPRepository spRepo;

	@Autowired
	DeviceMasterRepository deviceRepo;
	
	@Autowired
	HelperService help;
	
	@Override
	public ResponseEntity<?> newOperator(NewOperatorRequestDto request) {
		
		log.info("New Operator Request for SP :: {}", request.toString());
		Map<String, Object> MapResponse = new LinkedHashMap<>();
		try {
			// Extract filenames
	        String aadharFile = help.getFileName(request.getAadharCopy());
	        String qualificationFile = help.getFileName(request.getQualificationEquivalent());
	        String nseitFile = help.getFileName(request.getNseitCert());
	        String panFile = help.getFileName(request.getPanCopy());
	        String concernFile = help.getFileName(request.getConcernLetter());
	        String policeFile = help.getFileName(request.getPoliceVerification());
	        String affidavitFile = help.getFileName(request.getOperatorAffidavit());
			
	        // Call SP
	        OperatorMasterSPEntity response = spRepo.insertOperatorDetails(
	                request.getUidaiId(),
	                request.getOperatorName(),
	                request.getFamilyMemName(),
	                request.getDob(),
	                request.getEmailId(),
	                request.getAadharNo(),
	                request.getPanNo(),
	                request.getQualification(),
	                request.getGender(),
	                request.getMaritalStatus(),
	                request.getOperatorType(),
	                request.getCertificateNo(),
	                request.getCertificationIssueDate(),
	                request.getCertificationExpDate(),
	                request.getCertificateRegId(),
	                request.getDistrictName(),
	                aadharFile,
	                qualificationFile,
	                nseitFile,
	                panFile,
	                concernFile,
	                policeFile,
	                affidavitFile,
	                request.getStateName(),
	                request.getMachineId(),
	                "Pass@12",        // Hard coded
	                100,                 // Lat-Long Distance Apart
	                request.getRegLat(),
	                request.getRegLong(),
	                request.getAgencyCode(),
	            	request.getCenterId(),
	            	request.getCenterName()
	        );
	        
	        if(response.getOperatorId() != null) {
	        	MapResponse.put("status", true);
		        MapResponse.put("message", "Operator details saved successfully");
	        }
	        else {
	        	MapResponse.put("status", false);
		        MapResponse.put("message", response.getMessage());
	        }
	        return ResponseEntity.ok(MapResponse);
			
		} catch (Exception e) {
			log.error("Error inserting operator", e);
			MapResponse.put("status", false);
			MapResponse.put("message", "Failed to save operator details");
	        return ResponseEntity.ok().body(MapResponse);
		}
	}

	@Override
	public Page<UidaiOperatorMasterEntity> view(String search, Integer status, Pageable pageable, String agencyCode, 
			LocalDate fromDate, LocalDate toDate) {

		log.info("Search :: {}, Status :: {}, Pageable :: {}", search, status, pageable);
		
		LocalDateTime fromDateTime = null;
	    LocalDateTime toDateTime = null;
		if (fromDate != null) {
	        fromDateTime = fromDate.atStartOfDay();
	    }

	    if (toDate != null) {
	        toDateTime = toDate.atTime(LocalTime.MAX);
	    }

		Specification<UidaiOperatorMasterEntity> specification = where(OpertorSpecification.search(search))
				.and(OpertorSpecification.hasStatus(status)
				.and(OpertorSpecification.hasAgencyCode(agencyCode))
				.and(OpertorSpecification.createdBetween(fromDateTime, toDateTime)));

		return operatorRepo.findAll(specification, pageable);
	}

	@Override
	public ResponseEntity<?> operatorData(String id) {

		Map<String, Object> response = new LinkedHashMap<>();
		log.info("Operator ID :: {}", id);
		try {

			Optional<UidaiOperatorMasterEntity> data = operatorRepo.findByOperatorId(id);

			if (!data.isPresent()) {
				response.put("status", false);
				response.put("message", "Operator not found");
				response.put("data", Collections.emptyMap());
				return new ResponseEntity<>(response, HttpStatus.OK);
			}

			response.put("status", true);
			response.put("message", "Operator data retrieved successfully");
			response.put("data", data.get());

		} catch (Exception e) {
			log.error("Exception in view Operator :: {}", e.getMessage());

			response.put("status", false);
			response.put("message", "Error while fetching operator data");
			response.put("data", Collections.emptyMap());
		}

		return new ResponseEntity(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> editOperator(String id, NewOperatorRequestDto request) {

		log.info("Operator ID :: {}, Update Request :: {}", id, request.toString());
		Map<String, Object> response = new LinkedHashMap<>();

		try {

			Optional<UidaiOperatorMasterEntity> optionalEntity = operatorRepo.findByOperatorId(id);

			if (!optionalEntity.isPresent()) {
				response.put("status", false);
				response.put("message", "No Operator found");
				return new ResponseEntity<>(response, HttpStatus.OK);
			}

			UidaiOperatorMasterEntity entity = optionalEntity.get();

			// ---------------- Personal Details ----------------
			if(request.getUidaiId() != null)
				entity.setUidaiId(request.getUidaiId());
			
			if (request.getOperatorName() != null)
				entity.setOperatorName(request.getOperatorName());

			if (request.getFamilyMemName() != null)
				entity.setFamilyMemName(request.getFamilyMemName());

			if (request.getDob() != null)
				entity.setDob(request.getDob());

			if (request.getEmailId() != null)
				entity.setEmailId(request.getEmailId());

			if (request.getAadharNo() != null)
				entity.setAadharNo(request.getAadharNo());

			if (request.getPanNo() != null)
				entity.setPanNo(request.getPanNo());

			if (request.getQualification() != null)
				entity.setQualification(request.getQualification());

			if (request.getGender() != null)
				entity.setGender(request.getGender());

			if (request.getMaritalStatus() != null)
				entity.setMaritalStatus(request.getMaritalStatus());

			if (request.getStateName() != null)
				entity.setStateName(request.getStateName());

			if (request.getDistrictName() != null)
				entity.setDistrictName(request.getDistrictName());

			// ---------------- NSEIT Certificate Details ----------------
			if (request.getOperatorType() != null)
				entity.setOperatorType(request.getOperatorType());

			if (request.getCertificateNo() != null)
				entity.setCertificateNo(request.getCertificateNo());

			if (request.getCertificationIssueDate() != null)
				entity.setCertificationIssueDate(request.getCertificationIssueDate());

			if (request.getCertificationExpDate() != null)
				entity.setCertificationExpDate(request.getCertificationExpDate());

			if (request.getCertificateRegId() != null)
				entity.setCertificateRegId(request.getCertificateRegId());

			if (request.getMachineId() != null)
				entity.setMachineId(request.getMachineId());

			// ---------------- Documents ----------------
			if (request.getAadharCopy() != null && !request.getAadharCopy().isEmpty()) {
				String fileName = help.saveFile(request.getAadharCopy());
				entity.setAadharCopyFile(fileName);
			}

			if (request.getQualificationEquivalent() != null && !request.getQualificationEquivalent().isEmpty()) {
				String fileName = help.saveFile(request.getQualificationEquivalent());
				entity.setQualificationEquivalentFile(fileName);
			}

			if (request.getNseitCert() != null && !request.getNseitCert().isEmpty()) {
				String fileName = help.saveFile(request.getNseitCert());
				entity.setNseitCertFile(fileName);
			}

			if (request.getPanCopy() != null && !request.getPanCopy().isEmpty()) {
				String fileName = help.saveFile(request.getPanCopy());
				entity.setPanCopyFile(fileName);
			}

			if (request.getConcernLetter() != null && !request.getConcernLetter().isEmpty()) {
				String fileName = help.saveFile(request.getConcernLetter());
				entity.setConcernLetterFile(fileName);
			}

			if (request.getPoliceVerification() != null && !request.getPoliceVerification().isEmpty()) {
				String fileName = help.saveFile(request.getPoliceVerification());
				entity.setPoliceVerificationFile(fileName);
			}

			if (request.getOperatorAffidavit() != null && !request.getOperatorAffidavit().isEmpty()) {
				String fileName = help.saveFile(request.getOperatorAffidavit());
				entity.setOperatorAffidavitFile(fileName);
			}

			operatorRepo.save(entity);

			response.put("status", true);
			response.put("message", "Operator data updated successfully");

		} catch (Exception e) {
			log.error("Exception in updating Operator :: {}", e, e);
			response.put("status", false);
			response.put("message", "Error while updating operator data");
		}

		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	

	@Override
	public ResponseEntity<?> operatorInfo(Map<String, Object> request) {
		String userName = (String) request.get("userName");
		String password = (String) request.get("password");
		String macID = (String) request.get("macID");
		
		Map<String, Object> response = new LinkedHashMap<>();

		log.info("userName :: {}, password :: {}, macID :: {}", userName, password, macID);

		try {
			Optional<UidaiOperatorMasterEntity> data = operatorRepo.usernamePass(userName, password, macID);
			
			log.info("data === {}", data.toString());

			if (!data.isPresent()) {
				response.put("status", false);
				response.put("message", "No operator found : " + userName);
				response.put("data", Collections.emptyList());
				
				return new ResponseEntity(response, HttpStatus.OK);
			}
			
			response.put("status", true);
			response.put("message", "Operator found : " + userName);
			response.put("data", data.get());

		} catch (Exception e) {
			log.error("Exception in Operator Info :: {}", e.getMessage());

			response.put("status", false);
			response.put("message", "Error while fetching operator data");
			response.put("data", Collections.emptyList());
		}
		return new ResponseEntity(response, HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<?> operatorSpecificInfo(Map<String, Object> request) {
		String userName = (String) request.get("userName");
		String macID = (String) request.get("macID");
		
		Map<String, Object> response = new LinkedHashMap<>();

		log.info("userName :: {}, macID :: {}", userName, macID);

		try {
			Optional<UidaiOperatorMasterEntity> data = operatorRepo.usernamePassSpecificInfo(userName, macID);
			
			log.info("data === {}", data.toString());

			if (!data.isPresent()) {
				response.put("status", false);
				response.put("message", "No operator found : " + userName);
				response.put("data", Collections.emptyList());
				
				return new ResponseEntity(response, HttpStatus.OK);
			}
			UidaiOperatorMasterEntity entity1 = data.get();
			UidaiOperatorMasterEntityDto dto = new UidaiOperatorMasterEntityDto(); 
			dto.setUidaiId(entity1.getUidaiId());
			dto.setMachineId(entity1.getMachineId());
			dto.setLatLongDistance(entity1.getLatLongDistance());
			dto.setRegLat(entity1.getRegLat());
			dto.setRegLong(entity1.getRegLong());
			dto.setOperatorName(entity1.getOperatorName());
			dto.setDeviceMapped(entity1.getDeviceMapped());
			
			response.put("status", true);
			response.put("message", "Operator found : " + userName);
			response.put("data", dto);

		} catch (Exception e) {
			log.error("Exception in Operator Info :: {}", e.getMessage());

			response.put("status", false);
			response.put("message", "Error while fetching operator data");
			response.put("data", Collections.emptyList());
		}
		return new ResponseEntity(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> mapOperator(Map<String, Object> request) {
		String macID = (String) request.get("macID");
		String operatorID = (String) request.get("operatorID");
		Map<String, Object> response = new LinkedHashMap<>();
		
		log.info("MAC ID to be mapped :: {} to UIDAI ID :: {}", macID, operatorID);
		
		try {
			
			Optional<UidaiOperatorMasterEntity> optionalEntity = operatorRepo.findByOperatorId(operatorID);
			Optional<DeviceMasterEntity> optionalDeviceEntity = deviceRepo.findByMacAddress(macID);
			
			if (!optionalEntity.isPresent()) {
				response.put("status", false);
				response.put("message", "No Operator found");
				return new ResponseEntity<>(response, HttpStatus.OK);
			} else if(!optionalDeviceEntity.isPresent()) {
				response.put("status", false);
				response.put("message", "No Device found");
				return new ResponseEntity<>(response, HttpStatus.OK);
			}
			
			UidaiOperatorMasterEntity entity = optionalEntity.get();
			DeviceMasterEntity deviceEntity = optionalDeviceEntity.get();
			log.info("Information of the UIDAI Operator :: {}", optionalEntity.get());
			log.info("Information of the Device :: {}", optionalDeviceEntity.get());
			
			if (macID != null && operatorID != null) {
				
				entity.setDeviceMapped(macID);
				operatorRepo.save(entity);
				
				deviceEntity.setOperatoMapped(operatorID);
				deviceRepo.save(deviceEntity);
			}
			
			response.put("status", true);
			response.put("message", "Device Mapped successfully");
			
		} catch(Exception e) {
			log.error("Exception in operator Mapping :: {}", e);
			response.put("status", false);
			response.put("message", "Error while fetching operator data");
			response.put("data", Collections.emptyMap());
		}
		return new ResponseEntity(response, HttpStatus.OK);	
	}

	@Override
	public ResponseEntity<?> activateOperator(String operatorId, Integer status) {
		Map<String, Object> response = new LinkedHashMap<>();
		//1 - active, 0 - inactive
		log.info("Activation Operator ID :: {}, status :: {}", operatorId, status);
		
		try {
			
			Optional<UidaiOperatorMasterEntity> optionalEntity = operatorRepo.findByOperatorId(operatorId);
			if (!optionalEntity.isPresent()) {
				response.put("status", false);
				response.put("message", "No Operator found");
				return new ResponseEntity<>(response, HttpStatus.OK);
			}
			
			UidaiOperatorMasterEntity entity = optionalEntity.get();
			if(operatorId != null && status != null) {
				entity.setIsActive(status);
				operatorRepo.save(entity);
			}
			
			response.put("status", true);
			response.put("message", "Operator status changed successfully");
			
		} catch(Exception e) {
			log.error("Exception in operator Mapping :: {}", e);
			response.put("status", false);
			response.put("message", "Error while changing status of operator");
		}
		return ResponseEntity.ok(response);
	}

	@Override
	public ResponseEntity<?> pendingOperators() {
		log.info("Pending Operators for Agency .....");
		
		List<UidaiOperatorMasterEntity> pendingOperators = operatorRepo.findByIsActive(0);
		return ResponseEntity.ok(pendingOperators);
	}
}
