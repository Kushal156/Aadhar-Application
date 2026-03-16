package com.uidai.aadhar.Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Table(name = "uidai_leave_history", schema = "uidai")
public class LeaveHistoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "operator_id", nullable = false, length = 20)
    private String operatorId;

    @Column(name = "agency_code", nullable = false, length = 20)
    private String agencyCode;

    @Column(name = "no_of_days", nullable = false)
    private Double noOfDays;

    @Column(name = "leave_from_date", nullable = false)
    private LocalDate leaveFrom;

    @Column(name = "leave_to_date", nullable = false)
    private LocalDate leaveTo;

    @Column(name = "half_day_status", nullable = false, length = 20)
    private String halfDayStatus;

    @Column(name = "leave_type", nullable = false, length = 30)
    private String leaveType;

    @Column(name = "reason", length = 500)
    private String reason;

    @Column(name = "status")
    private Integer status;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public LeaveHistoryEntity() {}

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        if (status == null) {
            status = 0;
        }
    }
    
	@Override
	public String toString() {
		return "LeaveHistoryEntity [id=" + id + ", operatorId=" + operatorId + ", agencyCode=" + agencyCode
				+ ", noOfDays=" + noOfDays + ", leaveFrom=" + leaveFrom + ", leaveTo=" + leaveTo + ", halfDayStatus="
				+ halfDayStatus + ", leaveType=" + leaveType + ", reason=" + reason + ", status=" + status
				+ ", createdAt=" + createdAt + "]";
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

	public String getAgencyCode() {
		return agencyCode;
	}

	public void setAgencyCode(String agencyCode) {
		this.agencyCode = agencyCode;
	}

	public Double getNoOfDays() {
		return noOfDays;
	}

	public void setNoOfDays(Double noOfDays) {
		this.noOfDays = noOfDays;
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

	public String getHalfDayStatus() {
		return halfDayStatus;
	}

	public void setHalfDayStatus(String halfDayStatus) {
		this.halfDayStatus = halfDayStatus;
	}

	public String getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
}