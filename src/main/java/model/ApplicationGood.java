package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ApplicationGood {
    @Id
    @GeneratedValue
    private int id;

    @Column
    private String TNCode; //Код товарной номенклатуре

    @Column
    private String Quantity; //Количество (в единицах измерения)

    @Column
    private String Price; //Цена за единицу

}