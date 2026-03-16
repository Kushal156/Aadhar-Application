package com.uidai.aadhar.ServiceImpl;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.uidai.aadhar.DTO.ErrorResponseDTO;
import com.uidai.aadhar.DTO.PayCollectReqDTO;
import com.uidai.aadhar.DTO.PayCollectionRespDTO;
import com.uidai.aadhar.Security.SHA256HashWithSalt;
import com.uidai.aadhar.Service.PayService;

import lombok.extern.slf4j.Slf4j;
import java.util.Base64;
import com.uidai.aadhar.Security.AesCryptUtil;

@Service
@Slf4j
public class PayServiceImpl implements PayService {

	@Value("${paymentCollection}")
	private String payURL;
	
	@Value("${saltKey}")
	private String saltKey;
	
	@Value("${accessCode}")
	private String accessCode;
	
	@Value("${currency}")
	private String currency;

	@Autowired
	RestTemplate rest;
	
	@Autowired
	SHA256HashWithSalt encrypt;

	@Override
	public ResponseEntity<?> payCollect(PayCollectReqDTO request) throws NoSuchAlgorithmException, FileNotFoundException{

		log.info("Starting payment collection for OrderNo: {}", request.getOrderNo());

		try {
			String hash = encrypt.generateSHA256HashWithSalt(saltKey, accessCode);
			log.info("Hash Generated :: {}", hash);
			
			request.setAccessCode(accessCode);
			request.setRequestHash(hash);
			request.setOrderCurrency(currency);
			
			log.info("Final Request for payment-collection :: {}", request.toString());

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<PayCollectReqDTO> entity = new HttpEntity<>(request, headers);

			ResponseEntity<PayCollectionRespDTO> apiResponse = rest.exchange(payURL, HttpMethod.POST, entity, PayCollectionRespDTO.class);

			PayCollectionRespDTO response = apiResponse.getBody();
			
			log.info("Response from APi :: {}", response.toString());

			if (response == null) {
				log.error("CCAvenue returned empty response for OrderNo: {}", request.getOrderNo());
				return ResponseEntity.status(HttpStatus.OK).build();
			}

			// Success Case
			if (response.getCode() == 0) {
				log.info("Payment collection API success for OrderNo: {}", request.getOrderNo());
				
				String base64img = response.getOrderDynamicQrCode();
				byte[] imageBytes = Base64.getDecoder().decode(base64img);

		        FileOutputStream fos = new FileOutputStream("paymentQR.png");
		        fos.write(imageBytes);
		        fos.close();

		        log.info("QR Image Generated: paymentQR.png");
		        
		        return ResponseEntity.ok()
		                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=paymentQR.png")
		                .contentType(MediaType.IMAGE_PNG)
		                .body(imageBytes);
		        
//				return ResponseEntity.ok(response);
			}

			// Error Case
			if (response.getCode() == -1) {
				log.error("Payment collection API error for OrderNo: {} | Message: {}", request.getOrderNo(),
						response.getMessageDesc(), response.toString());

				return ResponseEntity.status(HttpStatus.OK).body(response);
			}

			log.warn("Unexpected response code from CCAvenue: {}", response.getCode());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);

		} catch (RestClientException | IOException ex) {

			log.error("Exception occurred while calling payment collection API for OrderNo: {}", request.getOrderNo(),ex);

//			PayCollectionRespDTO errorResponse = new PayCollectionRespDTO();
			ErrorResponseDTO errorResponse = new ErrorResponseDTO();
			errorResponse.setCode(-1);
			errorResponse.setMessage("API Call Failed");

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
		}
	}

	@Override
	public ResponseEntity<?> callBack(String encResp) {
		log.info("encResp length :: {}", encResp.length());
		log.info("Encyrpted Request :: {}", encResp);
		
		try {
			
			encResp = encResp.replaceAll("\\s+", "").trim();
			log.info("encResp length after clean :: {}", encResp.length());
			AesCryptUtil aesUtil = new AesCryptUtil(saltKey);
			String decResp = aesUtil.decrypt(encResp);
			
			log.info("Decryped Request :: {}", decResp);
			
		} catch(Exception e) {
			
		}
		return ResponseEntity.ok("OK");
	}

}
