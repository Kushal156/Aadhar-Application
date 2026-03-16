package com.uidai.aadhar.ServiceImpl;

import static org.springframework.data.jpa.domain.Specification.where;

import java.time.LocalDate;

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
import com.uidai.aadhar.DTO.DeviceRegistrationRequestDto;
import com.uidai.aadhar.DTO.DeviceRegistrationResponseDto;
import com.uidai.aadhar.Entity.DeviceMasterEntity;
import com.uidai.aadhar.Repository.DeviceMasterRepository;
import com.uidai.aadhar.Service.DeviceService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DeviceServiceImpl implements DeviceService {

	@Autowired
	private DeviceMasterRepository deviceRepo;
	
	@Override
	public DeviceRegistrationResponseDto registerDevice(DeviceRegistrationRequestDto requestDto) {
		
		DeviceRegistrationResponseDto responseDto = new DeviceRegistrationResponseDto();
		DeviceMasterEntity device = new DeviceMasterEntity();
		try {
		
		device.setSerialNo(requestDto.getDeviceSerialNo());
		device.setMacAddress(requestDto.getDeviceMacAddress());
		device.setDeviceMake(requestDto.getDeviceMake());
		device.setDeviceModel(requestDto.getDeviceModel());
		device.setDeviceSiName(requestDto.getDeviceSIName());
		device.setDistrictName(requestDto.getDistrictName());
		device.setVkid(requestDto.getVkId());
		device.setMachineId(requestDto.getMachineId());
		device.setStationId(requestDto.getStationId());
		device.setRegistrationDate(LocalDate.now());
		device.setIsActive(0);
		
		device = deviceRepo.save(device);
		log.info("Device Registered and inserted entry in database :: {}", device.toString());
		
		responseDto.setMessage("Device Registered Successfully");
		responseDto.setStatus(true);
		
		}catch (Exception e) {
			e.printStackTrace();
			log.info("Exception occured :: {}", e.getMessage());
			responseDto.setMessage("Error Occurred, Please try again");
			responseDto.setStatus(false);
		}	
		return responseDto;
	}

	@Override
	public Page<DeviceMasterEntity> view(String search, Integer status, Pageable pageable, String agencyCode, LocalDate fromDate, LocalDate toDate) {
		
		log.info("Search :: {}, Status :: {}, Pageable :: {}, AgencyCode :: {}, FromDate :: {}, ToDate :: {}", search, status, pageable, agencyCode, fromDate, toDate);
		
		Specification<DeviceMasterEntity> specification =
                where(DeviceSpecification.search(search))
                        .and(DeviceSpecification.hasStatus(status)
                        .and(DeviceSpecification.hasAgencyCode(agencyCode))
                        .and(DeviceSpecification.createdBetween(fromDate, toDate)));

        return deviceRepo.findAll(specification, pageable);
	}
	
	@Override
	public ResponseEntity<?> deviceData(String id) {
		Map<String, Object> response = new LinkedHashMap();
		log.info("Device ID :: {}", id);
		try {

			Optional<DeviceMasterEntity> data = deviceRepo.findBySerialNo(id);

			if (!data.isPresent()) {
				response.put("status", false);
				response.put("message", "Device not found");
				response.put("data", Collections.emptyMap());
				return new ResponseEntity<>(response, HttpStatus.OK);
			}

			response.put("status", true);
			response.put("message", "Device data retrieved successfully");
			response.put("data", data.get());

		} catch (Exception e) {
			log.error("Exception in view Operator :: {}", e.getMessage());

			response.put("status", false);
			response.put("message", "Error while fetching device data");
			response.put("data", Collections.emptyMap());
		}

		return new ResponseEntity(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> editDevice(String id, DeviceRegistrationRequestDto request) {
		
		log.info("Device ID :: {}, Update Request :: {}", id, request.toString());
		Map<String, Object> response = new LinkedHashMap<>();

		try {

			Optional<DeviceMasterEntity> optionalEntity = deviceRepo.findBySerialNo(id);

			if (!optionalEntity.isPresent()) {
				response.put("status", false);
				response.put("message", "No Device found");
				return new ResponseEntity<>(response, HttpStatus.OK);
			}
			
			DeviceMasterEntity entity = optionalEntity.get();
			
			if (request.getDeviceSerialNo() != null)
				entity.setSerialNo(request.getDeviceSerialNo());

			if (request.getDeviceMacAddress() != null)
				entity.setMacAddress(request.getDeviceMacAddress());

			if (request.getDeviceMake() != null)
				entity.setDeviceMake(request.getDeviceMake());

			if (request.getDeviceModel() != null)
				entity.setDeviceModel(request.getDeviceModel());

			if (request.getDeviceSIName() != null)
				entity.setDeviceSiName(request.getDeviceSIName());

			if (request.getDistrictName() != null)
				entity.setDistrictName(request.getDistrictName());

			if (request.getMachineId() != null)
				entity.setMachineId(request.getMachineId());

			if (request.getStationId() != null)
				entity.setStationId(request.getStationId());

			deviceRepo.save(entity);

			response.put("status", true);
			response.put("message", "Device data updated successfully");

		} catch (Exception e) {
			log.error("Exception in updating Device Data :: {}", e);
			response.put("status", false);
			response.put("message", "Error while updating Device data");
		}
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> activateDevice(Long deviceId, Integer status) {
		Map<String, Object> response = new LinkedHashMap<>();
		//1 - active, 0 - inactive
		log.info("Activation Device ID :: {}, status :: {}", deviceId, status);
		
		try {
			
			Optional<DeviceMasterEntity> data = deviceRepo.findById(deviceId);

			if (!data.isPresent()) {
				response.put("status", false);
				response.put("message", "Device not found");
				return new ResponseEntity<>(response, HttpStatus.OK);
			}

			
			DeviceMasterEntity entity = data.get();
			if(deviceId != null && status != null) {
				entity.setIsActive(status);
				deviceRepo.save(entity);
			}
			
			response.put("status", true);
			response.put("message", "Device status changed successfully");
			
		} catch(Exception e) {
			log.error("Exception in operator Mapping :: {}", e);
			response.put("status", false);
			response.put("message", "Error while changing status of device");
		}
		return ResponseEntity.ok(response);
	}

	@Override
	public ResponseEntity<?> pendingDevices() {
		
		List<DeviceMasterEntity> pendingDevice = deviceRepo.findByIsActive(0);
		return ResponseEntity.ok(pendingDevice);
	}

}
