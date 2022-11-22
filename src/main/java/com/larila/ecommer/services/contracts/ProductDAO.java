package com.larila.ecommer.services.contracts;

import com.larila.ecommer.model.entities.Bike;
import com.larila.ecommer.model.entities.Brand;
import com.larila.ecommer.model.entities.Product;
import org.springframework.data.domain.Page;

public interface ProductDAO extends GenericDAO<Product> {

    Page<Product> findAll(Integer pageNo, Integer pageSize, String search, String specification);
    Iterable<Product> findAll(String filters, String specification);
}
