package com.larila.ecommer.repositories;

import com.larila.ecommer.model.entities.Contact;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends PagingAndSortingRepository<Contact, Integer> {
}
