package com.larila.ecommer.model.entities;

import com.larila.ecommer.model.entities.enumerators.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "bicicletas")
@PrimaryKeyJoinColumn(name = "id_producto")
public class Bike extends Product{


    @Enumerated(EnumType.STRING)
    private Material material;
    @Enumerated(EnumType.STRING)
    @Column(name = "divisa")
    private Currency currency;
    @Enumerated(EnumType.STRING)
    @Column(name = "cuadro")
    private Frame frame;
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_frenos")
    private BrakeType brakeType;
    @Enumerated(EnumType.STRING)
    @Column(name = "transmision")
    private Transmission transmission;
    private String color;

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
            optional = false,
            cascade = {
                    CascadeType.MERGE,
                    CascadeType.REFRESH
            }
    )
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "id_modelo", foreignKey = @ForeignKey(name = "FK_ID_MODELO"))
    private Model model;
    @ManyToOne(
            optional = false,
            cascade = {
                    CascadeType.MERGE,
                    CascadeType.REFRESH
            }
    )
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "id_tipo_bicicleta", foreignKey = @ForeignKey(name = "FK_ID_TIPO_BICICLETA"))
    private BikeType bikeType;
    @ManyToOne(
            cascade = {
                    CascadeType.MERGE,
                    CascadeType.REFRESH
            }
    )
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "id_subtipo_bicicleta", foreignKey = @ForeignKey(name = "FK_ID_SUBTIPO_BICICLETA"))
    private BikeSubType bikeSubType;
    @ManyToOne(
            cascade = {
                    CascadeType.MERGE,
                    CascadeType.REFRESH
            }
    )
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "id_tamanio", foreignKey = @ForeignKey(name = "FK_ID_TAMANIO"))
    private Size size;

    @ManyToOne(
            cascade = {
                    CascadeType.MERGE,
                    CascadeType.REFRESH
            }
    )
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "id_rodado", foreignKey = @ForeignKey(name = "FK_ID_RODADO"))
    private Wheel wheel;

    public Bike() {
    }

    public Bike(Integer id, User user, String name, BigDecimal price, String description, Status status, Material material, Currency currency, Frame frame, BrakeType brakeType, Transmission transmission, String color, Brand brand, Model model, BikeType bikeType, BikeSubType bikeSubType, Size size,Wheel wheel) {
        super(id, user, name, price, description, status);
        this.material = material;
        this.currency = currency;
        this.frame = frame;
        this.brakeType = brakeType;
        this.transmission = transmission;
        this.color = color;
        this.brand = brand;
        this.model = model;
        this.bikeType = bikeType;
        this.bikeSubType = bikeSubType;
        this.size = size;
        this.wheel = wheel;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Frame getFrame() {
        return frame;
    }

    public void setFrame(Frame frame) {
        this.frame = frame;
    }

    public BrakeType getBrakeType() {
        return brakeType;
    }

    public void setBrakeType(BrakeType brakeType) {
        this.brakeType = brakeType;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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

    public BikeType getBikeType() {
        return bikeType;
    }

    public void setBikeType(BikeType bikeType) {
        this.bikeType = bikeType;
    }

    public BikeSubType getBikeSubType() {
        return bikeSubType;
    }

    public void setBikeSubType(BikeSubType bikeSubType) {
        this.bikeSubType = bikeSubType;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return  super.toString()+
                "\tBike{" +
                "material=" + material +
                ", currency=" + currency +
                ", frame=" + frame +
                ", brakeType=" + brakeType +
                ", transmission=" + transmission +
                ", color='" + color + '\'' +
                ", brand=" + brand +
                ", model=" + model +
                ", bikeType=" + bikeType +
                ", bikeSubType=" + bikeSubType +
                ", size=" + size +
                ", wheel=" + wheel +
                '}';
    }
}
