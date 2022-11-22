package com.larila.ecommer.services.implementations;

import com.larila.ecommer.model.entities.Wheel;
import com.larila.ecommer.repositories.WheelRepository;
import com.larila.ecommer.services.contracts.WheelDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WheelDAOImpl extends GenericDAOImpl<Wheel, WheelRepository> implements WheelDAO {

    @Autowired
    public WheelDAOImpl(WheelRepository repository) {
        super(repository);
    }
}
