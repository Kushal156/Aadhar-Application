package com.uidai.aadhar.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.uidai.aadhar.Entity.AuditTrailEntity;

@Repository
public interface AuditTrailRepopsitory extends JpaRepository<AuditTrailEntity, Long>,JpaSpecificationExecutor<AuditTrailEntity>
{

}
