package com.larila.ecommer.services.implementations;

import com.larila.ecommer.model.entities.BikeType;
import com.larila.ecommer.model.entities.Brand;
import com.larila.ecommer.repositories.BikeTypeRepository;
import com.larila.ecommer.services.contracts.BikeTypeDAO;
import com.larila.ecommer.services.specifications.BikeTypeSpecification;
import com.larila.ecommer.services.specifications.builders.BikeTypeSpecificationBuilder;
import com.larila.ecommer.services.specifications.builders.BrandSpecificationBuilder;
import com.larila.ecommer.services.specifications.builders.FilterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class BikeTypeDAOImpl extends GenericDAOImpl<BikeType, BikeTypeRepository> implements BikeTypeDAO {
    @Autowired
    public BikeTypeDAOImpl(BikeTypeRepository repository) {
        super(repository);
    }

    @Override
    public Page<BikeType> findAll(Integer pageNo, Integer pageSize, String search, String specification) {
        FilterBuilder builder = new FilterBuilder();
        BikeTypeSpecificationBuilder bikeTypeSpecificationBuilder = new BikeTypeSpecificationBuilder();
        String regex = "(\\w+?)(:|<|>)(\\w+?),";
        String key = null;
        String operation = null;
        String value = null;
        String isOr = null;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(search + ",");

        while (matcher.find()) {

            builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
        }
        var split = specification.split(",");
        for(int i=0; i< split.length; i++){

            if(split[i].contains("-")){
                //System.out.println(split[i]);
                regex = "(\\w+?)(-)(\\w+?)(:|<|>)(\\w+?)(%|&)";
                pattern = Pattern.compile(regex);
                Matcher matcher1 = pattern.matcher(split[i]);
                while (matcher1.find()){
                    key = matcher1.group(1)+matcher1.group(2)+matcher1.group(3);
                    operation = matcher1.group(4);
                    value = matcher1.group(5);
                    isOr = matcher1.group(6);
                    bikeTypeSpecificationBuilder.with(key,operation,value,isOr);
                    //System.out.println(value+isOr);

                }
            }else {
                //System.out.println(split[i]);
                regex = "(\\w+?)(:|<|>)(\\w+?)(%|&)";
                pattern = Pattern.compile(regex);
                Matcher matcher1 = pattern.matcher(split[i]);
                while (matcher1.find()) {
                    key = matcher1.group(1);
                    operation = matcher1.group(2);
                    value = matcher1.group(3);
                    isOr = matcher1.group(4);
                    bikeTypeSpecificationBuilder.with(key,operation,value,isOr);
                    System.out.println(isOr);

                    //System.out.println(isOr+key+operation+value);
                }
            }



        }


        List<Sort.Order> orders = builder.build();
        Specification<BikeType> specs = bikeTypeSpecificationBuilder.build();
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(orders));
        Page<BikeType> pagedResult = repository.findAll(specs,paging);
        Page<BikeType> result =  pagedResult;
        if (!result.hasContent()){
            return null;
        }
        return pagedResult;
    }

    @Override
    public Iterable<BikeType> findAll(String filters, String specification) {
        FilterBuilder builder = new FilterBuilder();
        BikeTypeSpecificationBuilder bikeTypeSpecificationBuilder = new BikeTypeSpecificationBuilder();
        String regex = "(\\w+?)(:|<|>)(\\w+?),";
        String key = null;
        String operation = null;
        String value = null;
        String isOr = null;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(filters + ",");

        while (matcher.find()) {

            builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
        }
        var split = specification.split(",");
        for(int i=0; i< split.length; i++){

            if(split[i].contains("-")){
                //System.out.println(split[i]);
                regex = "(\\w+?)(-)(\\w+?)(:|<|>)(\\w+?)(%|&)";
                pattern = Pattern.compile(regex);
                Matcher matcher1 = pattern.matcher(split[i]);
                while (matcher1.find()){
                    key = matcher1.group(1)+matcher1.group(2)+matcher1.group(3);
                    operation = matcher1.group(4);
                    value = matcher1.group(5);
                    isOr = matcher1.group(6);
                    bikeTypeSpecificationBuilder.with(key,operation,value,isOr);

                }
            }else {
                //System.out.println(split[i]);
                regex = "(\\w+?)(:|<|>)(\\w+?)(%|&)";
                pattern = Pattern.compile(regex);
                Matcher matcher1 = pattern.matcher(split[i]);
                while (matcher1.find()) {
                    key = matcher1.group(1);
                    operation = matcher1.group(2);
                    value = matcher1.group(3);
                    isOr = matcher1.group(4);
                    bikeTypeSpecificationBuilder.with(key,operation,value,isOr);

                }
            }



        }


        List<Sort.Order> orders = builder.build();
        Specification<BikeType> specs = bikeTypeSpecificationBuilder.build();
        Iterable<BikeType> result = repository.findAll(specs,Sort.by(orders));
        ArrayList<BikeType> resultTest = (ArrayList<BikeType>) result;
        if(resultTest.isEmpty()){
            return null;
        }
        return result;
    }
}
