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

}