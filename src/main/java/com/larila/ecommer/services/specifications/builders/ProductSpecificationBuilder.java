package com.larila.ecommer.services.specifications.builders;


import com.larila.ecommer.model.entities.Product;
import com.larila.ecommer.services.specifications.ProductSpecification;
import com.larila.ecommer.services.specifications.SearchCriteria;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductSpecificationBuilder {
    private final List<SearchCriteria> params;


    public ProductSpecificationBuilder() {
        params = new ArrayList<>();
    }

    public ProductSpecificationBuilder with(String key, String operation, Object value,String isOr){
        params.add(new SearchCriteria(key,operation,value,isOr));
        return this;
    }

    public ProductSpecificationBuilder with(String key, String operation, Object value){
        params.add(new SearchCriteria(key,operation,value));
        return this;
    }



    public Specification<Product> build(){
        if(params.size() == 0){
            return null;
        }

        List<Specification> specs = params.stream().map(ProductSpecification::new).collect(Collectors.toList());
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
