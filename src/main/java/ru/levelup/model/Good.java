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

    @Column(nullable = false)
    String goodName;

    @Column(nullable = false)
    String goodNomenclatureCode;

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
        return goodNomenclatureCode;
    }

    public void setGoodNomenclatureCode(String goodNomenclatureCode) {
        this.goodNomenclatureCode = goodNomenclatureCode;
    }
}
