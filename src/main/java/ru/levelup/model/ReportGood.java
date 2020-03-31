package ru.levelup.model;

import javax.persistence.*;

@Entity
public class ReportGood {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne(optional = false)
    private QauntityReport qauntityReport;

    @ManyToOne(optional = false)
    private Good good; //Код товарной номенклатуре

    @Column(nullable = false)
    private String quantity; //Количество товара за отчетный период

    @Column(nullable = false)
    private String retailPrice; //Розничная цена

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
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(String retailPrice) {
        this.retailPrice = retailPrice;
    }
}