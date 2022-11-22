package com.larila.ecommer.services.implementations;

import com.larila.ecommer.model.entities.Size;
import com.larila.ecommer.repositories.SizeRepository;
import com.larila.ecommer.services.contracts.SizeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SizeDAOImpl extends GenericDAOImpl<Size, SizeRepository> implements SizeDAO {
    @Autowired
    public SizeDAOImpl(SizeRepository repository) {
        super(repository);
    }
}
