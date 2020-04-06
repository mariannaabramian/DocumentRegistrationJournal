package ru.levelup.web;

import ru.levelup.model.DocType;
import ru.levelup.model.Importer;

import java.util.List;

public class DocumentForm {
    private DocType docType;
    private String tytle;
    private String importerDocNumber;
    private List<Importer> importers;

    public DocType getDocType() {
        return docType;
    }

    public void setDocType(DocType docType) {
        this.docType = docType;
    }

    public String getTytle() {
        return tytle;
    }

    public void setTytle(String tytle) {
        this.tytle = tytle;
    }

    public String getImporterDocNumber() {
        return importerDocNumber;
    }

    public void setImporterDocNumber(String importerDocNumber) {
        this.importerDocNumber = importerDocNumber;
    }

    public List<Importer> getImporters() {
        return importers;
    }

    public void setImporters(List<Importer> importers) {
        this.importers = importers;
    }
}
