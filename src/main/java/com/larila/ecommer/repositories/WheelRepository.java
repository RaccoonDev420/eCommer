package com.larila.ecommer.repositories;

import com.larila.ecommer.model.entities.Wheel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WheelRepository extends PagingAndSortingRepository<Wheel, Integer> {

}
