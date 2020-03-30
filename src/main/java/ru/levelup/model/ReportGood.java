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


}