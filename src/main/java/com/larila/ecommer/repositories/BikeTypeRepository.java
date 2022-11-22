package com.larila.ecommer.repositories;

import com.larila.ecommer.model.entities.BikeType;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BikeTypeRepository extends PagingAndSortingRepository<BikeType, Integer>, JpaSpecificationExecutor<BikeType> {
}
