package com.uidai.aadhar.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "audit_trail")
public class AuditTrailEntity {

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private String userId;
	
	@Column(name = "mac_id")
    private String macId;

    @Column(name = "latitude")
    private String latitude;

    @Column(name = "longitude")
    private String longitude;

    @Column(name = "district")
    private String district;

	public AuditTrailEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AuditTrailEntity(Long id, String userId, String macId, String latitude, String longitude, String district) {
		super();
		this.id = id;
		this.userId = userId;
		this.macId = macId;
		this.latitude = latitude;
		this.longitude = longitude;
		this.district = district;
	}

	@Override
	public String toString() {
		return "AuditTrailEntity [id=" + id + ", userId=" + userId + ", macId=" + macId + ", latitude=" + latitude
				+ ", longitude=" + longitude + ", district=" + district + "]";
	}

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

	public String getMacId() {
		return macId;
	}

	public void setMacId(String macId) {
		this.macId = macId;
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
    
    

   
}
