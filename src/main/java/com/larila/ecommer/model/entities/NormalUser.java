package com.larila.ecommer.model.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
@PrimaryKeyJoinColumn(name = "id_usuario")
public class NormalUser extends User{

    public NormalUser() {

    }

    public NormalUser(Integer id, String name, String lastName, String username, String email, String password) {
        super(id, name, lastName, username, email, password);
    }

    @Override
    public String toString() {
        return super.toString()+
                "\tNormalUser{}";
    }
}
