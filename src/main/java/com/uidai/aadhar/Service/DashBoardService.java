package com.uidai.aadhar.Service;

import org.springframework.http.ResponseEntity;

public interface DashBoardService {
	
	public ResponseEntity<?> dashData(String agencyCode);
	public ResponseEntity<?> loginInfo(String username);
	public ResponseEntity<?> agencyList();

}
