package com.uidai.aadhar.DTO;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


public class NewOperatorRequestDto {
	
	private String vkid;
	
	//Personal Details
	private String operatorName;
	private String familyMemName;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate dob;
	private String emailId;
	private Long aadharNo;
	private String panNo;
	private String qualification;
	private String gender;
	private String maritalStatus;
	private String stateName;
	private String districtName;
	private String regLat;
	private String regLong;
	
	private String agencyCode;
	
	private String centerName;
	private String centerId;

	//new parameters
	private String uidaiId;
	
	//NSEIT Certificate Details
	private String operatorType;
	private String certificateNo;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate certificationIssueDate;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate certificationExpDate;
	private String certificateRegId;

	private String machineId;
	
	//Documents
	private MultipartFile aadharCopy;
	private MultipartFile qualificationEquivalent;
	private MultipartFile nseitCert;
	private MultipartFile panCopy;
	private MultipartFile concernLetter;
	private MultipartFile policeVerification;
	private MultipartFile operatorAffidavit;
	
	public String getCenterName() {
		return centerName;
	}
	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}
	public String getCenterId() {
		return centerId;
	}
	public void setCenterId(String centerId) {
		this.centerId = centerId;
	}
	public String getAgencyCode() {
		return agencyCode;
	}
	public void setAgencyCode(String agencyCode) {
		this.agencyCode = agencyCode;
	}
	public NewOperatorRequestDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getVkid() {
		return vkid;
	}
	public void setVkid(String vkid) {
		this.vkid = vkid;
	}
	public String getOperatorName() {
		return operatorName;
	}
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}
	public String getFamilyMemName() {
		return familyMemName;
	}
	public void setFamilyMemName(String familyMemName) {
		this.familyMemName = familyMemName;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public Long getAadharNo() {
		return aadharNo;
	}
	public void setAadharNo(Long aadharNo) {
		this.aadharNo = aadharNo;
	}
	public String getPanNo() {
		return panNo;
	}
	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public String getDistrictName() {
		return districtName;
	}
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}
	public String getOperatorType() {
		return operatorType;
	}
	public void setOperatorType(String operatorType) {
		this.operatorType = operatorType;
	}
	public String getCertificateNo() {
		return certificateNo;
	}
	public void setCertificateNo(String certificateNo) {
		this.certificateNo = certificateNo;
	}
	public LocalDate getCertificationIssueDate() {
		return certificationIssueDate;
	}
	public void setCertificationIssueDate(LocalDate certificationIssueDate) {
		this.certificationIssueDate = certificationIssueDate;
	}
	public LocalDate getCertificationExpDate() {
		return certificationExpDate;
	}
	public void setCertificationExpDate(LocalDate certificationExpDate) {
		this.certificationExpDate = certificationExpDate;
	}
	public String getCertificateRegId() {
		return certificateRegId;
	}
	public void setCertificateRegId(String certificateRegId) {
		this.certificateRegId = certificateRegId;
	}
	public String getMachineId() {
		return machineId;
	}
	public void setMachineId(String machineId) {
		this.machineId = machineId;
	}
	public MultipartFile getAadharCopy() {
		return aadharCopy;
	}
	public void setAadharCopy(MultipartFile aadharCopy) {
		this.aadharCopy = aadharCopy;
	}
	public MultipartFile getQualificationEquivalent() {
		return qualificationEquivalent;
	}
	public void setQualificationEquivalent(MultipartFile qualificationEquivalent) {
		this.qualificationEquivalent = qualificationEquivalent;
	}
	public MultipartFile getNseitCert() {
		return nseitCert;
	}
	public void setNseitCert(MultipartFile nseitCert) {
		this.nseitCert = nseitCert;
	}
	public MultipartFile getPanCopy() {
		return panCopy;
	}
	public void setPanCopy(MultipartFile panCopy) {
		this.panCopy = panCopy;
	}
	public MultipartFile getConcernLetter() {
		return concernLetter;
	}
	public void setConcernLetter(MultipartFile concernLetter) {
		this.concernLetter = concernLetter;
	}
	public MultipartFile getPoliceVerification() {
		return policeVerification;
	}
	public void setPoliceVerification(MultipartFile policeVerification) {
		this.policeVerification = policeVerification;
	}
	public MultipartFile getOperatorAffidavit() {
		return operatorAffidavit;
	}
	public void setOperatorAffidavit(MultipartFile operatorAffidavit) {
		this.operatorAffidavit = operatorAffidavit;
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
	@Override
	public String toString() {
		return "NewOperatorRequestDto [vkid=" + vkid + ", operatorName=" + operatorName + ", familyMemName="
				+ familyMemName + ", dob=" + dob + ", emailId=" + emailId + ", aadharNo=" + aadharNo + ", panNo="
				+ panNo + ", qualification=" + qualification + ", gender=" + gender + ", maritalStatus=" + maritalStatus
				+ ", stateName=" + stateName + ", districtName=" + districtName + ", regLat=" + regLat + ", regLong="
				+ regLong + ", operatorType=" + operatorType + ", certificateNo=" + certificateNo
				+ ", certificationIssueDate=" + certificationIssueDate + ", certificationExpDate="
				+ certificationExpDate + ", certificateRegId=" + certificateRegId + ", machineId=" + machineId
				+ ", aadharCopy=" + aadharCopy + ", qualificationEquivalent=" + qualificationEquivalent + ", nseitCert="
				+ nseitCert + ", panCopy=" + panCopy + ", concernLetter=" + concernLetter + ", policeVerification="
				+ policeVerification + ", operatorAffidavit=" + operatorAffidavit + "]";
	}
	public NewOperatorRequestDto(String vkid, String operatorName, String familyMemName, LocalDate dob, String emailId,
			Long aadharNo, String panNo, String qualification, String gender, String maritalStatus, String stateName,
			String districtName, String regLat, String regLong, String operatorType, String certificateNo,
			LocalDate certificationIssueDate, LocalDate certificationExpDate, String certificateRegId, String machineId,
			MultipartFile aadharCopy, MultipartFile qualificationEquivalent, MultipartFile nseitCert,
			MultipartFile panCopy, MultipartFile concernLetter, MultipartFile policeVerification,
			MultipartFile operatorAffidavit) {
		super();
		this.vkid = vkid;
		this.operatorName = operatorName;
		this.familyMemName = familyMemName;
		this.dob = dob;
		this.emailId = emailId;
		this.aadharNo = aadharNo;
		this.panNo = panNo;
		this.qualification = qualification;
		this.gender = gender;
		this.maritalStatus = maritalStatus;
		this.stateName = stateName;
		this.districtName = districtName;
		this.regLat = regLat;
		this.regLong = regLong;
		this.operatorType = operatorType;
		this.certificateNo = certificateNo;
		this.certificationIssueDate = certificationIssueDate;
		this.certificationExpDate = certificationExpDate;
		this.certificateRegId = certificateRegId;
		this.machineId = machineId;
		this.aadharCopy = aadharCopy;
		this.qualificationEquivalent = qualificationEquivalent;
		this.nseitCert = nseitCert;
		this.panCopy = panCopy;
		this.concernLetter = concernLetter;
		this.policeVerification = policeVerification;
		this.operatorAffidavit = operatorAffidavit;
	}
	public String getUidaiId() {
		return uidaiId;
	}
	public void setUidaiId(String uidaiId) {
		this.uidaiId = uidaiId;
	}
	
	
}
