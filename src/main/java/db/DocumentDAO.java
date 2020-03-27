package db;

import model.DocType;
import model.Document;
import model.Importer;

import javax.persistence.EntityManager;
import java.util.Objects;

public class DocumentDAO {
    private EntityManager manager;

    public DocumentDAO(EntityManager manager) {
        Objects.requireNonNull(manager, "EntityManager can't ");
        this.manager = manager;
    }

    public Document createDocument(DocType docType, String title, String importerDocumentNumber, Importer importer){
        Document document = new Document();
        document.setDocType(docType);
        document.setTitle(title);
        document.setImporterDocumentNumber(importerDocumentNumber);
        document.setImporter(importer);
        return(document);
    }



}
