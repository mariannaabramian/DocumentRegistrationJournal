package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class GoodsTN {
    @Id
    @GeneratedValue
    private int id;

    @Column
    String goodName;

    @Column
    String TNCode;

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

    public String getTNCode() {
        return TNCode;
    }

    public void setTNCode(String TNCode) {
        this.TNCode = TNCode;
    }
}
