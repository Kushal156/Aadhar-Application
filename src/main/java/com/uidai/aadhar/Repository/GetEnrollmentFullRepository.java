package com.uidai.aadhar.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.uidai.aadhar.Entity.GetEnrollmentFullEntity;

@Repository
public interface GetEnrollmentFullRepository extends JpaRepository<GetEnrollmentFullEntity, String> {
	
	@Query("SELECT DISTINCT e.machineNumber FROM GetEnrollmentFullEntity e")
    List<Integer> findDistinctMachineNumbers();
	
	@Query(value = "EXEC [VKMSDUMP].[UIDAI].[GETEnollment] :machineNo, :date", nativeQuery = true)
    List<GetEnrollmentFullEntity> getEnrollmentStats(@Param("machineNo") Integer machineNo, 
    		@Param("date") LocalDate date );

}
