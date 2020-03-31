package ru.levelup.model;

import javax.persistence.*;

@Entity
public class ApplicationGood {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne(optional = false)
    private PaymentApplication paymentApplication;

    @ManyToOne(optional = false)
    private Good good; // Код по товарной номенклатуре

    @Column(nullable = false)
    private int quantity; // Количество (в единицах измерения)

    @Column(nullable = false)
    private float price; // Цена за единицу

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Good getGood() {
        return good;
    }

    public void setGood(Good good) {
        this.good = good;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}