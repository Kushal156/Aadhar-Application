package com.uidai.aadhar.Entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
import lombok.Data;

@Entity
//@Data
@Table(name = "uidai_center_master")
public class CenterMasterEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "center_name", nullable = false, length = 50)
    private String centerName;
	
	@Column(name = "center_add", nullable = false, length = 50)
    private String centerAdd;

    @Column(name = "center_pincode", nullable = false, length = 150)
    private Integer centerPin;

    @Column(name = "district_name", length = 150)
    private String districtName;

    @Column(name = "geo_position")
    private String geoTags;

    @Column(name = "seating_capacity", length = 150)
    private Integer seatCap;

    @Column(name = "center_type")
    private String centerType;

    @Column(name = "center_sub_type", length = 20)
    private String centerSubType;

    @Column(name = "is_active")
    private Integer isActive;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

	public CenterMasterEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CenterMasterEntity(Long id, String centerName, String centerAdd, Integer centerPin, String districtName,
			String geoTags, Integer seatCap, String centerType, String centerSubType, Integer isActive,
			LocalDateTime createdAt) {
		super();
		this.id = id;
		this.centerName = centerName;
		this.centerAdd = centerAdd;
		this.centerPin = centerPin;
		this.districtName = districtName;
		this.geoTags = geoTags;
		this.seatCap = seatCap;
		this.centerType = centerType;
		this.centerSubType = centerSubType;
		this.isActive = isActive;
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "CenterMasterEntity [id=" + id + ", centerName=" + centerName + ", centerAdd=" + centerAdd
				+ ", centerPin=" + centerPin + ", districtName=" + districtName + ", geoTags=" + geoTags + ", seatCap="
				+ seatCap + ", centerType=" + centerType + ", centerSubType=" + centerSubType + ", isActive=" + isActive
				+ ", createdAt=" + createdAt + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Integer getCenterPin() {
		return centerPin;
	}

	public void setCenterPin(Integer centerPin) {
		this.centerPin = centerPin;
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

	public Integer getSeatCap() {
		return seatCap;
	}

	public void setSeatCap(Integer seatCap) {
		this.seatCap = seatCap;
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

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
    
    

}
