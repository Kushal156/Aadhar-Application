package com.uidai.aadhar.DTO;

import java.time.LocalDate;

public class ApplyLeaveDTO {

	private String operatorId;
	private String agencyCode;
	private String remarks;
	private Float days;
	private LocalDate leaveFrom;
	private LocalDate leaveTo;
	private String leaveType;
	private String halfDayStatus;
	
	public String getOperatorId() {
		return operatorId;
	}
	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}
	public String getAgencyCode() {
		return agencyCode;
	}
	public void setAgencyCode(String agencyCode) {
		this.agencyCode = agencyCode;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Float getDays() {
		return days;
	}
	public void setDays(Float days) {
		this.days = days;
	}
	public LocalDate getLeaveFrom() {
		return leaveFrom;
	}
	public void setLeaveFrom(LocalDate leaveFrom) {
		this.leaveFrom = leaveFrom;
	}
	public LocalDate getLeaveTo() {
		return leaveTo;
	}
	public void setLeaveTo(LocalDate leaveTo) {
		this.leaveTo = leaveTo;
	}
	public String getLeaveType() {
		return leaveType;
	}
	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}
	public String getHalfDayStatus() {
		return halfDayStatus;
	}
	public void setHalfDayStatus(String halfDayStatus) {
		this.halfDayStatus = halfDayStatus;
	}
	@Override
	public String toString() {
		return "ApplyLeaveDTO [operatorId=" + operatorId + ", agencyCode=" + agencyCode + ", remarks=" + remarks
				+ ", days=" + days + ", leaveFrom=" + leaveFrom + ", leaveTo=" + leaveTo + ", leaveType=" + leaveType
				+ ", halfDayStatus=" + halfDayStatus + "]";
	}
	public ApplyLeaveDTO(String operatorId, String agencyCode, String remarks, Float days, LocalDate leaveFrom,
			LocalDate leaveTo, String leaveType, String halfDayStatus) {
		super();
		this.operatorId = operatorId;
		this.agencyCode = agencyCode;
		this.remarks = remarks;
		this.days = days;
		this.leaveFrom = leaveFrom;
		this.leaveTo = leaveTo;
		this.leaveType = leaveType;
		this.halfDayStatus = halfDayStatus;
	}
	public ApplyLeaveDTO() {
		super();
	}
}
