package com.uidai.aadhar.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.uidai.aadhar.Entity.DashBoardEntity;

@Repository
public interface DashboardRepository extends JpaRepository<DashBoardEntity, String>{
	
//	@Query(value = "EXEC uidai_GetDashboardStats", nativeQuery = true)
//    List<Object[]> getDashboardStats();
    
    @Query(value = "EXEC uidai_GetDashboardStats1 :agencyCode", nativeQuery = true)
    List<Object[]> getDashboardStats(@Param("agencyCode") String agencyCode);

}
