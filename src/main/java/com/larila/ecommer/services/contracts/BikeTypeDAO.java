package com.larila.ecommer.services.contracts;

import com.larila.ecommer.model.entities.BikeType;
import com.larila.ecommer.model.entities.Brand;
import org.springframework.data.domain.Page;

public interface BikeTypeDAO extends GenericDAO<BikeType> {

    Page<BikeType> findAll(Integer pageNo, Integer pageSize, String search, String specification);
    Iterable<BikeType> findAll(String filters, String specification);
}
