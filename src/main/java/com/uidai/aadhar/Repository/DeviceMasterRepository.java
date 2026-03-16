package com.uidai.aadhar.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.uidai.aadhar.Entity.DeviceMasterEntity;

@Repository
public interface DeviceMasterRepository extends CrudRepository<DeviceMasterEntity, Long>,
JpaSpecificationExecutor<DeviceMasterEntity> {

	Optional<DeviceMasterEntity> findBySerialNo(String deviceId);
	Optional<DeviceMasterEntity> findByMacAddress(String macID);
	List<DeviceMasterEntity> findByIsActive(Integer status);
	Optional<DeviceMasterEntity> findById(Integer id);
}
