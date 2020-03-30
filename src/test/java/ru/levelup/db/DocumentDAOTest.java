package ru.levelup.db;

import ru.levelup.model.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import ru.levelup.db.DocumentDAO;

public class DocumentDAOTest {
    private EntityManagerFactory factory;
    private EntityManager manager;
    private DocumentDAO documentsJournal;

    @Before
    public void connect() {
        factory = Persistence.createEntityManagerFactory("TestPersistenceUnit");
        manager = factory.createEntityManager();
        documentsJournal = new DocumentDAO(manager);
    }

    @After
    public void close() {
        if (manager != null) {
            manager.close();
        }
        if (factory != null) {
            factory.close();
        }
    }


    @Test
    public void LoadDocument(){

        Group group = new Group();
        group.setName("Инспектор");

        User inspector = new User();
        inspector.setLogin("IvanovIV_6752");
        inspector.setGroup(group);

        manager.getTransaction().begin();
        manager.persist(group);
        manager.persist(inspector);
        manager.getTransaction().commit();

        Importer importer = new Importer();
        importer.setImporterName("ООО РосИмпорт");
        importer.setINN("1234567890");
        importer.setCountry("Россия");
        importer.setCity("Санкт-Петербург");
        importer.setStreetHouse("1-ая Советскяа улица д. 5");
        importer.setHeadFIO("Иванов Иван Иванович");
        importer.setAccountantFIO("Петрова Ларисса Владимировна" );

        Document document = new Document();
        document.setDocType(DocType.APPLICATION);
        document.setTitle("Заявление на оплату акцизных марок");
        document.setImporterDocumentNumber("100999/20200329/345");

        Journal journal = new Journal();

        documentsJournal.LoadDocument(importer, document, journal, inspector);
        documentsJournal.SetDocumentValidated(journal, inspector);





    }
}
