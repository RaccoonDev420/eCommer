package com.larila.ecommer.services.specifications.builders;

import com.larila.ecommer.model.entities.Brand;
import com.larila.ecommer.services.specifications.BrandSpecification;
import com.larila.ecommer.services.specifications.ProductSpecification;
import com.larila.ecommer.services.specifications.SearchCriteria;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BrandSpecificationBuilder {

    private final List<SearchCriteria> params;


    public BrandSpecificationBuilder() {
        params = new ArrayList<>();
    }

    public BrandSpecificationBuilder with(String key, String operation, Object value,String isOr){
        params.add(new SearchCriteria(key,operation,value,isOr));
        return this;
    }

    public BrandSpecificationBuilder with(String key, String operation, Object value){
        params.add(new SearchCriteria(key,operation,value));
        return this;
    }

    public Specification<Brand> build(){
        if(params.size() == 0){
            return null;
        }

        List<Specification> specs = params.stream().map(BrandSpecification::new).collect(Collectors.toList());
        Specification result = specs.get(0);


        for(int i=1; i< params.size();i++){
            if(params.get(i).getAndOr().matches("%") ){
                result = Specification.where(result)
                        .or(specs.get(i));
            }else{
                result = Specification.where(result)
                        .and(specs.get(i));
                System.out.println(params.get(i).getAndOr());
            }

        }

        return result;


    }
}
