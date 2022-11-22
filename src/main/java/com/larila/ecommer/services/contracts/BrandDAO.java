package com.larila.ecommer.services.contracts;

import com.larila.ecommer.model.entities.Brand;
import org.springframework.data.domain.Page;

public interface BrandDAO extends GenericDAO<Brand>{

    Page<Brand> findAll(Integer pageNo, Integer pageSize, String search, String specification);
    Iterable<Brand> findAll(String filters, String specification);
}
