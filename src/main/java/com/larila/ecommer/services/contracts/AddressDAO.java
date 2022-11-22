package com.larila.ecommer.services.contracts;

import com.larila.ecommer.model.entities.Address;
import com.larila.ecommer.model.entities.Brand;
import org.springframework.data.domain.Page;

public interface AddressDAO extends GenericDAO<Address> {
    Page<Address> findAll(Integer pageNo, Integer pageSize, String filter, String specification);
    Iterable<Address> findAll(String filters, String specification);
}
