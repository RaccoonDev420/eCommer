package com.larila.ecommer.repositories;

import com.larila.ecommer.model.entities.Ad;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdRepository extends PagingAndSortingRepository<Ad, Integer> {
}
