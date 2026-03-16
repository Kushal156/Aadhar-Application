package com.uidai.aadhar.Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "uidai_attendance_master")
public class AttendanceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "operatorID", nullable = false)
    private String operatorId;

    @Column(name = "punchInTime")
    private LocalDateTime punchInTime;

    @Column(name = "punchOutTime")
    private LocalDateTime punchOutTime;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "status")
    private String status;

    @Column(name = "device_mac_adress")
    private String deviceMacAdress;
    
    @Column(name = "agency_code")
    private String agencyCode;

	public AttendanceEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AttendanceEntity(Long id, String operatorId, LocalDateTime punchInTime, LocalDateTime punchOutTime,
			LocalDate date, String status, String deviceMacAdress, String agencyCode) {
		super();
		this.id = id;
		this.operatorId = operatorId;
		this.punchInTime = punchInTime;
		this.punchOutTime = punchOutTime;
		this.date = date;
		this.status = status;
		this.deviceMacAdress = deviceMacAdress;
		this.agencyCode = agencyCode;
	}

	@Override
	public String toString() {
		return "AttendanceEntity [id=" + id + ", operatorId=" + operatorId + ", punchInTime=" + punchInTime
				+ ", punchOutTime=" + punchOutTime + ", date=" + date + ", status=" + status + ", deviceMacAdress="
				+ deviceMacAdress + ", agencyCode=" + agencyCode + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}

	public LocalDateTime getPunchInTime() {
		return punchInTime;
	}

	public void setPunchInTime(LocalDateTime punchInTime) {
		this.punchInTime = punchInTime;
	}

	public LocalDateTime getPunchOutTime() {
		return punchOutTime;
	}

	public void setPunchOutTime(LocalDateTime punchOutTime) {
		this.punchOutTime = punchOutTime;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDeviceMacAdress() {
		return deviceMacAdress;
	}

	public void setDeviceMacAdress(String deviceMacAdress) {
		this.deviceMacAdress = deviceMacAdress;
	}

	public String getAgencyCode() {
		return agencyCode;
	}

	public void setAgencyCode(String agencyCode) {
		this.agencyCode = agencyCode;
	}
    
}