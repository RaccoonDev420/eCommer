package com.larila.ecommer.services.implementations;

import com.larila.ecommer.model.entities.Bike;
import com.larila.ecommer.model.entities.Product;
import com.larila.ecommer.repositories.ProductRepository;
import com.larila.ecommer.services.contracts.AccesorieDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class AccesorieDAOImpl extends ProductDAOImpl implements AccesorieDAO {
    @Autowired
    public AccesorieDAOImpl(@Qualifier("accesoriosRepository")ProductRepository repository) {
        super(repository);
    }


}
