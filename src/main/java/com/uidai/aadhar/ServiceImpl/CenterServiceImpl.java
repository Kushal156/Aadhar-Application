package com.uidai.aadhar.ServiceImpl;

import static org.springframework.data.jpa.domain.Specification.where;

import java.time.LocalDateTime;
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

import com.uidai.aadhar.DTO.CenterRequestDTO;
import com.uidai.aadhar.Entity.CenterMasterEntity;
import com.uidai.aadhar.Entity.UidaiOperatorMasterEntity;
import com.uidai.aadhar.Repository.CenterMasterRepository;
import com.uidai.aadhar.Service.CenterService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CenterServiceImpl implements CenterService {

	@Autowired
	CenterMasterRepository centerRepo;

	@Autowired
	HelperService help;

	@Override
	public ResponseEntity<?> newCenter(CenterRequestDTO request) {

		log.info("New Center Request :: {}", request.toString());
		Map<String, Object> response = new LinkedHashMap<>();
		try {

			CenterMasterEntity entity = new CenterMasterEntity();

			entity.setCenterName(request.getCenterName());
			entity.setCenterAdd(request.getCenterAdd());
			entity.setCenterPin(request.getCenterPincode());
			entity.setDistrictName(request.getDistrictName());
			entity.setGeoTags(request.getGeoTags());
			entity.setSeatCap(request.getSeatingCap());
			entity.setCenterType(request.getCenterType());
			entity.setCenterSubType(request.getCenterSubType());
			entity.setIsActive(2);
			entity.setCreatedAt(LocalDateTime.now());

			centerRepo.save(entity);

			response.put("status", true);
			response.put("message", "Device details saved successfully");
		} catch (Exception e) {
			log.error("Error while saving operator details :: {}", e);
			response.put("status", false);
			response.put("message", "Failed to save device details");
		}

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	public Page<CenterMasterEntity> view(String search, Integer status, Pageable pageable, List<String> districtName) {

		log.info("Search :: {}, Status :: {}, Pageable :: {}, Districts :: {}", search, status, pageable, districtName!=null ? districtName.toString() : "null");

		Specification<CenterMasterEntity> specification = where(CenterSpecification.search(search))
				.and(CenterSpecification.hasStatus(status)
				.and(CenterSpecification.hasDistricts(districtName)));

		return centerRepo.findAll(specification, pageable);
	}

	
	@Override
	public ResponseEntity<?> districtWiseList(String district) {
		
		log.info("District in Request :: {}", district);
//		List<CenterMasterEntity> districts = centerRepo.findByDistrictName(district);
		List<CenterMasterEntity> districts = centerRepo.findByDistrictName1(district);
		
		log.info("Centers under the district :: {}", districts.toString());
		
		return ResponseEntity.ok(districts);
	}
	
	@Override
	public ResponseEntity<?> pendingCenters() {
		
		List<CenterMasterEntity> pendingCenters = centerRepo.findByIsActive(2);
		return ResponseEntity.ok(pendingCenters);
	}

	@Override
	public ResponseEntity<?> updateCenter(Integer centerId, Integer status) {
		
		// 1 - active, 0 - inactive, 2 - pending 
		log.info("Center ID :: {}, Status :: {}", centerId, status);
		Map<String, Object> response = new LinkedHashMap<>();
		try {
			Optional<CenterMasterEntity> optionalEntity = centerRepo.findById(centerId.longValue());
			
			if (!optionalEntity.isPresent()) {
				response.put("status", false);
				response.put("message", "No Center found");
				return new ResponseEntity<>(response, HttpStatus.OK);
			}
			
			CenterMasterEntity entity = optionalEntity.get();
			if(status != null) {
				entity.setIsActive(status);
			}
			centerRepo.save(entity);
			
			response.put("status", true);
			response.put("message", "Center updated successfully");
			
		} catch(Exception e) {
			log.error("Exception in updating Device Data :: {}", e);
			response.put("status", false);
			response.put("message", "Error while updating Center");
		}
		return ResponseEntity.ok(response);
	}
}
