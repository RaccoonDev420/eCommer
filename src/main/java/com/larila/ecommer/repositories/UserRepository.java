package com.larila.ecommer.repositories;

import com.larila.ecommer.model.entities.User;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

@NoRepositoryBean
public interface UserRepository extends PagingAndSortingRepository<User, Integer> {

    Iterable<User> findByName(String name);
    Optional<User> findByNameAndLastName(String name, String apellido);
    Optional<User> findByEmail(String email);
    Iterable<User> findByLastName(String apellido);
}
