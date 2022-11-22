package com.larila.ecommer.services.implementations;

import com.larila.ecommer.model.entities.User;
import com.larila.ecommer.repositories.UserRepository;
import com.larila.ecommer.services.contracts.UserDAO;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public class UserDAOImpl extends GenericDAOImpl<User, UserRepository> implements UserDAO {


    public UserDAOImpl(UserRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<User> findByName(String name){
        return repository.findByName(name);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> findByNameAndLastName(String name, String apellido) {
        return repository.findByNameAndLastName(name,apellido);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> findByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<User> findByLastName(String apellido) {
        return repository.findByLastName(apellido);
    }
}
