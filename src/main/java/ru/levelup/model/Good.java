package ru.levelup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Good {
    @Id
    @GeneratedValue
    private int id;

    @Column
    String goodName;

    @Column
    String GoodNomenclatureCode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public String getGoodNomenclatureCode() {
        return GoodNomenclatureCode;
    }

    public void setGoodNomenclatureCode(String goodNomenclatureCode) {
        GoodNomenclatureCode = goodNomenclatureCode;
    }
}
