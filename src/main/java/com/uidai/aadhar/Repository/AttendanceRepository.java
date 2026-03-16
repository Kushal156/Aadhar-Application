package com.uidai.aadhar.Repository;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.uidai.aadhar.Entity.AttendanceEntity;

@Repository
public interface AttendanceRepository extends JpaRepository<AttendanceEntity, Long> {

	@Transactional
	@Query(value = "EXEC sp_save_uidai_attendance :operatorId, :machineId", nativeQuery = true)
	String spSaveUidaiAttendance(@Param("operatorId") String operatorId, @Param("machineId") String machineId);
	
	List<AttendanceEntity> findByAgencyCode (String agencyCode);

}