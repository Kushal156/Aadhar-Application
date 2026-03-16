package com.uidai.aadhar.DTO;

public class AlertResponseDTO {

	private boolean status;
	private String response_message;
	public AlertResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AlertResponseDTO(boolean status, String response_message) {
		super();
		this.status = status;
		this.response_message = response_message;
	}
	@Override
	public String toString() {
		return "AlertResponseDTO [status=" + status + ", response_message=" + response_message + "]";
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getResponse_message() {
		return response_message;
	}
	public void setResponse_message(String response_message) {
		this.response_message = response_message;
	}
	
	
	
}
