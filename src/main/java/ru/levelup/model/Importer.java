package ru.levelup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

// Организация - Импортер
@Entity
public class Importer {
    @Id
    @GeneratedValue
    private int id;

    public Importer(String importerName, String INN, String country, String city, String streetHous,
                    String headFIO, String accountantFIO) {
        this.importerName = importerName;
        this.INN = INN;
        this.country = country;
        this.city = city;
        this.streetHouse = streetHous;
        this.headFIO = headFIO;
        this.accountantFIO = accountantFIO;
    }

    public Importer() {
    }

    @Column
    private String importerName; // Название организации или ФИО ИП

    @Column
    private String INN; // ИНН

    @Column
    private String country; // Страна

    @Column
    private String city; // Город

    @Column
    private String streetHouse; // Адрес

    @Column
    private String headFIO; // ФИО руководителя организации

    @Column
    private String accountantFIO; // ФИО бухгалтера

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImporterName() {
        return importerName;
    }

    public void setImporterName(String importerName) {
        this.importerName = importerName;
    }

    public String getINN() {
        return INN;
    }

    public void setINN(String INN) {
        this.INN = INN;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreetHouse() {
        return streetHouse;
    }

    public void setStreetHouse(String streetHouse) {
        this.streetHouse = streetHouse;
    }

    public String getHeadFIO() {
        return headFIO;
    }

    public void setHeadFIO(String headFIO) {
        this.headFIO = headFIO;
    }

    public String getAccountantFIO() {
        return accountantFIO;
    }

    public void setAccountantFIO(String accountantFIO) {
        this.accountantFIO = accountantFIO;
    }
}