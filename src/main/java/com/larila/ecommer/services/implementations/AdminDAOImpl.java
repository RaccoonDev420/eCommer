package com.larila.ecommer.services.implementations;

import com.larila.ecommer.model.entities.User;
import com.larila.ecommer.model.entities.enumerators.AdminType;
import com.larila.ecommer.repositories.AdminRepository;
import com.larila.ecommer.repositories.UserRepository;
import com.larila.ecommer.services.contracts.AdminDAO;
import com.larila.ecommer.services.contracts.NormalUserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class AdminDAOImpl extends UserDAOImpl implements AdminDAO {

    @Autowired
    public AdminDAOImpl(@Qualifier("adminsRepository") UserRepository repository) {
        super(repository);
    }

    @Override
    public Iterable<User> findAdminByType(AdminType adminType) {
        return ((AdminRepository)repository).findAdminByType(adminType);
    }

}
