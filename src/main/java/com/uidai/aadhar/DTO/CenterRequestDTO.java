package com.uidai.aadhar.DTO;

public class CenterRequestDTO {
	
	private String centerName;
	private String centerAdd;
	private Integer centerPincode;
	private String districtName;
	private String geoTags;
	private Integer seatingCap;
	private String centerType;
	private String centerSubType;
	
	public CenterRequestDTO(String centerName, String centerAdd, Integer centerPincode, String districtName,
			String geoTags, Integer seatingCap, String centerType, String centerSubType) {
		super();
		this.centerName = centerName;
		this.centerAdd = centerAdd;
		this.centerPincode = centerPincode;
		this.districtName = districtName;
		this.geoTags = geoTags;
		this.seatingCap = seatingCap;
		this.centerType = centerType;
		this.centerSubType = centerSubType;
	}
	public CenterRequestDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CenterRequestDTO [centerName=" + centerName + ", centerAdd=" + centerAdd + ", centerPincode="
				+ centerPincode + ", districtName=" + districtName + ", geoTags=" + geoTags + ", seatingCap="
				+ seatingCap + ", centerType=" + centerType + ", centerSubType=" + centerSubType + "]";
	}
	public String getCenterName() {
		return centerName;
	}
	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}
	public String getCenterAdd() {
		return centerAdd;
	}
	public void setCenterAdd(String centerAdd) {
		this.centerAdd = centerAdd;
	}
	public Integer getCenterPincode() {
		return centerPincode;
	}
	public void setCenterPincode(Integer centerPincode) {
		this.centerPincode = centerPincode;
	}
	public String getDistrictName() {
		return districtName;
	}
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}
	public String getGeoTags() {
		return geoTags;
	}
	public void setGeoTags(String geoTags) {
		this.geoTags = geoTags;
	}
	public Integer getSeatingCap() {
		return seatingCap;
	}
	public void setSeatingCap(Integer seatingCap) {
		this.seatingCap = seatingCap;
	}
	public String getCenterType() {
		return centerType;
	}
	public void setCenterType(String centerType) {
		this.centerType = centerType;
	}
	public String getCenterSubType() {
		return centerSubType;
	}
	public void setCenterSubType(String centerSubType) {
		this.centerSubType = centerSubType;
	}
	
	
}
