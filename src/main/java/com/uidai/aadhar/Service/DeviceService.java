package com.uidai.aadhar.Service;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import com.uidai.aadhar.DTO.DeviceRegistrationRequestDto;
import com.uidai.aadhar.DTO.DeviceRegistrationResponseDto;
import com.uidai.aadhar.Entity.DeviceMasterEntity;

public interface DeviceService {

	public DeviceRegistrationResponseDto registerDevice(DeviceRegistrationRequestDto requestDto);
	Page<DeviceMasterEntity> view(String search, Integer status, Pageable pageable, String agencyCode, LocalDate fromDate, LocalDate toDate);
	public ResponseEntity<?> deviceData(String deviceId);
	public ResponseEntity<?> editDevice(String id, DeviceRegistrationRequestDto request);
	public ResponseEntity<?> activateDevice(Long deviceId, Integer status);
	public ResponseEntity<?> pendingDevices();
}
