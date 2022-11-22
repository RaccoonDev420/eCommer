package com.larila.ecommer.repositories;

import com.larila.ecommer.model.entities.BikeSubType;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BikeSubTypeRepository extends PagingAndSortingRepository<BikeSubType, Integer> {
}
