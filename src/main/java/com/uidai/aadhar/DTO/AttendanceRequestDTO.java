package com.uidai.aadhar.DTO;

public class AttendanceRequestDTO {

	private String uidaiId;
	private String operatorId;
	private String attendance;
	private String deviceMacAddress;
	
	public AttendanceRequestDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AttendanceRequestDTO(String uidaiId, String operatorId, String attendance, String deviceMacAddress) {
		super();
		this.uidaiId = uidaiId;
		this.operatorId = operatorId;
		this.attendance = attendance;
		this.deviceMacAddress = deviceMacAddress;
	}
	@Override
	public String toString() {
		return "AttendanceRequestDTO [uidaiId=" + uidaiId + ", operatorId=" + operatorId + ", attendance=" + attendance
				+ ", deviceMacAddress=" + deviceMacAddress + "]";
	}
	public String getUidaiId() {
		return uidaiId;
	}
	public void setUidaiId(String uidaiId) {
		this.uidaiId = uidaiId;
	}
	public String getOperatorId() {
		return operatorId;
	}
	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}
	public String getAttendance() {
		return attendance;
	}
	public void setAttendance(String attendance) {
		this.attendance = attendance;
	}
	public String getDeviceMacAddress() {
		return deviceMacAddress;
	}
	public void setDeviceMacAddress(String deviceMacAddress) {
		this.deviceMacAddress = deviceMacAddress;
	}
	
	
}
