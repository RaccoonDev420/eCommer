package com.larila.ecommer.repositories;

import com.larila.ecommer.model.entities.Size;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SizeRepository extends PagingAndSortingRepository<Size, Integer> {
}
