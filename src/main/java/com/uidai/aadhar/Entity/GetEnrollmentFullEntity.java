package com.uidai.aadhar.Entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Enrolment_Master", schema = "UIDAI", catalog = "VKMSDUMP")
public class GetEnrollmentFullEntity {

	@Id
	@Column(name = "ENROLMENT_ID", length = 50)
	private String enrolmentId;

	@Column(name = "machine_number")
	private Integer machineNumber;

	@Column(name = "packet_date")
	private LocalDate packetDate;

	@Column(name = "APPOINTMENT_ID", length = 50)
	private String appointmentId;

	@Column(name = "TYPE", length = 10)
	private String type;

	@Column(name = "MANDATORY_BIO_METRIC_UPDATE_ONLY", length = 10)
	private String mandatoryBioMetricUpdateOnly;

	@Column(name = "IS_NRI", length = 10)
	private String isNri;

	@Column(name = "TIN_NO", length = 50)
	private String tinNo;

	@Column(name = "OPERATOR_ID", length = 50)
	private String operatorId;

	@Column(name = "INTRODUCER", length = 50)
	private String introducer;

	@Column(name = "PROOF", length = 10)
	private String proof;

	@Column(name = "RESIDENT_NAME", length = 100)
	private String residentName;

	@Column(name = "STATUS", length = 50)
	private String status;

	@Column(name = "GST_AMOUNT", precision = 10, scale = 2)
	private BigDecimal gstAmount;

	@Column(name = "AMOUNT_CHARGED_FOR_NEW_ENROLMENT", precision = 10, scale = 2)
	private BigDecimal amountChargedForNewEnrolment;

	@Column(name = "AMOUNT_CHARGED_FOR_UPDATE_ENROLMENT", precision = 10, scale = 2)
	private BigDecimal amountChargedForUpdateEnrolment;

	@Column(name = "TOTAL_AMOUNT_CHARGED", precision = 10, scale = 2)
	private BigDecimal totalAmountCharged;

	@Column(name = "PROCESSING_STATE_DESCRIPTION", length = 255)
	private String processingStateDescription;

	@Column(name = "REJECT_REASON_DESCRIPTION", length = 255)
	private String rejectReasonDescription;

	@Column(name = "PACKET_SKIPPED")
	private Integer packetSkipped;

	@Column(name = "FOREIGN_RESIDENT")
	private Integer foreignResident;

	@Column(name = "upload_date_time")
	private LocalDateTime uploadDateTime;

	@Column(name = "file_path", length = 255)
	private String filePath;

	@Column(name = "Enrolment_type", length = 50)
	private String enrolmentType;

	public String getEnrolmentId() {
		return enrolmentId;
	}

	public void setEnrolmentId(String enrolmentId) {
		this.enrolmentId = enrolmentId;
	}

	public Integer getMachineNumber() {
		return machineNumber;
	}

	public void setMachineNumber(Integer machineNumber) {
		this.machineNumber = machineNumber;
	}

	public LocalDate getPacketDate() {
		return packetDate;
	}

	public void setPacketDate(LocalDate packetDate) {
		this.packetDate = packetDate;
	}

	public String getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(String appointmentId) {
		this.appointmentId = appointmentId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMandatoryBioMetricUpdateOnly() {
		return mandatoryBioMetricUpdateOnly;
	}

	public void setMandatoryBioMetricUpdateOnly(String mandatoryBioMetricUpdateOnly) {
		this.mandatoryBioMetricUpdateOnly = mandatoryBioMetricUpdateOnly;
	}

	public String getIsNri() {
		return isNri;
	}

	public void setIsNri(String isNri) {
		this.isNri = isNri;
	}

	public String getTinNo() {
		return tinNo;
	}

	public void setTinNo(String tinNo) {
		this.tinNo = tinNo;
	}

	public String getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}

	public String getIntroducer() {
		return introducer;
	}

	public void setIntroducer(String introducer) {
		this.introducer = introducer;
	}

	public String getProof() {
		return proof;
	}

	public void setProof(String proof) {
		this.proof = proof;
	}

	public String getResidentName() {
		return residentName;
	}

	public void setResidentName(String residentName) {
		this.residentName = residentName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getGstAmount() {
		return gstAmount;
	}

	public void setGstAmount(BigDecimal gstAmount) {
		this.gstAmount = gstAmount;
	}

	public BigDecimal getAmountChargedForNewEnrolment() {
		return amountChargedForNewEnrolment;
	}

	public void setAmountChargedForNewEnrolment(BigDecimal amountChargedForNewEnrolment) {
		this.amountChargedForNewEnrolment = amountChargedForNewEnrolment;
	}

	public BigDecimal getAmountChargedForUpdateEnrolment() {
		return amountChargedForUpdateEnrolment;
	}

	public void setAmountChargedForUpdateEnrolment(BigDecimal amountChargedForUpdateEnrolment) {
		this.amountChargedForUpdateEnrolment = amountChargedForUpdateEnrolment;
	}

	public BigDecimal getTotalAmountCharged() {
		return totalAmountCharged;
	}

	public void setTotalAmountCharged(BigDecimal totalAmountCharged) {
		this.totalAmountCharged = totalAmountCharged;
	}

	public String getProcessingStateDescription() {
		return processingStateDescription;
	}

	public void setProcessingStateDescription(String processingStateDescription) {
		this.processingStateDescription = processingStateDescription;
	}

	public String getRejectReasonDescription() {
		return rejectReasonDescription;
	}

	public void setRejectReasonDescription(String rejectReasonDescription) {
		this.rejectReasonDescription = rejectReasonDescription;
	}

	public Integer getPacketSkipped() {
		return packetSkipped;
	}

	public void setPacketSkipped(Integer packetSkipped) {
		this.packetSkipped = packetSkipped;
	}

	public Integer getForeignResident() {
		return foreignResident;
	}

	public void setForeignResident(Integer foreignResident) {
		this.foreignResident = foreignResident;
	}

	public LocalDateTime getUploadDateTime() {
		return uploadDateTime;
	}

	public void setUploadDateTime(LocalDateTime uploadDateTime) {
		this.uploadDateTime = uploadDateTime;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getEnrolmentType() {
		return enrolmentType;
	}

	public void setEnrolmentType(String enrolmentType) {
		this.enrolmentType = enrolmentType;
	}

	@Override
	public String toString() {
		return "GetEnrollmentFullEntity [enrolmentId=" + enrolmentId + ", machineNumber=" + machineNumber
				+ ", packetDate=" + packetDate + ", appointmentId=" + appointmentId + ", type=" + type
				+ ", mandatoryBioMetricUpdateOnly=" + mandatoryBioMetricUpdateOnly + ", isNri=" + isNri + ", tinNo="
				+ tinNo + ", operatorId=" + operatorId + ", introducer=" + introducer + ", proof=" + proof
				+ ", residentName=" + residentName + ", status=" + status + ", gstAmount=" + gstAmount
				+ ", amountChargedForNewEnrolment=" + amountChargedForNewEnrolment
				+ ", amountChargedForUpdateEnrolment=" + amountChargedForUpdateEnrolment + ", totalAmountCharged="
				+ totalAmountCharged + ", processingStateDescription=" + processingStateDescription
				+ ", rejectReasonDescription=" + rejectReasonDescription + ", packetSkipped=" + packetSkipped
				+ ", foreignResident=" + foreignResident + ", uploadDateTime=" + uploadDateTime + ", filePath="
				+ filePath + ", enrolmentType=" + enrolmentType + "]";
	}

}
