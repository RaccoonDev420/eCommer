package com.larila.ecommer.model.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "tamanios")
public class Size implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nombre_tamanio")
    private String nameSize;
    @Column(name = "dimensiones")
    private String dimensions;
    @Column(name = "tamanio_piloto")
    private String riderSize;
    @Column(name = "fecha_creacion")
    private LocalDateTime creationDate;
    @Column(name = "fecha_actalizacion")
    private LocalDateTime updateDate;

    @OneToMany(
            mappedBy = "size",
            fetch = FetchType.LAZY
    )
    private Set<Bike> bikes;

    @OneToMany(
            mappedBy = "size",
            fetch = FetchType.LAZY
    )
    private Set<Accesorie> accesories;



    public Size() {
    }

    public Size(Integer id, String nameSize, String dimensions, String riderSize) {
        this.id = id;
        this.nameSize = nameSize;
        this.dimensions = dimensions;
        this.riderSize = riderSize;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameSize() {
        return nameSize;
    }

    public void setNameSize(String nameSize) {
        this.nameSize = nameSize;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
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

    public String getRiderSize() {
        return riderSize;
    }

    public void setRiderSize(String riderSize) {
        this.riderSize = riderSize;
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
        return "Size{" +
                "id=" + id +
                ", nameSize='" + nameSize + '\'' +
                ", dimensions='" + dimensions + '\'' +
                ", riderSize='" + riderSize + '\'' +
                '}';
    }
}
