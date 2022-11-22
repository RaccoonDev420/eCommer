package com.larila.ecommer.services.implementations;

import com.larila.ecommer.model.entities.AdPrice;
import com.larila.ecommer.repositories.AdPriceRepository;
import com.larila.ecommer.services.contracts.AdPriceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdPriceDAOImpl extends GenericDAOImpl<AdPrice, AdPriceRepository> implements AdPriceDAO {
    @Autowired
    public AdPriceDAOImpl(AdPriceRepository repository) {
        super(repository);
    }
}
