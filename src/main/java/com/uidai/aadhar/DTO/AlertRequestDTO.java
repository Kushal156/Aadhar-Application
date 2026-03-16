package com.uidai.aadhar.DTO;

public class AlertRequestDTO {

	private String user_id;
	private String mac_id;
	private String latitude;
	private String longitude;
	private String district;
	private String gps_status;
	private Integer gpsFlag;
	
	public AlertRequestDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AlertRequestDTO(String user_id, String mac_id, String latitude, String longitude, String district,
			String gps_status, Integer gpsFlag) {
		super();
		this.user_id = user_id;
		this.mac_id = mac_id;
		this.latitude = latitude;
		this.longitude = longitude;
		this.district = district;
		this.gps_status = gps_status;
		this.gpsFlag = gpsFlag;
	}
	
	@Override
	public String toString() {
		return "AlertRequestDTO [user_id=" + user_id + ", mac_id=" + mac_id + ", latitude=" + latitude + ", longitude="
				+ longitude + ", district=" + district + ", gps_status=" + gps_status + ", gpsFlag=" + gpsFlag + "]";
	}
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getMac_id() {
		return mac_id;
	}
	public void setMac_id(String mac_id) {
		this.mac_id = mac_id;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getGps_status() {
		return gps_status;
	}
	public void setGps_status(String gps_status) {
		this.gps_status = gps_status;
	}
	public Integer getGpsFlag() {
		return gpsFlag;
	}
	public void setGpsFlag(Integer gpsFlag) {
		this.gpsFlag = gpsFlag;
	}
	
}
