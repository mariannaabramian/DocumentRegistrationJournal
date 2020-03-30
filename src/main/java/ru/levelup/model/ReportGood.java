package ru.levelup.model;

import javax.persistence.*;

@Entity
public class ReportGood {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    private Good good; //Код товарной номенклатуре

    @Column
    private String Quantity; //Количество товара за отчетный период

    @Column
    private String RetailPrice; //Розничная цена

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

    public String getRetailPrice() {
        return RetailPrice;
    }

    public void setRetailPrice(String retailPrice) {
        RetailPrice = retailPrice;
    }
}