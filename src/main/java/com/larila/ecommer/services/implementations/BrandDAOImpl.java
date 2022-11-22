package com.larila.ecommer.services.implementations;

import com.larila.ecommer.model.entities.Brand;
import com.larila.ecommer.model.entities.Product;
import com.larila.ecommer.repositories.BrandRepository;
import com.larila.ecommer.services.contracts.BrandDAO;
import com.larila.ecommer.services.specifications.builders.BrandSpecificationBuilder;
import com.larila.ecommer.services.specifications.builders.FilterBuilder;
import com.larila.ecommer.services.specifications.builders.ProductSpecificationBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class BrandDAOImpl extends GenericDAOImpl<Brand, BrandRepository> implements BrandDAO {

    @Autowired
    public BrandDAOImpl(BrandRepository repository) {
        super(repository);
    }

    //This method return a paged of all Brands given the specifications
    //For the search atribute you need to follow this structure: "atributeName:directionOfSort"
    //one example is "id:asc", for aditional orders just add a ",".
    //For the specification structure you need to follow the next rules: "atributeName operator value AndOr,"
    //Example "id:1&,", operators are ":<>", "&" for AND, "%" for or and aditional specifications are divided by ","
    @Override
    public Page<Brand> findAll(Integer pageNo, Integer pageSize, String search, String specification) {
        //create the filter builder
        FilterBuilder builder = new FilterBuilder();
        //Instanciated a brandSpecificationBuilder
        BrandSpecificationBuilder brandSpecificationBuilder = new BrandSpecificationBuilder();
        //Create the regex pattern
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
                    brandSpecificationBuilder.with(key,operation,value,isOr);
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
                    brandSpecificationBuilder.with(key,operation,value,isOr);
                    System.out.println(isOr);

                    //System.out.println(isOr+key+operation+value);
                }
            }



        }


        List<Sort.Order> orders = builder.build();
        Specification<Brand> specs = brandSpecificationBuilder.build();
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(orders));
        Page<Brand> pagedResult = repository.findAll(specs,paging);
        Page<Brand> result = pagedResult;
        if (!result.hasContent()){
            return null;
        }
        return pagedResult;
    }

    //This method return a Iterable of all Brands given the specifications
    //For the search atribute you need to follow this structure: "atributeName:directionOfSort"
    //one example is "id:asc", for aditional orders just add a ",".
    //For the specification structure you need to follow the next rules: "atributeName operator value AndOr,"
    //Example "id:1&,", operators are ":<>", "&" for AND, "%" for or and aditional specifications are divided by ","
    @Override
    public Iterable<Brand> findAll(String filters, String specification) {
        FilterBuilder builder = new FilterBuilder();
        BrandSpecificationBuilder brandSpecificationBuilder = new BrandSpecificationBuilder();
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
                    brandSpecificationBuilder.with(key,operation,value,isOr);
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
                    brandSpecificationBuilder.with(key,operation,value,isOr);
                    System.out.println(isOr);

                    //System.out.println(isOr+key+operation+value);
                }
            }



        }


        List<Sort.Order> orders = builder.build();
        Specification<Brand> specs = brandSpecificationBuilder.build();
        Iterable<Brand> result = repository.findAll(specs,Sort.by(orders));

        ArrayList<Brand> resultTest = (ArrayList<Brand>) result;
        if(resultTest.isEmpty()){
            return null;
        }
        return result;
    }
}
