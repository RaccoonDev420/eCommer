package com.larila.ecommer.model.entities;

import com.larila.ecommer.model.entities.enumerators.Status;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@PrimaryKeyJoinColumn(name = "id_producto")
@Table(name = "accesorios")
public class Accesorie extends Product{

    @ManyToOne(
            optional = false,
            cascade = {
                    CascadeType.MERGE,
                    CascadeType.REFRESH
            }
    )
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "id_marca", foreignKey = @ForeignKey(name = "FK_ID_MARCA"))
    private Brand brand;
    @ManyToOne(
            cascade = {
                    CascadeType.MERGE,
                    CascadeType.REFRESH
            }
    )
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "id_modelo", foreignKey = @ForeignKey(name = "FK_ID_MODELO"))
    private Model model;
    private String color;
    @ManyToOne(
            cascade = {
                    CascadeType.MERGE,
                    CascadeType.REFRESH
            }
    )
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "id_tamanio", foreignKey = @ForeignKey(name = "FK_ID_TAMANIO"))
    private Size size;

    public Accesorie() {
    }

    public Accesorie(Integer id, User user, String name, BigDecimal price, String description, Status status, Brand brand, Model model, String color, Size size) {
        super(id, user, name, price, description, status);
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.size = size;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return super.toString()+
                "\tAccesorie{" +
                "brand=" + brand +
                ", model=" + model +
                ", color='" + color + '\'' +
                ", size=" + size +
                '}';
    }
}
