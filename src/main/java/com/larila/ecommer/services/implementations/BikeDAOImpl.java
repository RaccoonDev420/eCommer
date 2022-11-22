package com.larila.ecommer.services.implementations;

import com.larila.ecommer.model.entities.Brand;
import com.larila.ecommer.model.entities.Product;
import com.larila.ecommer.repositories.BikeRepository;
import com.larila.ecommer.services.contracts.BikeDAO;
import com.larila.ecommer.services.specifications.builders.BikeSpecificationBuilder;
import com.larila.ecommer.services.specifications.builders.BrandSpecificationBuilder;
import com.larila.ecommer.services.specifications.builders.FilterBuilder;
import com.larila.ecommer.services.specifications.builders.ProductSpecificationBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class BikeDAOImpl extends ProductDAOImpl implements BikeDAO {

    @Autowired
    public BikeDAOImpl(@Qualifier("bicicletasRepository") BikeRepository repository) {
        super(repository);
    }


}
