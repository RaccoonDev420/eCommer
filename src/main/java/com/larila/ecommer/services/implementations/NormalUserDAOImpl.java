package com.larila.ecommer.services.implementations;

import com.larila.ecommer.model.entities.User;
import com.larila.ecommer.repositories.UserRepository;
import com.larila.ecommer.services.contracts.NormalUserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class NormalUserDAOImpl extends UserDAOImpl implements NormalUserDAO {

    @Autowired
    public NormalUserDAOImpl(@Qualifier("clientesRepository")UserRepository repository) {
        super(repository);
    }



}
