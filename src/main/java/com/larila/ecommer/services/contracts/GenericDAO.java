package com.larila.ecommer.services.contracts;

import java.util.Optional;

public interface GenericDAO <E>{
    Optional<E> findById(Integer id);
    E save(E entity);
    Iterable<E> findAll();
    void deleteById(Integer id);
}
