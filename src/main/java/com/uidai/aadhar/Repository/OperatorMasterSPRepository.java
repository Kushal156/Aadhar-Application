package com.uidai.aadhar.Repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.uidai.aadhar.Entity.OperatorMasterSPEntity;

public interface OperatorMasterSPRepository extends JpaRepository<OperatorMasterSPEntity, String>{

	@Query(value = "EXEC UIDAI.insert_then_update_operator_master " +
	        "@uidai_id = :uidaiId, " +
	        "@operator_name = :operatorName, " +
	        "@family_mem_name = :familyMemName, " +
	        "@dob = :dob, " +
	        "@email_id = :emailId, " +
	        "@aadhar_no = :aadharNo, " +
	        "@pan_no = :panNo, " +
	        "@qualification = :qualification, " +
	        "@gender = :gender, " +
	        "@marital_status = :maritalStatus, " +
	        "@operator_type = :operatorType, " +
	        "@certificate_no = :certificateNo, " +
	        "@certification_issue_date = :certificationIssueDate, " +
	        "@certification_exp_date = :certificationExpDate, " +
	        "@certificate_reg_id = :certificateRegId, " +
	        "@district_name = :districtName, " +
	        "@aadhar_copy_file = :aadharCopyFile, " +
	        "@qualification_equivalent_file = :qualificationEquivalentFile, " +
	        "@nseit_cert_file = :nseitCertFile, " +
	        "@pan_copy_file = :panCopyFile, " +
	        "@concern_letter_file = :concernLetterFile, " +
	        "@police_verification_file = :policeVerificationFile, " +
	        "@operator_affidavit_file = :operatorAffidavitFile, " +
	        "@is_active = 1, " +
	        "@state_name = :stateName, " +
	        "@machine_id = :machineId, " +
	        "@password = :password, " +
	        "@lat_long_distance = :latLongDistance, " +
	        "@reg_lat = :regLat, " +
	        "@reg_long = :regLong, " +
	        "@agency_code = :agencyCode, " +
	        "@center_id = :centerId, " +
	        "@center_address = :centerName",
	        nativeQuery = true)
	OperatorMasterSPEntity insertOperatorDetails(
	        @Param("uidaiId") String uidaiId,
	        @Param("operatorName") String operatorName,
	        @Param("familyMemName") String familyMemName,
	        @Param("dob") LocalDate dob,
	        @Param("emailId") String emailId,
	        @Param("aadharNo") Long aadharNo,
	        @Param("panNo") String panNo,
	        @Param("qualification") String qualification,
	        @Param("gender") String gender,
	        @Param("maritalStatus") String maritalStatus,
	        @Param("operatorType") String operatorType,
	        @Param("certificateNo") String certificateNo,
	        @Param("certificationIssueDate") LocalDate certificationIssueDate,
	        @Param("certificationExpDate") LocalDate certificationExpDate,
	        @Param("certificateRegId") String certificateRegId,
	        @Param("districtName") String districtName,
	        @Param("aadharCopyFile") String aadharCopyFile,
	        @Param("qualificationEquivalentFile") String qualificationEquivalentFile,
	        @Param("nseitCertFile") String nseitCertFile,
	        @Param("panCopyFile") String panCopyFile,
	        @Param("concernLetterFile") String concernLetterFile,
	        @Param("policeVerificationFile") String policeVerificationFile,
	        @Param("operatorAffidavitFile") String operatorAffidavitFile,
	        @Param("stateName") String stateName,
	        @Param("machineId") String machineId,
	        @Param("password") String password,
	        @Param("latLongDistance") Integer latLongDistance,
	        @Param("regLat") String regLat,
	        @Param("regLong") String regLong,
	        @Param("agencyCode") String agencyCode,
	        @Param("centerId") String centerId, 
	        @Param("centerName") String centerName
	);

}