package ru.levelup.model;

import javax.persistence.*;

@Entity
public class ImporterCoefficient { // коэффициент
    @Id
    @GeneratedValue
    private int id;

    @OneToOne(optional = false)
    private Importer importer;

    @Column(nullable = true)
    private int coefficient;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Importer getImporter() {
        return importer;
    }

    public void setImporter(Importer importer) {
        this.importer = importer;
    }

    public int getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(int coefficient) {
        this.coefficient = coefficient;
    }
}

