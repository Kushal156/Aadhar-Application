package com.uidai.aadhar.Security;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uidai.aadhar.DTO.LoginRequest;
import com.uidai.aadhar.Entity.UidaiOperatorMasterEntity;
import com.uidai.aadhar.Entity.User;
import com.uidai.aadhar.Repository.UidaiOperatorMasterRepository;
import com.uidai.aadhar.Repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/auth")
//@CrossOrigin(
//	    origins = "http://localhost:5173",
//	    methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS, RequestMethod.PUT },
//	    allowedHeaders = "*",
//	    allowCredentials = "true",
//	    maxAge = 3600
//	)
@CrossOrigin("*")
@Slf4j
public class AuthController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private UidaiOperatorMasterRepository operatorRepo;

	@Autowired
	private JdbcTemplate jdbc;

	// change password
	@PostMapping("/change-password")
	public ResponseEntity<?> changePassword(@RequestBody Map<String, Object> request) {

		boolean status = true;
		String message = "Password updated successfully";
		Map<String, Object> response = new LinkedHashMap<>();

		String username = (String) request.get("username");
		String oldPassword = (String) request.get("oldPassword");
		String newPassword = (String) request.get("newPassword");

		log.info("username :: {}, oldPassword :: {}, newPassword :: {}", username, oldPassword, newPassword);

		User user = userRepository.findByAgencyCode(username).orElseThrow(() -> new RuntimeException("User not found"));

		// Validate old password
		if (!passwordEncoder.matches(oldPassword, user.getPassword())) {
			status = false;
			message = "Old password is incorrect";

			response.put("status", status);
			response.put("message", message);
			return ResponseEntity.ok(response);

		}

		// Encode & update new password
		user.setPassword(passwordEncoder.encode(newPassword));
		user.setPasswordUpdatedDateTime(LocalDateTime.now());
		userRepository.save(user);

		log.info("Response :: status : {}, message : {}", status, message);

		response.put("status", status);
		response.put("message", message);
		return ResponseEntity.ok(response);

	}

	// LOGIN
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Map<String, Object> request) {

		System.out.println("Request for login :: " + request.toString());
		Map<String, Object> response = new LinkedHashMap<>();

		String username = (String) request.get("username");
		String password = (String) request.get("password");

		User user = userRepository.findByAgencyCode(username).orElseThrow(() -> new RuntimeException("User not found"));

		if (!passwordEncoder.matches(password, user.getPassword())) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
		}

		boolean forcePasswordChange = user.getPasswordUpdatedDateTime() == null;

		System.out.println("forcePasswordChange :: {}" + forcePasswordChange);

		String token = jwtUtil.generateToken(user.getAgencyCode(), user.getRole());

		response.put("token", token);
		response.put("username", username);
		response.put("role", user.getRole());
		response.put("forcePasswordChange", forcePasswordChange);

		return ResponseEntity.ok(response);
	}

	// Mobile Login
		@PostMapping("/operator-login")
		public ResponseEntity<?> login(@RequestBody LoginRequest request) {
			
			log.info("Mobile Login :: {}", request.toString());

			Map<String, Object> response = new LinkedHashMap();

			response.put("data", new ArrayList<>());

			if (request.getUsername() == null || request.getPassword() == null) {
				response.put("status", false);
				response.put("message", "Username and password are required");
				return ResponseEntity.ok(response);
			}

			if (request.getLatitude() == null || request.getLongitude() == null) {
				response.put("status", false);
				response.put("message", "Latitude and Longitude required");
				return ResponseEntity.ok(response);
			}
			
			Optional<UidaiOperatorMasterEntity> optionalData = operatorRepo.findByOperatorId(request.getUsername());
			
			if(optionalData == null || !optionalData.isPresent()) {
				response.put("status", false);
		        response.put("message", "Invalid username");
		        return ResponseEntity.ok(response);			
			}
			
			 UidaiOperatorMasterEntity opData = optionalData.get();
			 
			//PASSWORD CHECK
			String dbPassword = opData.getPassword();

			if (!dbPassword.equals(request.getPassword())) {
			        response.put("status", false);
			        response.put("message", "Invalid password");
			        return ResponseEntity.ok(response);
			}

			//Stored Procedure
			String sql = "EXEC uidai_get_attendance_status_in_login ?";

			List<Map<String, Object>> spResult = jdbc.queryForList(sql, request.getUsername());
			log.info("SP Result of Operator Login :: {}", spResult.toString());

			if (spResult == null || spResult.isEmpty()) {
				response.put("status", false);
				response.put("message", "Invalid username or attendance not found");
				return ResponseEntity.ok(response);
			}

			Map<String, Object> row = spResult.get(0);

			String dbLatStr = (String) row.get("reg_lat"); 
			String dbLonStr = (String) row.get("reg_long");

			if (dbLatStr == null || dbLonStr == null) {
				response.put("status", false);
				response.put("message", "Registered location not found");
				return ResponseEntity.ok(response);
			}

			double dbLat = Double.parseDouble(dbLatStr);
			double dbLon = Double.parseDouble(dbLonStr);

			double distance = calculateDistance(dbLat, dbLon, request.getLatitude(), request.getLongitude());

			if (distance > 100) {
				response.put("status", false);
				response.put("message", "Login denied: You are outside allowed location (100m range)");
				return ResponseEntity.ok(response);
			}

			//Success Response
			response.put("status", true);
			response.put("message", "Login successful");
			response.put("data", spResult);

			return ResponseEntity.ok(response);
		}
	/*
	@PostMapping("/operator-login")
	public ResponseEntity<?> login(@RequestBody LoginRequest request) {
		
		log.info("Mobile Login :: {}", request.toString());

		Map<String, Object> response = new LinkedHashMap<>();

		response.put("data", new ArrayList<>());

		if (request.getUsername() == null || request.getPassword() == null) {
			response.put("status", false);
			response.put("message", "Username and password are required");
			return ResponseEntity.ok(response);
		}

		if (request.getLatitude() == null || request.getLongitude() == null) {
			response.put("status", false);
			response.put("message", "Latitude and Longitude required");
			return ResponseEntity.ok(response);
		}

		//Stored Procedure
		String sql = "EXEC uidai_get_attendance_status_in_login ?";

		List<Map<String, Object>> spResult = jdbc.queryForList(sql, request.getUsername());
		log.info("SP Result of Operator Login :: {}", spResult.toString());

		if (spResult == null || spResult.isEmpty()) {
			response.put("status", false);
			response.put("message", "Invalid username or attendance not found");
			return ResponseEntity.ok(response);
		}

		Map<String, Object> row = spResult.get(0);

		String dbLatStr = (String) row.get("reg_lat"); 
		String dbLonStr = (String) row.get("reg_long");

		if (dbLatStr == null || dbLonStr == null) {
			response.put("status", false);
			response.put("message", "Registered location not found");
			return ResponseEntity.ok(response);
		}

		double dbLat = Double.parseDouble(dbLatStr);
		double dbLon = Double.parseDouble(dbLonStr);

		double distance = calculateDistance(dbLat, dbLon, request.getLatitude(), request.getLongitude());

		if (distance > 100) {
			response.put("status", false);
			response.put("message", "Login denied: You are outside allowed location (100m range)");
			return ResponseEntity.ok(response);
		}

		//Success Response
		response.put("status", true);
		response.put("message", "Login successful");
		response.put("data", spResult);

		return ResponseEntity.ok(response);
	}
	
	*/

	// helper method for calculating distance
	private double calculateDistance(double lat1, double lon1, double lat2, double lon2) {

		final int EARTH_RADIUS = 6371000; // meters

		double latDistance = Math.toRadians(lat2 - lat1);
		double lonDistance = Math.toRadians(lon2 - lon1);

		double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) + Math.cos(Math.toRadians(lat1))
				* Math.cos(Math.toRadians(lat2)) * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);

		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

		return EARTH_RADIUS * c; // distance in meters
	}

}
