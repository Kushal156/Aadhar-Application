package com.uidai.aadhar.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.uidai.aadhar.Entity.LeaveHistoryEntity;

@Repository
public interface LeaveHistoryRepository extends JpaRepository<LeaveHistoryEntity, Long> {

	List<LeaveHistoryEntity> findByAgencyCodeOrderByCreatedAtDesc(String agencyCode);
	
	@Query("SELECT l FROM LeaveHistoryEntity l WHERE l.operatorId = :operatorId " +
		       "AND ((:fromDate BETWEEN l.leaveFrom AND l.leaveTo) " +
		       "OR (:toDate BETWEEN l.leaveFrom AND l.leaveTo) " +
		       "OR (l.leaveFrom BETWEEN :fromDate AND :toDate))")
	List<LeaveHistoryEntity> findOverlappingLeave(
		        @Param("operatorId") String operatorId,
		        @Param("fromDate") LocalDate fromDate,
		        @Param("toDate") LocalDate toDate);
}
