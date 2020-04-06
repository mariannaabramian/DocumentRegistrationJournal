package ru.levelup.db;

import ru.levelup.model.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.Assert.assertNotNull;

public class DocumentsDAOTest {
    private EntityManagerFactory factory;
    private EntityManager manager;
    private DocumentsDAO documentsDAO;

    @Before
    public void connect() {
        factory = Persistence.createEntityManagerFactory("TestPersistenceUnit");
        manager = factory.createEntityManager();
        documentsDAO = new DocumentsDAO(manager);
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
    public void createImporter() {
        Importer importer = new Importer();
        importer = documentsDAO.addImporter("ООО РосИмпорт1", "1234567890", "Россия",
                "Санкт-Петербург", "1-ая Советскяа улица д. 5", "Иванов Иван Иванович",
                "Петрова Ларисса Ивановна");
        importer = documentsDAO.addImporter("ООО РосИмпорт1", "2345678901", "Россия",
                "Санкт-Петербург", "1-ая Советскяа улица д. 5", "Иванов Иван Иванович",
                "Петрова Ларисса Ивановна");
        importer = documentsDAO.addImporter("ООО РосИмпорт1", "3456789012", "Россия",
                "Санкт-Петербург", "1-ая Советскяа улица д. 5", "Иванов Иван Иванович",
                "Петрова Ларисса Ивановна");
    }

    @Test
    public void createDuplicateImporter() {
        Importer importer = new Importer();
        importer = documentsDAO.addImporter("ООО РосИмпорт1", "1234000000", "Россия",
                "Санкт-Петербург", "1-ая Советскяа улица д. 5", "Иванов Иван Иванович",
                "Петрова Ларисса Ивановна");
        importer = documentsDAO.addImporter("ООО РосИмпорт1", "1234000000", "Россия",
                "Санкт-Петербург", "1-ая Советскяа улица д. 5", "Иванов Иван Иванович",
                "Петрова Ларисса Ивановна");
    }


    @Test
    public void storeDocument(){

        Group group = new Group();
        group.setName("Инспектор");

        User inspector = new User();
        inspector.setLogin("IvanovIV_6752");
        inspector.setPassword("123");
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
        importer.setAccountantFIO("Петрова Ларисса Владимировна");

        Document document = new Document();
        document.setDocType(DocType.APPLICATION);
        document.setTitle("Заявление на оплату акцизных марок");
        document.setImporterDocumentNumber("100999/20200329/345");

        Journal journal = new Journal();

        documentsDAO.storeDocument(importer, document, journal, inspector);
        documentsDAO.setDocumentValidated(journal, inspector);


    }


}
