package com.uidai.aadhar.DTO;

import java.time.LocalDateTime;

public class LoginRequest {

	private String username;
	private String password;
	private Double latitude;
	private Double longitude;
	private boolean opLogin;
	private LocalDateTime loginTime;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public boolean isOpLogin() {
		return opLogin;
	}
	public void setOpLogin(boolean opLogin) {
		this.opLogin = opLogin;
	}
	public LocalDateTime getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(LocalDateTime loginTime) {
		this.loginTime = loginTime;
	}
	@Override
	public String toString() {
		return "LoginRequest [username=" + username + ", password=" + password + ", latitude=" + latitude
				+ ", longitude=" + longitude + ", opLogin=" + opLogin + ", loginTime=" + loginTime + "]";
	}
	public LoginRequest(String username, String password, Double latitude, Double longitude, boolean opLogin,
			LocalDateTime loginTime) {
		super();
		this.username = username;
		this.password = password;
		this.latitude = latitude;
		this.longitude = longitude;
		this.opLogin = opLogin;
		this.loginTime = loginTime;
	}
	
	
}
