package model;

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
    private String accaunterFIO; // ФИО бухгалтера


}