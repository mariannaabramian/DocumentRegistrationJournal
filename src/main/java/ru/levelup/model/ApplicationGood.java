package ru.levelup.model;

import javax.persistence.*;

@Entity
public class ApplicationGood {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    private Good good; //Код товарной номенклатуре

    @Column
    private String Quantity; //Количество (в единицах измерения)

    @Column
    private String Price; //Цена за единицу

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

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }
}