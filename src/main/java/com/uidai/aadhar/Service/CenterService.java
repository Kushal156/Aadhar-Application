package com.uidai.aadhar.Service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import com.uidai.aadhar.DTO.CenterRequestDTO;
import com.uidai.aadhar.Entity.CenterMasterEntity;

public interface CenterService {
	
	public ResponseEntity<?> newCenter(CenterRequestDTO request);
	Page<CenterMasterEntity> view(String search, Integer status, Pageable pageable, List<String> districtName);
	public ResponseEntity<?> districtWiseList(String district);
	public ResponseEntity<?> pendingCenters();
	public ResponseEntity<?> updateCenter(Integer centerId, Integer status);
}
