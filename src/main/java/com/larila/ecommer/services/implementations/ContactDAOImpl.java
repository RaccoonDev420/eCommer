package com.larila.ecommer.services.implementations;

import com.larila.ecommer.model.entities.Contact;
import com.larila.ecommer.repositories.ContactRepository;
import com.larila.ecommer.services.contracts.ContactDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactDAOImpl extends GenericDAOImpl<Contact, ContactRepository> implements ContactDAO {
    @Autowired
    public ContactDAOImpl(ContactRepository repository) {
        super(repository);
    }
}
