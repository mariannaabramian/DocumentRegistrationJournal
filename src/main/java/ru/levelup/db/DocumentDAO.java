package ru.levelup.db;

import ru.levelup.model.*;

import javax.persistence.EntityManager;
import javax.persistence.Transient;
import java.util.Date;
import java.util.Objects;

public class DocumentDAO {
    private EntityManager manager;

    public DocumentDAO(EntityManager manager) {
        Objects.requireNonNull(manager, "EntityManager can't ");
        this.manager = manager;
    }

    // Загружаем XML документ
    public Journal LoadDocument(Importer importer, Document document, Journal journal, User inspector){
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

    public Journal SetDocumentValidated(Journal journal, User inspector){
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

    public Journal SetDocumentValidationFailed(Journal journal, User inspector, String validationErrorText){
        journal.setStatus(DocStatus.VALIDATIONERROR);
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


    public Journal SetDocumentRegistered(Journal journal, User inspector, String registrationNumber){
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

    public  Journal SetDocumentRegistrationRejected(Journal journal, User inspector, RegistrarionRejectReason registrationRejectionReason){
        journal.setStatus(DocStatus.REGISTRATIONREJECTED);
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

    public  Journal SetDocumentUnderConsidaration(Journal journal, User inspector){
        journal.setStatus(DocStatus.UNDERCONSIDARATION);
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

    public Journal SetDocumentProcessed(Journal journal, User inspector){
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
