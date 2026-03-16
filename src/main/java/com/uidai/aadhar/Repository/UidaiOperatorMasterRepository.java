package com.uidai.aadhar.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.uidai.aadhar.Entity.DeviceMasterEntity;
import com.uidai.aadhar.Entity.UidaiOperatorMasterEntity;

@Repository
public interface UidaiOperatorMasterRepository extends JpaRepository<UidaiOperatorMasterEntity, Long>,
	JpaSpecificationExecutor<UidaiOperatorMasterEntity>{
	
	Optional<UidaiOperatorMasterEntity> findByOperatorId(String operatorId);

	@Query(value = "select * from uidai_operator_master where uidai_id = :uidaiId and password = :password and device_mapped = :macID", nativeQuery = true)
	Optional<UidaiOperatorMasterEntity> usernamePass(
			@Param("uidaiId") String uidaiId, @Param("password") String password, @Param("macID") String macID);
	
	@Query(value = "select * from uidai_operator_master where uidai_id = :uidaiId and device_mapped = :macID", nativeQuery = true)
	Optional<UidaiOperatorMasterEntity> usernamePassSpecificInfo(
			@Param("uidaiId") String uidaiId, @Param("macID") String macID);
	
	Optional<UidaiOperatorMasterEntity> findByUidaiId(String uidaiId);
	
	List<UidaiOperatorMasterEntity> findByIsActive(Integer status);
}
