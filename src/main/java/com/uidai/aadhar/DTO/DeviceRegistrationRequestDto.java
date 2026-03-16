package com.uidai.aadhar.DTO;

public class DeviceRegistrationRequestDto {

	private String deviceSerialNo;
	private String deviceMacAddress;
	private String deviceMake;
	private String deviceModel;
	private String deviceSIName;
	private String districtName;
	private String vkId;
	
	private String machineId;
	private String stationId;
	
	public DeviceRegistrationRequestDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DeviceRegistrationRequestDto(String deviceSerialNo, String deviceMacAddress, String deviceMake,
			String deviceModel, String deviceSIName, String districtName, String vkId, String machineId,
			String stationId) {
		super();
		this.deviceSerialNo = deviceSerialNo;
		this.deviceMacAddress = deviceMacAddress;
		this.deviceMake = deviceMake;
		this.deviceModel = deviceModel;
		this.deviceSIName = deviceSIName;
		this.districtName = districtName;
		this.vkId = vkId;
		this.machineId = machineId;
		this.stationId = stationId;
	}
	@Override
	public String toString() {
		return "DeviceRegistrationRequestDto [deviceSerialNo=" + deviceSerialNo + ", deviceMacAddress="
				+ deviceMacAddress + ", deviceMake=" + deviceMake + ", deviceModel=" + deviceModel + ", deviceSIName="
				+ deviceSIName + ", districtName=" + districtName + ", vkId=" + vkId + ", machineId=" + machineId
				+ ", stationId=" + stationId + "]";
	}
	public String getDeviceSerialNo() {
		return deviceSerialNo;
	}
	public void setDeviceSerialNo(String deviceSerialNo) {
		this.deviceSerialNo = deviceSerialNo;
	}
	public String getDeviceMacAddress() {
		return deviceMacAddress;
	}
	public void setDeviceMacAddress(String deviceMacAddress) {
		this.deviceMacAddress = deviceMacAddress;
	}
	public String getDeviceMake() {
		return deviceMake;
	}
	public void setDeviceMake(String deviceMake) {
		this.deviceMake = deviceMake;
	}
	public String getDeviceModel() {
		return deviceModel;
	}
	public void setDeviceModel(String deviceModel) {
		this.deviceModel = deviceModel;
	}
	public String getDeviceSIName() {
		return deviceSIName;
	}
	public void setDeviceSIName(String deviceSIName) {
		this.deviceSIName = deviceSIName;
	}
	public String getDistrictName() {
		return districtName;
	}
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}
	public String getVkId() {
		return vkId;
	}
	public void setVkId(String vkId) {
		this.vkId = vkId;
	}
	public String getMachineId() {
		return machineId;
	}
	public void setMachineId(String machineId) {
		this.machineId = machineId;
	}
	public String getStationId() {
		return stationId;
	}
	public void setStationId(String stationId) {
		this.stationId = stationId;
	}
	
	
}
