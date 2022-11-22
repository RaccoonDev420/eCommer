package com.larila.ecommer.services.implementations;

import com.larila.ecommer.model.entities.Product;
import com.larila.ecommer.repositories.ProductRepository;
import com.larila.ecommer.services.contracts.ProductDAO;
import com.larila.ecommer.services.specifications.builders.FilterBuilder;
import com.larila.ecommer.services.specifications.builders.ProductSpecificationBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ProductDAOImpl extends GenericDAOImpl<Product, ProductRepository> implements ProductDAO {
    public ProductDAOImpl(ProductRepository repository) {
        super(repository);
    }


    @Override
    public Page<Product> findAll(Integer pageNo, Integer pageSize, String search, String specification) {
        FilterBuilder builder = new FilterBuilder();
        ProductSpecificationBuilder productSpecificationBuilder = new ProductSpecificationBuilder();
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
                    productSpecificationBuilder.with(key,operation,value,isOr);
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
                    productSpecificationBuilder.with(key,operation,value,isOr);
                    System.out.println(isOr);

                    //System.out.println(isOr+key+operation+value);
                }
            }



        }


        List<Sort.Order> orders = builder.build();
        Specification<Product> specs = productSpecificationBuilder.build();
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(orders));
        Page<Product> pagedResult = repository.findAll(specs,paging);
        Page<Product> result = (Page<Product>) pagedResult;
        if (!result.hasContent()){
            return null;
        }
        return pagedResult;
    }

    @Override
    public Iterable<Product> findAll(String filters, String specification) {
        FilterBuilder builder = new FilterBuilder();
        ProductSpecificationBuilder productSpecificationBuilder = new ProductSpecificationBuilder();
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
                    productSpecificationBuilder.with(key,operation,value,isOr);
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
                    productSpecificationBuilder.with(key,operation,value,isOr);
                    System.out.println(isOr);

                    //System.out.println(isOr+key+operation+value);
                }
            }



        }


        List<Sort.Order> orders = builder.build();
        Specification<Product> specs = productSpecificationBuilder.build();
        Iterable<Product> result = repository.findAll(specs,Sort.by(orders));
        ArrayList<Product> resultTest = (ArrayList<Product>) result;
        if(resultTest.isEmpty()){
            return null;
        }
        return result;
    }
}
