package com.larila.ecommer.services.specifications;

import com.larila.ecommer.model.entities.Brand;
import com.larila.ecommer.model.entities.enumerators.Brandtype;
import com.larila.ecommer.model.entities.enumerators.Status;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class BrandSpecification implements Specification<Brand>{

    private SearchCriteria criteria;

    public BrandSpecification(SearchCriteria searchCriteria) {
        this.criteria = searchCriteria;
    }

    @Override
    public Predicate toPredicate(Root<Brand> root, CriteriaQuery<?> query, CriteriaBuilder builder) {

        if(criteria.getKey().contains("-")){

            var split = criteria.getKey().split("-");

            switch (split[0]){
                case "brandtype":
                    criteria.setKey("brandtype");
                    System.out.println(criteria.getKey());
                    criteria.setValue(Brandtype.getBrandType((String) criteria.getValue()));

                    break;
            }

            //System.out.println(criteria.getValue());
            criteria.setKey(split[1]);
            //System.out.println(criteria.getKey());
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
