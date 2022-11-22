package com.larila.ecommer.model.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "tipo_bicicletas")
public class BikeType implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "tipo_bicicleta")
    private String bikeType;
    @Column(name = "fecha_creacion")
    private LocalDateTime creationDate;
    @Column(name = "fecha_actalizacion")
    private LocalDateTime updateDate;

    @OneToMany(
            mappedBy = "bikeType",
            fetch = FetchType.LAZY
    )
    private Set<BikeSubType> bikeSubTypes;

    @OneToMany(
           mappedBy = "bikeType",
            fetch = FetchType.LAZY
    )
    private Set<Bike> bikes;

    public BikeType() {
    }

    public BikeType(Integer id, String bikeType) {
        this.id = id;
        this.bikeType = bikeType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBikeType() {
        return bikeType;
    }

    public void setBikeType(String bikeType) {
        this.bikeType = bikeType;
    }

    public Set<BikeSubType> getBikeSubTypes() {
        return bikeSubTypes;
    }

    public void setBikeSubTypes(Set<BikeSubType> bikeSubTypes) {
        this.bikeSubTypes = bikeSubTypes;
    }

    public Set<Bike> getBikes() {
        return bikes;
    }

    public void setBikes(Set<Bike> bikes) {
        this.bikes = bikes;
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
        return "BikeType{" +
                "id=" + id +
                ", bikeType='" + bikeType + '\'' +
                '}';
    }
}
