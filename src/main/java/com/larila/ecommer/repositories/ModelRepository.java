package com.larila.ecommer.repositories;

import com.larila.ecommer.model.entities.Model;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends PagingAndSortingRepository<Model, Integer> {

}
