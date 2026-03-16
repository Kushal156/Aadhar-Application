package com.uidai.aadhar.Entity;

//import jakarta.persistence.Entity;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
//import jakarta.persistence.*;

@Entity
//@Data
@Table(name = "uidai_operator_master")
public class UidaiOperatorMasterEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Basic Identifier
    @Column(name = "operator_id", nullable = false, length = 50)
    private String operatorId;
	
	@Column(name = "uidai_id", length = 50)
    private String uidaiId;

    // Personal Details
    @Column(name = "operator_name", nullable = false, length = 150)
    private String operatorName;

    @Column(name = "family_mem_name", length = 150)
    private String familyMemName;

    @Column(name = "dob")
    private LocalDate dob;

    @Column(name = "email_id", length = 150)
    private String emailId;

    @Column(name = "aadhar_no")
    private Long aadharNo;

    @Column(name = "pan_no", length = 20)
    private String panNo;

    @Column(name = "qualification", length = 100)
    private String qualification;

    @Column(name = "gender", length = 20)
    private String gender;

    @Column(name = "marital_status", length = 30)
    private String maritalStatus;
    
    @Column(name = "reg_lat")
    private String regLat;
    
    @Column(name = "reg_long")
    private String regLong;

    // NSEIT Certificate Details
    @Column(name = "operator_type", length = 50)
    private String operatorType;

    @Column(name = "certificate_no", length = 100)
    private String certificateNo;

    @Column(name = "certification_issue_date")
    private LocalDate certificationIssueDate;

    @Column(name = "certification_exp_date")
    private LocalDate certificationExpDate;

    @Column(name = "certificate_reg_id", length = 100)
    private String certificateRegId;

    // Working Details
    @Column(name = "district_name", length = 150)
    private String districtName;

    // Documents (ONLY FILE NAMES)
    @Column(name = "aadhar_copy_file", length = 255)
    private String aadharCopyFile;

    @Column(name = "qualification_equivalent_file", length = 255)
    private String qualificationEquivalentFile;

    @Column(name = "nseit_cert_file", length = 255)
    private String nseitCertFile;

    @Column(name = "pan_copy_file", length = 255)
    private String panCopyFile;

    @Column(name = "concern_letter_file", length = 255)
    private String concernLetterFile;

    @Column(name = "police_verification_file", length = 255)
    private String policeVerificationFile;

    @Column(name = "operator_affidavit_file", length = 255)
    private String operatorAffidavitFile;

    // Audit Fields
    @Column(name = "is_active")
    private Integer isActive;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    @Column(name = "state_name")
    private String stateName;
    
    @Column(name = "machine_id")
    private String machineId;
    
    @Column(name = "password")
    private String password;
    
    @Column(name = "device_mapped")
    private String deviceMapped; 
    
    @Column(name = "lat_long_distance")
    private Integer latLongDistance;
    
    @Column(name = "center_address")
    private String centerName;

    @Column(name = "agency_code")
    private String agencyCode;
    
    
    // -------------------- Lifecycle Hooks --------------------

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

	public UidaiOperatorMasterEntity() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getUidaiId() {
		return uidaiId;
	}

	public void setUidaiId(String uidaiId) {
		this.uidaiId = uidaiId;
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

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public String getAadharCopyFile() {
		return aadharCopyFile;
	}

	public void setAadharCopyFile(String aadharCopyFile) {
		this.aadharCopyFile = aadharCopyFile;
	}

	public String getQualificationEquivalentFile() {
		return qualificationEquivalentFile;
	}

	public void setQualificationEquivalentFile(String qualificationEquivalentFile) {
		this.qualificationEquivalentFile = qualificationEquivalentFile;
	}

	public String getNseitCertFile() {
		return nseitCertFile;
	}

	public void setNseitCertFile(String nseitCertFile) {
		this.nseitCertFile = nseitCertFile;
	}

	public String getPanCopyFile() {
		return panCopyFile;
	}

	public void setPanCopyFile(String panCopyFile) {
		this.panCopyFile = panCopyFile;
	}

	public String getConcernLetterFile() {
		return concernLetterFile;
	}

	public void setConcernLetterFile(String concernLetterFile) {
		this.concernLetterFile = concernLetterFile;
	}

	public String getPoliceVerificationFile() {
		return policeVerificationFile;
	}

	public void setPoliceVerificationFile(String policeVerificationFile) {
		this.policeVerificationFile = policeVerificationFile;
	}

	public String getOperatorAffidavitFile() {
		return operatorAffidavitFile;
	}

	public void setOperatorAffidavitFile(String operatorAffidavitFile) {
		this.operatorAffidavitFile = operatorAffidavitFile;
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

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getMachineId() {
		return machineId;
	}

	public void setMachineId(String machineId) {
		this.machineId = machineId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDeviceMapped() {
		return deviceMapped;
	}

	public void setDeviceMapped(String deviceMapped) {
		this.deviceMapped = deviceMapped;
	}

	public Integer getLatLongDistance() {
		return latLongDistance;
	}

	public void setLatLongDistance(Integer latLongDistance) {
		this.latLongDistance = latLongDistance;
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

	public String getCenterName() {
		return centerName;
	}

	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}

	public String getAgencyCode() {
		return agencyCode;
	}

	public void setAgencyCode(String agencyCode) {
		this.agencyCode = agencyCode;
	}

	@Override
	public String toString() {
		return "UidaiOperatorMasterEntity [id=" + id + ", operatorId=" + operatorId + ", uidaiId=" + uidaiId
				+ ", operatorName=" + operatorName + ", familyMemName=" + familyMemName + ", dob=" + dob + ", emailId="
				+ emailId + ", aadharNo=" + aadharNo + ", panNo=" + panNo + ", qualification=" + qualification
				+ ", gender=" + gender + ", maritalStatus=" + maritalStatus + ", regLat=" + regLat + ", regLong="
				+ regLong + ", operatorType=" + operatorType + ", certificateNo=" + certificateNo
				+ ", certificationIssueDate=" + certificationIssueDate + ", certificationExpDate="
				+ certificationExpDate + ", certificateRegId=" + certificateRegId + ", districtName=" + districtName
				+ ", aadharCopyFile=" + aadharCopyFile + ", qualificationEquivalentFile=" + qualificationEquivalentFile
				+ ", nseitCertFile=" + nseitCertFile + ", panCopyFile=" + panCopyFile + ", concernLetterFile="
				+ concernLetterFile + ", policeVerificationFile=" + policeVerificationFile + ", operatorAffidavitFile="
				+ operatorAffidavitFile + ", isActive=" + isActive + ", createdAt=" + createdAt + ", updatedAt="
				+ updatedAt + ", stateName=" + stateName + ", machineId=" + machineId + ", password=" + password
				+ ", deviceMapped=" + deviceMapped + ", latLongDistance=" + latLongDistance + ", centerName="
				+ centerName + ", agencyCode=" + agencyCode + "]";
	}

	public UidaiOperatorMasterEntity(Long id, String operatorId, String uidaiId, String operatorName,
			String familyMemName, LocalDate dob, String emailId, Long aadharNo, String panNo, String qualification,
			String gender, String maritalStatus, String regLat, String regLong, String operatorType,
			String certificateNo, LocalDate certificationIssueDate, LocalDate certificationExpDate,
			String certificateRegId, String districtName, String aadharCopyFile, String qualificationEquivalentFile,
			String nseitCertFile, String panCopyFile, String concernLetterFile, String policeVerificationFile,
			String operatorAffidavitFile, Integer isActive, LocalDateTime createdAt, LocalDateTime updatedAt,
			String stateName, String machineId, String password, String deviceMapped, Integer latLongDistance,
			String centerName, String agencyCode) {
		super();
		this.id = id;
		this.operatorId = operatorId;
		this.uidaiId = uidaiId;
		this.operatorName = operatorName;
		this.familyMemName = familyMemName;
		this.dob = dob;
		this.emailId = emailId;
		this.aadharNo = aadharNo;
		this.panNo = panNo;
		this.qualification = qualification;
		this.gender = gender;
		this.maritalStatus = maritalStatus;
		this.regLat = regLat;
		this.regLong = regLong;
		this.operatorType = operatorType;
		this.certificateNo = certificateNo;
		this.certificationIssueDate = certificationIssueDate;
		this.certificationExpDate = certificationExpDate;
		this.certificateRegId = certificateRegId;
		this.districtName = districtName;
		this.aadharCopyFile = aadharCopyFile;
		this.qualificationEquivalentFile = qualificationEquivalentFile;
		this.nseitCertFile = nseitCertFile;
		this.panCopyFile = panCopyFile;
		this.concernLetterFile = concernLetterFile;
		this.policeVerificationFile = policeVerificationFile;
		this.operatorAffidavitFile = operatorAffidavitFile;
		this.isActive = isActive;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.stateName = stateName;
		this.machineId = machineId;
		this.password = password;
		this.deviceMapped = deviceMapped;
		this.latLongDistance = latLongDistance;
		this.centerName = centerName;
		this.agencyCode = agencyCode;
	}
	
}
