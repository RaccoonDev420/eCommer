package com.larila.ecommer.model.entities;

import com.larila.ecommer.model.entities.enumerators.AdminType;

import javax.persistence.*;

@Entity
@Table(name = "administradores")
@PrimaryKeyJoinColumn(name = "id_usuario")
public class Admin extends User{

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_administrador")
    private AdminType adminType;

    public Admin() {
    }

    public Admin(Integer id, String name, String lastName, String username, String email, String password, AdminType adminType) {
        super(id, name, lastName, username, email, password);
        this.adminType = adminType;
    }

    public AdminType getAdminType() {
        return adminType;
    }

    public void setAdminType(AdminType adminType) {
        this.adminType = adminType;
    }

    @Override
    public String toString() {
        return  super.toString()+
                "\tAdmin{" +
                "adminType=" + adminType +
                '}';
    }
}
