package com.larila.ecommer.services.specifications.builders;

import com.larila.ecommer.model.entities.Bike;
import com.larila.ecommer.model.entities.Brand;
import com.larila.ecommer.services.specifications.BrandSpecification;
import com.larila.ecommer.services.specifications.SearchCriteria;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BikeSpecificationBuilder {
    private final List<SearchCriteria> params;


    public BikeSpecificationBuilder() {
        params = new ArrayList<>();
    }

    public BikeSpecificationBuilder with(String key, String operation, Object value){
        params.add(new SearchCriteria(key,operation,value));
        return this;
    }

    public Specification<Bike> build(){
        if(params.size() == 0){
            return null;
        }

        List<Specification> specs = params.stream().map(BrandSpecification::new).collect(Collectors.toList());
        Specification result = specs.get(0);

        for(int i=0; i< params.size();i++){
            result = Specification.where(result)
                    .and(specs.get(i));
        }
        return result;

    }
}
