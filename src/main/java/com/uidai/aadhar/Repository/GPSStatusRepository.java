package com.uidai.aadhar.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.uidai.aadhar.Entity.GPSStatusEntity;

@Repository
public interface GPSStatusRepository
		extends JpaRepository<GPSStatusEntity, Long>, JpaSpecificationExecutor<GPSStatusEntity> {
	
	@Query(value = "EXEC gps_status_data_crud :operatorId, :macId, :gpsStatus, :gpsFlag ", nativeQuery = true)
	Object insertGps(@Param("operatorId") String operatorId, @Param("macId") String macId,
			@Param("gpsStatus") String gpsStatus, @Param("gpsFlag") Integer gpsFlag);

	List<GPSStatusEntity> findByAgencyCode(String agencyCode);
}
