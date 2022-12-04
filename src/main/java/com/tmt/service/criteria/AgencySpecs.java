package com.tmt.service.criteria;

import com.tmt.domain.entity.Agency;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AgencySpecs {


    public static Specification<Agency> search(AgencySearchRequest request) {

        return (Root<Agency> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> {
            List<Predicate> predicates = new ArrayList<>();
            Predicate predicate = null;

            if (Objects.nonNull(request.getCode()))
                predicates.add(builder.equal(root.get("code"), request.getCode()));
            if (Objects.nonNull(request.getName()))
                predicates.add(builder.equal(root.get("name"), request.getName()));
           if (Objects.nonNull(request.getFrom()))
                predicates.add(builder.greaterThanOrEqualTo(root.get("edited"), request.getFrom()));
            if (Objects.nonNull(request.getTo()))
                predicates.add(builder.lessThanOrEqualTo(root.get("edited"), request.getTo()));

            if (!predicates.isEmpty()) {
                predicate = predicates.size() == 1
                        ? predicates.get(0)
                        : builder.and(predicates.toArray(new Predicate[0]));
            }

            return predicate;
        };
    }


}


