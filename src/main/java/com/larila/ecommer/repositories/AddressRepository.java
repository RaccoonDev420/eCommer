package com.larila.ecommer.repositories;

import com.larila.ecommer.model.entities.Address;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends PagingAndSortingRepository<Address, Integer>, JpaSpecificationExecutor<Address> {
}
