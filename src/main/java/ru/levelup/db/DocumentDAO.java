package ru.levelup.db;

import ru.levelup.model.*;

import javax.persistence.EntityManager;
import javax.persistence.Transient;
import java.util.Date;
import java.util.Objects;

public class DocumentDAO {
    private EntityManager manager;

    public DocumentDAO(EntityManager manager) {
        Objects.requireNonNull(manager, "EntityManager shouldn't be null");
        this.manager = manager;
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
