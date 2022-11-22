package com.larila.ecommer.model.entities;

import com.larila.ecommer.model.entities.enumerators.Brandtype;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "marcas")
public class Brand implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nombre")
    private String name;
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_marca")
    private Brandtype brandtype;
    @Column(name = "fecha_creacion")
    private LocalDateTime creationDate;
    @Column(name = "fecha_actalizacion")
    private LocalDateTime updateDate;

    @OneToMany(
            mappedBy = "brand",
            fetch = FetchType.LAZY
    )
    private Set<Bike> bikes;

    @OneToMany(
            mappedBy = "brand",
            fetch = FetchType.LAZY
    )
    private Set<Model> models;

    @OneToMany(
            mappedBy = "brand",
            fetch = FetchType.LAZY
    )
    private Set<Accesorie> accesories;

    public Brand() {
    }

    public Brand(Integer id, String name, Brandtype brandtype) {
        this.id = id;
        this.name = name;
        this.brandtype = brandtype;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Brandtype getBrandtype() {
        return brandtype;
    }

    public void setBrandtype(Brandtype brandtype) {
        this.brandtype = brandtype;
    }

    public Set<Bike> getBikes() {
        return bikes;
    }

    public void setBikes(Set<Bike> bikes) {
        this.bikes = bikes;
    }

    public Set<Model> getModels() {
        return models;
    }

    public void setModels(Set<Model> models) {
        this.models = models;
    }

    public Set<Accesorie> getAccesories() {
        return accesories;
    }

    public void setAccesories(Set<Accesorie> accesories) {
        this.accesories = accesories;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    @PrePersist
    public void beforeCreate(){
        this.creationDate = LocalDateTime.now();
    }

    @PreUpdate
    public void beforeUpdate(){
        this.updateDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brandtype=" + brandtype+
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Brand brand = (Brand) o;
        return id.equals(brand.id) && name.equals(brand.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
