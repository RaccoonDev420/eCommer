package com.larila.ecommer.model.entities;

import com.larila.ecommer.model.entities.enumerators.PublishStatus;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "anuncios")
public class Ad implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Enumerated(EnumType.STRING)
    private PublishStatus publishStatus;
    @Column(name = "visitas")
    private int visits;
    private boolean visible;
    @Column(name = "fecha_creacion")
    private LocalDateTime creationDate;
    @Column(name = "fecha_actualizacion")
    private LocalDateTime updateDate;

    @ManyToOne(
            optional = false,
            cascade = {
                    CascadeType.MERGE,
                    CascadeType.REFRESH
            }
    )
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "id_usuario", foreignKey = @ForeignKey(name = "FK_ID_USUARIO"))
    private User user;

    @ManyToOne(
            optional = false,
            cascade = {
                    CascadeType.MERGE,
                    CascadeType.REFRESH
            }
    )
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "id_producto", foreignKey = @ForeignKey(name = "FK_ID_PRODUCTO"))
    private Product product;

    @OneToOne(
            optional = false,
            cascade = {
                    CascadeType.MERGE,
                    CascadeType.REFRESH
            }
    )
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "id_direccion", foreignKey = @ForeignKey(name = "FK_ID_DIRECCION"))
    private Address address;

    @ManyToOne(
            optional = false,
            cascade = {
                    CascadeType.MERGE,
                    CascadeType.REFRESH
            }
    )
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "id_contacto", foreignKey = @ForeignKey(name = "FK_ID_CONTACTO"))
    private Contact contact;

    @ManyToOne(
            optional = false,
            cascade = {
                    CascadeType.MERGE,
                    CascadeType.REFRESH
            }
    )
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "id_precio", foreignKey = @ForeignKey(name = "FK_ID_PRECIO"))
    private AdPrice adPrice;

    public Ad() {
    }

    public Ad(Integer id, PublishStatus publishStatus, int visits, boolean visible, LocalDateTime creationDate, LocalDateTime updateDate, User user, Product product, Address address, Contact contact, AdPrice adPrice) {
        this.id = id;
        this.publishStatus = publishStatus;
        this.visits = visits;
        this.visible = visible;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
        this.user = user;
        this.product = product;
        this.address = address;
        this.contact = contact;
        this.adPrice = adPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PublishStatus getPublishStatus() {
        return publishStatus;
    }

    public void setPublishStatus(PublishStatus publishStatus) {
        this.publishStatus = publishStatus;
    }

    public int getVisits() {
        return visits;
    }

    public void setVisits(int visits) {
        this.visits = visits;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public AdPrice getAdPrice() {
        return adPrice;
    }

    public void setAdPrice(AdPrice adPrice) {
        this.adPrice = adPrice;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ad ad = (Ad) o;
        return id.equals(ad.id) && user.equals(ad.user) && product.equals(ad.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, product);
    }

    @Override
    public String toString() {
        return "Ad{" +
                "id=" + id +
                ", publishStatus=" + publishStatus +
                ", visits=" + visits +
                ", visible=" + visible +
                ", creationDate=" + creationDate +
                ", updateDate=" + updateDate +
                ", user=" + user +
                ", product=" + product +
                ", address=" + address +
                ", contact=" + contact +
                ", adPrice=" + adPrice +
                '}';
    }
}
