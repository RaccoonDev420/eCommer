package com.larila.ecommer.services.specifications;

import com.larila.ecommer.model.entities.BikeSubType;
import com.larila.ecommer.model.entities.BikeType;
import com.larila.ecommer.model.entities.enumerators.Brandtype;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

public class BikeSubTypeSpecification implements Specification<BikeSubType> {
    private SearchCriteria criteria;

    public BikeSubTypeSpecification(SearchCriteria criteria) {
        this.criteria = criteria;
    }

    @Override
    public Predicate toPredicate(Root<BikeSubType> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        Join<BikeSubType, BikeType> bikeSubTypeBikeTypeJoin = null;
        if(criteria.getKey().contains("-")){

            var split = criteria.getKey().split("-");

            switch (split[0]){
                case "bikeType":
                    bikeSubTypeBikeTypeJoin = root.join(split[0]);
                    break;
            }


            criteria.setKey(split[1]);
        }

        if (criteria.getOperation().equalsIgnoreCase(">")) {

            return builder.greaterThanOrEqualTo(
                    root.<String> get(criteria.getKey()), criteria.getValue().toString());

        }
        else if (criteria.getOperation().equalsIgnoreCase("<")) {
            return builder.lessThanOrEqualTo(
                    root.<String> get(criteria.getKey()), criteria.getValue().toString());
        }
        else if (criteria.getOperation().equalsIgnoreCase(":")) {
            if (root.get(criteria.getKey()).getJavaType() == String.class) {
                return builder.like(
                        root.<String>get(criteria.getKey()), "%" + criteria.getValue() + "%");
            } else {
                return builder.equal(root.get(criteria.getKey()), criteria.getValue());
            }
        }
        return null;
    }

    public SearchCriteria getCriteria() {
        return criteria;
    }

    public void setCriteria(SearchCriteria criteria) {
        this.criteria = criteria;
    }
}
