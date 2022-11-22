package com.larila.ecommer.services.specifications;


import com.larila.ecommer.model.entities.Brand;
import com.larila.ecommer.model.entities.Product;
import com.larila.ecommer.model.entities.User;
import com.larila.ecommer.model.entities.enumerators.Status;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

public class ProductSpecification implements Specification<Product> {

    private SearchCriteria criteria;

    public ProductSpecification(SearchCriteria searchCriteria) {
        this.criteria = searchCriteria;
    }

    @Override
    public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder builder) {

        Join<Product, User> userJoin = null;
        if(criteria.getKey().contains("-")){

            var split = criteria.getKey().split("-");

            switch (split[0]){
                case "user":
                    userJoin = root.join(split[0]);
                    break;
                case "status":
                    criteria.setKey("status");
                    System.out.println(criteria.getKey());
                    criteria.setValue(Status.getSimpleOperation((String) criteria.getValue()));
                    break;
            }



            criteria.setKey(split[1]);
        }
        if (criteria.getOperation().equalsIgnoreCase(">")) {
            if (userJoin != null){
                return builder.greaterThanOrEqualTo(
                        userJoin.get(criteria.getKey()),  criteria.getValue().toString());
            }

            return builder.greaterThanOrEqualTo(
                    root.<String> get(criteria.getKey()), criteria.getValue().toString());

        }
        else if (criteria.getOperation().equalsIgnoreCase("<")) {
            if (userJoin != null){
                return builder.lessThanOrEqualTo(
                        userJoin.get(criteria.getKey()),  criteria.getValue().toString());
            }
            return builder.lessThanOrEqualTo(
                    root.<String> get(criteria.getKey()), criteria.getValue().toString());
        }
        else if (criteria.getOperation().equalsIgnoreCase(":")) {
            if (root.get(criteria.getKey()).getJavaType() == String.class) {

                if (userJoin != null){
                    return builder.like(
                            userJoin.get(criteria.getKey()), "%" + criteria.getValue() + "%");
                }
                return builder.like(
                        root.<String>get(criteria.getKey()), "%" + criteria.getValue() + "%");
            } else {
                if (userJoin != null){
                    return builder.equal(userJoin.get(criteria.getKey()),  criteria.getValue());
                }
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
