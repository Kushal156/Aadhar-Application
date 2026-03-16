package com.uidai.aadhar.DTO;

public class UidaiOperatorMasterEntityDto {

	private String uidaiId;
	private String machineId;
	private Integer latLongDistance;
	private String regLat;
	private String regLong;
	private String operatorName;
	private String deviceMapped;
	public UidaiOperatorMasterEntityDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UidaiOperatorMasterEntityDto(String uidaiId, String machineId, Integer latLongDistance, String regLat,
			String regLong, String operatorName, String deviceMapped) {
		super();
		this.uidaiId = uidaiId;
		this.machineId = machineId;
		this.latLongDistance = latLongDistance;
		this.regLat = regLat;
		this.regLong = regLong;
		this.operatorName = operatorName;
		this.deviceMapped = deviceMapped;
	}
	@Override
	public String toString() {
		return "UidaiOperatorMasterEntityDto [uidaiId=" + uidaiId + ", machineId=" + machineId + ", latLongDistance="
				+ latLongDistance + ", regLat=" + regLat + ", regLong=" + regLong + ", operatorName=" + operatorName
				+ ", deviceMapped=" + deviceMapped + "]";
	}
	public String getUidaiId() {
		return uidaiId;
	}
	public void setUidaiId(String uidaiId) {
		this.uidaiId = uidaiId;
	}
	public String getMachineId() {
		return machineId;
	}
	public void setMachineId(String machineId) {
		this.machineId = machineId;
	}
	public Integer getLatLongDistance() {
		return latLongDistance;
	}
	public void setLatLongDistance(Integer latLongDistance) {
		this.latLongDistance = latLongDistance;
	}
	public String getRegLat() {
		return regLat;
	}
	public void setRegLat(String regLat) {
		this.regLat = regLat;
	}
	public String getRegLong() {
		return regLong;
	}
	public void setRegLong(String regLong) {
		this.regLong = regLong;
	}
	public String getOperatorName() {
		return operatorName;
	}
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}
	public String getDeviceMapped() {
		return deviceMapped;
	}
	public void setDeviceMapped(String deviceMapped) {
		this.deviceMapped = deviceMapped;
	} 
	
	
	
}
