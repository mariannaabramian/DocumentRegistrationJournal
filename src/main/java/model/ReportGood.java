package model;

import javax.persistence.*;

@Entity
public class ReportGood {
    @Id
    @GeneratedValue
    private int id;

    @Column
    private String TNCode; //Код товарной номенклатуре

    @Column
    private String Quantity; //Количество товара за отчетный период

    @Column
    private String RetailPrice; //Розничная цена


}