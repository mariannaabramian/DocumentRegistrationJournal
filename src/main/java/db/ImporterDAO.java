package db;

import model.Importer;

import javax.persistence.EntityManager;
import java.util.Objects;

public class ImporterDAO {

    private EntityManager manager;

    public ImporterDAO(EntityManager manager) {
        Objects.requireNonNull(manager, "EntityManager shouldn't be null");
        this.manager = manager;
    }

    public Importer createImporter(String importerName, String INN, String country, String city, String streetHous,
                                   String headFIO, String accountantFIO){
        Importer importer = new Importer();
        importer.setImporterName(importerName);
        importer.setINN(INN);
        importer.setCountry(country);
        importer.setCity(city);
        importer.setStreetHouse(streetHous);
        importer.setHeadFIO(headFIO);
        importer.setAccountantFIO(accountantFIO);
        return importer;
    }





}
