package com.larila.ecommer.services.specifications.builders;

import com.larila.ecommer.services.specifications.FilterCriteria;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

public class FilterBuilder {
    private final List<FilterCriteria> params;

    public FilterBuilder() {
        params = new ArrayList<FilterCriteria>();
    }

    public FilterBuilder with(String field, String splitter, Object value) {
        params.add(new FilterCriteria(field,splitter,value));
        return this;
    }

    public List<Sort.Order> build(){
        if(params.size() == 0){
            return null;
        }
        List<Sort.Order> orders = new ArrayList<Sort.Order>();
        Sort.Order order1 = null;
        for (int i =1 ; i < params.size() ; i++ ){
            if(params.get(i).getValue().toString() == "desc"){
                order1 = new Sort.Order(Sort.Direction.DESC, params.get(i).getField());
            }else {
                order1 = new Sort.Order(Sort.Direction.ASC, params.get(i).getField());
            }
            orders.add(order1);
        }

        return orders;
    }
}
