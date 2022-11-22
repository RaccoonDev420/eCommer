package com.larila.ecommer.services.contracts;

import com.larila.ecommer.model.entities.User;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserDAO extends GenericDAO<User>{

    @Query("select u from User u where upper(u.name) like upper('%?1%')")
    Iterable<User> findByName(String name);
    @Query("select u from User u where u.name = ?1 and u.lastName = ?2")
    Optional<User> findByNameAndLastName(String name, String apellido);
    @Query("select u from User u where u.email = ?1")
    Optional<User> findByEmail(String email);
    @Query("select u from User u where upper(u.lastName) like upper('%?1%')")
    Iterable<User> findByLastName(String apellido);
}
