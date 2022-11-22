package com.larila.ecommer.repositories;

import com.larila.ecommer.model.entities.Bike;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

@Repository("bicicletasRepository")
public interface BikeRepository extends ProductRepository{


}
