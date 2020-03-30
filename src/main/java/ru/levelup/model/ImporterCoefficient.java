package ru.levelup.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class ImporterCoefficient { // коэффициент
    @Id
    @GeneratedValue
    private int id;

    @Column
    private Importer importer;

    @Column
    private int coefficient;

}

