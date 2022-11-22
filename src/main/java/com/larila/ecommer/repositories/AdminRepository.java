package com.larila.ecommer.repositories;

import com.larila.ecommer.model.entities.User;
import com.larila.ecommer.model.entities.enumerators.AdminType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("adminsRepository")
public interface AdminRepository extends UserRepository {

    @Query("select a from Admin a where a.adminType = ?1")
    Iterable<User> findAdminByType(AdminType adminType);
}
