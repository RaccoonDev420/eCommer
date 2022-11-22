package com.larila.ecommer.services.implementations;

import com.larila.ecommer.model.entities.Address;
import com.larila.ecommer.repositories.AddressRepository;
import com.larila.ecommer.services.contracts.AddressDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class AddressDAOImpl extends GenericDAOImpl<Address, AddressRepository> implements AddressDAO {
    @Autowired
    public AddressDAOImpl(AddressRepository repository) {
        super(repository);
    }

    @Override
    public Page<Address> findAll(Integer pageNo, Integer pageSize, String filter, String specification) {
        return null;
    }

    @Override
    public Iterable<Address> findAll(String filters, String specification) {
        return null;
    }
}
