package com.uidai.aadhar.ServiceImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.data.jpa.domain.Specification;
import com.uidai.aadhar.Entity.DeviceMasterEntity;
import com.uidai.aadhar.Entity.UidaiOperatorMasterEntity;

public class DeviceSpecification {

	public static Specification<DeviceMasterEntity> search(String keyword) {
        return (root, query, cb) -> {
            if (keyword == null || keyword.trim().isEmpty()) {
                return null;
            }

            String like = "%" + keyword.toLowerCase() + "%";

            return cb.or(
                    cb.like(cb.lower(root.get("serialNo")), like),
                    cb.like(cb.lower(cb.toString(root.get("macAddress"))), like),
                    cb.like(cb.lower(cb.toString(root.get("machineId"))), like),
                    cb.like(cb.lower(root.get("stationId")), like),
                    cb.like(cb.lower(root.get("deviceMake")), like),
                    cb.like(cb.lower(root.get("deviceModel")), like)
            );
        };
    }

    public static Specification<DeviceMasterEntity> hasStatus(Integer status) {
        return (root, query, cb) -> {
            if (status == null) {
                return null;
            }
            return cb.equal(root.get("isActive"), status);
        };
    }
    
    public static Specification<DeviceMasterEntity> hasAgencyCode(String agencyCode) {
        return (root, query, cb) -> {
            if (agencyCode == null || agencyCode.trim().isEmpty()) {
                return null;
            }
            return cb.equal(root.get("vkid"), agencyCode);
        };
    }
    
    public static Specification<DeviceMasterEntity> createdBetween(LocalDate fromDate,
			LocalDate toDate) {

		return (root, query, cb) -> {
			if (fromDate == null && toDate == null) {
				return null;
			}
			if (fromDate != null && toDate != null) {
				return cb.between(root.get("registrationDate"), fromDate, toDate);
			}
			if (fromDate != null) {
				return cb.greaterThanOrEqualTo(root.get("registrationDate"), fromDate);
			}
			return cb.lessThanOrEqualTo(root.get("registrationDate"), toDate);
		};
	}
}