package com.larila.ecommer.model.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "rodados")
public class Wheel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "rodado")
    private String wheelSize;
    @Column(name = "fecha_creacion")
    private LocalDateTime creationDate;
    @Column(name = "fecha_actalizacion")
    private LocalDateTime updateDate;

    @OneToMany(
            mappedBy = "wheel",
            fetch = FetchType.LAZY
    )
    private Set<Bike> bikes;

    public Wheel() {
    }

    public Wheel(Integer id, String wheelSize) {
        this.id = id;
        this.wheelSize = wheelSize;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWheelSize() {
        return wheelSize;
    }

    public void setWheelSize(String wheelSize) {
        this.wheelSize = wheelSize;
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
        return "Wheel{" +
                "id=" + id +
                ", wheelSize='" + wheelSize + '\'' +
                '}';
    }
}
