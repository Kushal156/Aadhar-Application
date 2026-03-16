package com.uidai.aadhar.Entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "gps_status")
public class GPSStatusEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private String userId;
    
    @Column(name = "operator_name")
    private String operatorName;
    
    @Column(name = "agency_code")
    private String agencyCode;
	
	@Column(name = "mac_id")
    private String macId;

    @Column(name = "gps_status")
    private String gpsStatus;
    
    @Column(name = "agency_name")
    private String agencyName;
    
    @Column(name = "district")
    private String district;
    
    @Column(name = "date_time")
    private LocalDateTime dateTime;
    
    @Column(name = "center_id")
    private Integer centerId;
    
    @Column(name = "flag")
    private Integer gpsFlag;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public String getAgencyCode() {
		return agencyCode;
	}

	public void setAgencyCode(String agencyCode) {
		this.agencyCode = agencyCode;
	}

	public String getMacId() {
		return macId;
	}

	public void setMacId(String macId) {
		this.macId = macId;
	}

	public String getGpsStatus() {
		return gpsStatus;
	}

	public void setGpsStatus(String gpsStatus) {
		this.gpsStatus = gpsStatus;
	}

	public String getAgencyName() {
		return agencyName;
	}

	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public Integer getCenterId() {
		return centerId;
	}

	public void setCenterId(Integer centerId) {
		this.centerId = centerId;
	}

	public Integer getGpsFlag() {
		return gpsFlag;
	}

	public void setGpsFlag(Integer gpsFlag) {
		this.gpsFlag = gpsFlag;
	}

	@Override
	public String toString() {
		return "GPSStatusEntity [id=" + id + ", userId=" + userId + ", operatorName=" + operatorName + ", agencyCode="
				+ agencyCode + ", macId=" + macId + ", gpsStatus=" + gpsStatus + ", agencyName=" + agencyName
				+ ", district=" + district + ", dateTime=" + dateTime + ", centerId=" + centerId + ", gpsFlag="
				+ gpsFlag + "]";
	}

	public GPSStatusEntity(Long id, String userId, String operatorName, String agencyCode, String macId,
			String gpsStatus, String agencyName, String district, LocalDateTime dateTime, Integer centerId,
			Integer gpsFlag) {
		super();
		this.id = id;
		this.userId = userId;
		this.operatorName = operatorName;
		this.agencyCode = agencyCode;
		this.macId = macId;
		this.gpsStatus = gpsStatus;
		this.agencyName = agencyName;
		this.district = district;
		this.dateTime = dateTime;
		this.centerId = centerId;
		this.gpsFlag = gpsFlag;
	}

	public GPSStatusEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}
