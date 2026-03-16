package com.uidai.aadhar.ServiceImpl;

import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.uidai.aadhar.Entity.DashBoardEntity;
import com.uidai.aadhar.Entity.User;
import com.uidai.aadhar.Repository.DashboardRepository;
import com.uidai.aadhar.Repository.UserRepository;
import com.uidai.aadhar.Service.DashBoardService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DashBoardServiceImpl implements DashBoardService{
	
	@Autowired
	DashboardRepository repo;
	
	@Autowired
	UserRepository userRepository;

//	@Override
//	public ResponseEntity<?> dashData() {
//
//	    log.info("Inside DashData......");
//
//	    Map<String, Object> response = new LinkedHashMap<>();
//
//	    try {
//	        List<Object[]> stats = repo.getDashboardStats();
//	        log.info("DashBoard stats :: {}", stats);
//
//	        for (Object[] row : stats) {
//
//	            String entityType = ((String) row[0]).toLowerCase();
//
//	            Long active = ((Number) row[1]).longValue();
//	            Long inactive = ((Number) row[2]).longValue();
//	            Long total = ((Number) row[3]).longValue();
//
//	            // Inner JSON object for each entity
//	            Map<String, Long> entityStats = new LinkedHashMap<>();
//	            entityStats.put("active_count", active);
//	            entityStats.put("inactive_count", inactive);
//	            entityStats.put("total_count", total);
//
//	            // Add entity object to main response
//	            response.put(entityType, entityStats);
//	        }
//
//	        log.info("Dashboard stats structured successfully: {}", response);
//	        return ResponseEntity.ok(response);
//
//	    } catch (Exception e) {
//	        log.error("Error fetching dashboard stats :: ", e);
//	        response.put("error", "Failed to fetch dashboard statistics");
//	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
//	    }
//	}
	
	@Override
	public ResponseEntity<?> dashData(String agencyCode) {

	    log.info("Inside DashData......");

	    Map<String, Object> response = new LinkedHashMap<>();

	    try {
	        List<Object[]> stats = repo.getDashboardStats(agencyCode);
	        log.info("DashBoard stats :: {}", stats);

	        for (Object[] row : stats) {

	            String entityType = ((String) row[0]).toLowerCase();

	            Long active = ((Number) row[1]).longValue();
	            Long inactive = ((Number) row[2]).longValue();
	            Long total = ((Number) row[3]).longValue();

	            // Inner JSON object for each entity
	            Map<String, Long> entityStats = new LinkedHashMap<>();
	            entityStats.put("active_count", active);
	            entityStats.put("inactive_count", inactive);
	            entityStats.put("total_count", total);

	            // Add entity object to main response
	            response.put(entityType, entityStats);
	        }

	        log.info("Dashboard stats structured successfully: {}", response);
	        return ResponseEntity.ok(response);

	    } catch (Exception e) {
	        log.error("Error fetching dashboard stats :: ", e);
	        response.put("error", "Failed to fetch dashboard statistics");
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	    }
	}

	@Override
	public ResponseEntity<Map<String, Object>> loginInfo(String username) {

	    log.info("Inside login Info ......{}", username);

	    Map<String, Object> profile = new LinkedHashMap<>();

	    try {
	        User user = userRepository.findByAgencyCode(username)
	                .orElseThrow(() -> new RuntimeException("User not found"));

	        profile.put("name", user.getName());
	        profile.put("email", user.getEmail());
	        profile.put("agencyCode", user.getAgencyCode());
	        profile.put("role", user.getRole());
	        profile.put("status", user.getActive());
	        profile.put("location", "Vakrangee Kendra");
	        profile.put("user created", user.getUserCreatedDateTime()
	        		.format(DateTimeFormatter.ofPattern("dd MMM yyyy, hh:mm a")));

	        return ResponseEntity.ok(profile);

	    } catch (Exception e) {
	        log.error("Error fetching login info :: {}", e);
	        return ResponseEntity.status(HttpStatus.OK).build();
	    }
	}
	
	@Override
	public ResponseEntity<?> agencyList() {
		List<User> agencyList = userRepository.findByRole("AGENCY");
		return ResponseEntity.ok(agencyList);
	}

}
