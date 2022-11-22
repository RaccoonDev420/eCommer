package com.larila.ecommer.services.implementations;

import com.larila.ecommer.model.entities.Model;
import com.larila.ecommer.repositories.ModelRepository;
import com.larila.ecommer.services.contracts.ModelDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModelDAOImpl extends GenericDAOImpl<Model, ModelRepository> implements ModelDAO {

    @Autowired
    public ModelDAOImpl(ModelRepository repository) {
        super(repository);
    }
}
