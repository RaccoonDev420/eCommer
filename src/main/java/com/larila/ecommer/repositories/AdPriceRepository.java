package com.larila.ecommer.repositories;

import com.larila.ecommer.model.entities.AdPrice;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdPriceRepository extends PagingAndSortingRepository<AdPrice, Integer> {
}
