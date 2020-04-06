package ru.levelup.db;

import com.sun.istack.Nullable;
import net.bytebuddy.dynamic.scaffold.TypeInitializer;
import ru.levelup.model.*;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.Objects;

public class DocumentsDAO {
    private EntityManager manager;

    public DocumentsDAO(EntityManager manager) {
        Objects.requireNonNull(manager, "EntityManager shouldn't be null");
        this.manager = manager;
    }



    // сохр нового импортера
    public Importer addImporter(String name, String inn, String country, String city,
                                String streetHouse, String headFIO, String accountantFIO){

        Importer importer = new Importer();
        manager.getTransaction().begin();
        try {
            importer.setImporterName(name);
            importer.setINN(inn);
            importer.setCountry(country);
            importer.setCity(city);
            importer.setStreetHouse(streetHouse);
            importer.setHeadFIO(headFIO);
            importer.setAccountantFIO(accountantFIO);
            manager.persist(importer);

            } catch (Throwable cause) {
                manager.getTransaction().rollback();
                throw cause;
            }
            manager.getTransaction().commit();


        return importer;
    }


    @Nullable
    public Importer findImporterByName(String name) {
        try {
            return manager.createQuery("SELECT i from Importer i WHERE i.importerName = :nameToSearch", Importer.class)
                    .setParameter("nameToSearch", name)
                    .getSingleResult();
        } catch (NoResultException cause) {
            return null;
        }
    }


    @Nullable
    public Importer findImporterByINN(String inn) {
        try {
            return manager.createQuery("SELECT i from Importer i WHERE i.inn = :innToSearch", Importer.class)
                    .setParameter("innToSearch", inn)
                    .getSingleResult();
        } catch (NoResultException cause) {
            return null;
        }
    }

    // Загружаем XML документ
    public Journal storeDocument(Importer importer, Document document, Journal journal, User inspector){
        document.setImporter(importer);
        journal.setDocument(document);
        journal.setInspector(inspector);
        journal.setStatus(DocStatus.NEW);
        //journal.setStatusChangeDate(new Date());

        manager.getTransaction().begin();
        try {
            manager.persist(importer);
            manager.persist(document);
            manager.persist(journal);
        } catch (Throwable cause) {
            manager.getTransaction().rollback();
            throw cause;
        }

        manager.getTransaction().commit();

        return journal;
    }

    public Journal setDocumentValidated(Journal journal, User inspector){
        journal.setStatus(DocStatus.VALIDATED);
        journal.setInspector(inspector);

        manager.getTransaction().begin();
        try {
            manager.persist(journal);
        } catch (Throwable cause) {
            manager.getTransaction().rollback();
            throw cause;
        }

        manager.getTransaction().commit();

        return journal;
    }

    public Journal setDocumentValidationFailed(Journal journal, User inspector, String validationErrorText){
        journal.setStatus(DocStatus.VALIDATION_ERROR);
        journal.setInspector(inspector);
        journal.setValidationErrorText(validationErrorText);

        manager.getTransaction().begin();
        try {
            manager.persist(journal);
        } catch (Throwable cause) {
            manager.getTransaction().rollback();
            throw cause;
        }

        manager.getTransaction().commit();

        return journal;
    }


    public Journal setDocumentRegistered(Journal journal, User inspector, String registrationNumber){
        journal.setStatus(DocStatus.REGISTERED);
        journal.setInspector(inspector);
        Document document = journal.getDocument();
        document.setRegistrationNumber(registrationNumber);

        manager.getTransaction().begin();
        try {
            manager.persist(document);
            manager.persist(journal);
        } catch (Throwable cause) {
            manager.getTransaction().rollback();
            throw cause;
        }

        manager.getTransaction().commit();

        return journal;
    }

    public  Journal setDocumentRegistrationRejected(Journal journal, User inspector, RegistrarionRejectReason registrationRejectionReason){
        journal.setStatus(DocStatus.REGISTRATION_REJECTED);
        journal.setInspector(inspector);
        journal.setRegistrationRejectReason(registrationRejectionReason);

        manager.getTransaction().begin();
        try {
            manager.persist(journal);
        } catch (Throwable cause) {
            manager.getTransaction().rollback();
            throw cause;
        }

        manager.getTransaction().commit();

        return journal;

    }

    public  Journal setDocumentUnderConsidaration(Journal journal, User inspector){
        journal.setStatus(DocStatus.UNDER_CONSIDARATION);
        journal.setInspector(inspector);

        manager.getTransaction().begin();
        try {
            manager.persist(journal);
        } catch (Throwable cause) {
            manager.getTransaction().rollback();
            throw cause;
        }

        manager.getTransaction().commit();

        return journal;

    }

    public Journal setDocumentProcessed(Journal journal, User inspector){
        journal.setStatus(DocStatus.PROCESSED);
        journal.setInspector(inspector);
        Document document = journal.getDocument();
        document.setProcessedFlag(true);

        manager.getTransaction().begin();
        try {
            manager.persist(document);
            manager.persist(journal);
        } catch (Throwable cause) {
            manager.getTransaction().rollback();
            throw cause;
        }

        manager.getTransaction().commit();

        return journal;

    }

}
