package com.uidai.aadhar.ServiceImpl;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.uidai.aadhar.Entity.UidaiOperatorMasterEntity;
import javax.persistence.criteria.Predicate;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Service
public class OpertorSpecification {

	public static Specification<UidaiOperatorMasterEntity> search(String keyword) {
		return (root, query, cb) -> {

			if (keyword == null || keyword.trim().isEmpty()) {
				return null;
			}

			String like = "%" + keyword.toLowerCase() + "%";

			List<Predicate> predicates = new ArrayList<>();

			// String fields
			predicates.add(cb.like(cb.lower(root.get("operatorName")), like));
			predicates.add(cb.like(cb.lower(root.get("operatorId")), like));
			predicates.add(cb.like(cb.lower(root.get("panNo")), like));

			// Numeric field (Aadhar)
			try {
				Long aadhar = Long.valueOf(keyword);
				predicates.add(cb.equal(root.get("aadharNo"), aadhar));
			} catch (NumberFormatException ignored) {
			}

			return cb.or(predicates.toArray(new Predicate[0]));
		};
	}

	public static Specification<UidaiOperatorMasterEntity> hasStatus(Integer status) {
		return (root, query, cb) -> {
			if (status == null) {
				return null;
			}
			return cb.equal(root.get("isActive"), status);
		};
	}

	public static Specification<UidaiOperatorMasterEntity> hasAgencyCode(String agencyCode) {
		return (root, query, cb) -> {
			if (agencyCode == null || agencyCode.trim().isEmpty()) {
				return null;
			}
			return cb.equal(root.get("agencyCode"), agencyCode);
		};
	}

	public static Specification<UidaiOperatorMasterEntity> createdBetween(LocalDateTime fromDate,
			LocalDateTime toDate) {

		return (root, query, cb) -> {
			if (fromDate == null && toDate == null) {
				return null;
			}
			if (fromDate != null && toDate != null) {
				return cb.between(root.get("createdAt"), fromDate, toDate);
			}
			if (fromDate != null) {
				return cb.greaterThanOrEqualTo(root.get("createdAt"), fromDate);
			}
			return cb.lessThanOrEqualTo(root.get("createdAt"), toDate);
		};
	}
}
