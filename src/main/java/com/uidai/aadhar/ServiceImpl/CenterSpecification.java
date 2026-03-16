package com.uidai.aadhar.ServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import com.uidai.aadhar.Entity.CenterMasterEntity;

@Service
public class CenterSpecification {

//	public static Specification<CenterMasterEntity> search(String keyword) {
//        return (root, query, cb) -> {
//            if (keyword == null || keyword.trim().isEmpty()) {
//                return null;
//            }
//
//            String like = "%" + keyword.toLowerCase() + "%";
//
//            return cb.or(
//                    cb.like(cb.lower(root.get("centerPin")), like),
//                    cb.like(cb.lower(cb.toString(root.get("centerName"))), like),
//                    cb.like(cb.lower(cb.toString(root.get("districtName"))), like)
//            );
//        };
//    }
	
	public static Specification<CenterMasterEntity> search(String keyword) {

	    return (root, query, cb) -> {

	        if (keyword == null || keyword.trim().isEmpty()) {
	            return null;
	        }

	        String like = "%" + keyword.toLowerCase() + "%";

	        List<Predicate> predicates = new ArrayList<>();

	        // String fields
	        predicates.add(cb.like(cb.lower(root.get("centerName")), like));
	        predicates.add(cb.like(cb.lower(root.get("districtName")), like));

	        // Numeric field
	        try {
	            Integer pin = Integer.valueOf(keyword);
	            predicates.add(cb.equal(root.get("centerPin"), pin));
	        } catch (NumberFormatException ignored) {}

	        return cb.or(predicates.toArray(new Predicate[0]));
	    };
	}

    public static Specification<CenterMasterEntity> hasStatus(Integer status) {
        return (root, query, cb) -> {
            if (status == null) {
                return null;
            }
            return cb.equal(root.get("isActive"), status);
        };
    }
    
    public static Specification<CenterMasterEntity> hasDistricts(List<String> districts) {

        return (root, query, cb) -> {

            if (districts == null) {
                return null;
            }

            List<String> filtered = districts.stream()
                    .filter(d -> d != null && !d.trim().isEmpty())
                    .collect(Collectors.toList());

            if (filtered.isEmpty()) {
                return null;
            }

            return root.get("districtName").in(filtered);
        };
    }   
}
