package com.larila.ecommer.model.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "precio_anuncios")
public class AdPrice implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nombre")
    private String name;
    @Column(name = "precio")
    private BigDecimal price;
    @Column(name = "dias_activos")
    private int activeDays;
    @Column(name = "fecha_creacion")
    private LocalDateTime creationDate;
    @Column(name = "fecha_actalizacion")
    private LocalDateTime updateDate;

    @OneToMany(
            mappedBy = "adPrice",
            fetch = FetchType.LAZY
    )
    private Set<Ad> ads;

    public AdPrice() {
    }

    public AdPrice(Integer id, String name, BigDecimal price, int activeDays) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.activeDays = activeDays;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getActiveDays() {
        return activeDays;
    }

    public void setActiveDays(int activeDays) {
        this.activeDays = activeDays;
    }

    public Set<Ad> getAds() {
        return ads;
    }

    public void setAds(Set<Ad> ads) {
        this.ads = ads;
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
        return "AdPrice{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", activeDays=" + activeDays +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdPrice adPrice = (AdPrice) o;
        return activeDays == adPrice.activeDays && name.equals(adPrice.name) && price.equals(adPrice.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, activeDays);
    }
}
