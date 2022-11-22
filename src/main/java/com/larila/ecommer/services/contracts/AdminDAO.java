package com.larila.ecommer.services.contracts;

import com.larila.ecommer.model.entities.User;
import com.larila.ecommer.model.entities.enumerators.AdminType;
import org.springframework.data.jpa.repository.Query;

public interface AdminDAO extends UserDAO{

    @Query("select a from Admin a where a.adminType = '?1'")
    Iterable<User> findAdminByType(AdminType adminType);
}
