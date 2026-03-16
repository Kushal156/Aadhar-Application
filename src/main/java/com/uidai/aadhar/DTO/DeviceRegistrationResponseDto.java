package com.uidai.aadhar.DTO;

public class DeviceRegistrationResponseDto {


	private String message;
	private boolean status;
	

	
	public DeviceRegistrationResponseDto() {
		super();
	}



	public DeviceRegistrationResponseDto(String message, boolean status) {
		super();
		this.message = message;
		this.status = status;
	}



	@Override
	public String toString() {
		return "DeviceRegistrationResponseDto [message=" + message + ", status=" + status + "]";
	}



	public String getMessage() {
		return message;
	}



	public void setMessage(String message) {
		this.message = message;
	}



	public boolean isStatus() {
		return status;
	}



	public void setStatus(boolean status) {
		this.status = status;
	}

	
	
	
}
