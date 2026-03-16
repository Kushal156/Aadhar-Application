package com.uidai.aadhar.Service;

import java.io.FileNotFoundException;
import java.security.NoSuchAlgorithmException;

import org.springframework.http.ResponseEntity;

import com.uidai.aadhar.DTO.PayCollectReqDTO;
import com.uidai.aadhar.DTO.PayCollectionRespDTO;

public interface PayService {

	ResponseEntity<?> payCollect(PayCollectReqDTO request) throws NoSuchAlgorithmException,FileNotFoundException;
	ResponseEntity<?> callBack(String encResp);

}
