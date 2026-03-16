package com.uidai.aadhar.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.uidai.aadhar.Entity.CenterMasterEntity;

@Repository
public interface CenterMasterRepository extends JpaRepository<CenterMasterEntity, Long>,
	JpaSpecificationExecutor<CenterMasterEntity>{
	
	List<CenterMasterEntity> findByDistrictName(String district);
	
//	@Query(value = "select * from uidai_center_master a "
//			+ " where not exists (select * from uidai_operator_master b where a.id=b.center_id) "
//			+ " and district_name= :district and is_active = 1 ", nativeQuery = true)
//	List<CenterMasterEntity> findByDistrictName1(@Param ("district") String district);
	
	@Query(value = "select * from uidai_center_master a "
			+ " where not exists (select * from uidai_operator_master b where cast(a.id as varchar(20))=b.center_id) "
			+ " and district_name= :district and is_active = 1 ", nativeQuery = true)
	List<CenterMasterEntity> findByDistrictName1(@Param ("district") String district);
	
	Optional<CenterMasterEntity> findById(Long centerId);
	
	List<CenterMasterEntity> findByIsActive(Integer status);
}
