package com.larila.ecommer.services.implementations;

import com.larila.ecommer.model.entities.BikeSubType;
import com.larila.ecommer.repositories.BikeSubTypeRepository;
import com.larila.ecommer.services.contracts.BikeSubTypeDAO;
import com.larila.ecommer.services.contracts.BikeTypeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BikeSubTypeDAOImpl extends GenericDAOImpl<BikeSubType, BikeSubTypeRepository> implements BikeSubTypeDAO {

    @Autowired
    public BikeSubTypeDAOImpl(BikeSubTypeRepository repository) {
        super(repository);
    }
}
