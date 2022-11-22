package com.larila.ecommer.repositories;


import com.larila.ecommer.model.entities.Brand;
import com.larila.ecommer.services.specifications.BrandSpecification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends PagingAndSortingRepository <Brand, Integer>, JpaSpecificationExecutor<Brand> {

}
