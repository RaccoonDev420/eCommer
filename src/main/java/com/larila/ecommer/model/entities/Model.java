package com.larila.ecommer.model.entities;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "modelos")
public class Model implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(
            cascade = {
                    CascadeType.MERGE,
                    CascadeType.REFRESH
            }
    )
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "marca", foreignKey = @ForeignKey(name = "FK_ID_MARCA"))
    private Brand brand;
    private String modelName;

    @Column(name = "fecha_creacion")
    private LocalDateTime creationDate;
    @Column(name = "fecha_actalizacion")
    private LocalDateTime updateDate;

    @OneToMany(
            mappedBy = "model",
            fetch = FetchType.LAZY
    )
    private Set<Bike> bikes;

    @OneToMany(
            mappedBy = "model",
            fetch = FetchType.LAZY
    )
    private Set<Accesorie> accesories;

    public Model() {
    }

    public Model(Integer id, Brand brand, String modelName) {
        this.id = id;
        this.brand = brand;
        this.modelName = modelName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public Set<Bike> getBikes() {
        return bikes;
    }

    public void setBikes(Set<Bike> bikes) {
        this.bikes = bikes;
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
        return "Model{" +
                "id=" + id +
                ", brand=" + brand +
                ", modelName='" + modelName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Model model = (Model) o;
        return id.equals(model.id) && brand.equals(model.brand) && modelName.equals(model.modelName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brand, modelName);
    }
}
