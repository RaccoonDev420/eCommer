package com.larila.ecommer.services.implementations;

import com.larila.ecommer.model.entities.Ad;
import com.larila.ecommer.repositories.AdRepository;
import com.larila.ecommer.services.contracts.AdDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdDAOImpl extends GenericDAOImpl<Ad, AdRepository> implements AdDAO {
    @Autowired
    public AdDAOImpl(AdRepository repository) {
        super(repository);
    }
}
