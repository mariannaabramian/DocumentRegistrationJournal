package ru.levelup.model;

import javax.persistence.*;

// Документ. Содержит инфу по  документу
// и ссылку на внутренние данные каждого типа документа
@Entity
public class Document {
    @Id
    @GeneratedValue
    private int id;

    public Document(DocType docType, String title, String importerDocumentNumber, Importer importer) {
        this.docType = docType;
        this.title = title;
        this.importerDocumentNumber = importerDocumentNumber;
        this.importer = importer;
    }

    public Document() {
    }

    @Enumerated(EnumType.ORDINAL) // тип документа: Заявление, Отчет
    private DocType docType;

    @Column(length = 300)
    private String title; // название документа

    @Column(length = 50)
    private String importerDocumentNumber; // внутренний номер документа в системе Импортера

    @ManyToOne
    private Importer importer; // Импортер

    @OneToOne
    private PaymentApplication paymentApplication ; // Заявление об оплате ..., если другой тип документа то NULL

    @OneToOne
    private QauntityReport quantityReport; // Отчет об объемах ..., если другой тип документа то NULL

    @Column
    private String RegistrationNumber;

    @Column
    private boolean processedFlag; // флаг того что правильный  зарегистрированный документ обработан, т.е.
    // выполнены необходимые действия
    // например, отправлено уведомление импортеру об обработке Заявления
    // или посчитан коэффициент по Отчету


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DocType getDocType() {
        return docType;
    }

    public void setDocType(DocType docType) {
        this.docType = docType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImporterDocumentNumber() {
        return importerDocumentNumber;
    }

    public void setImporterDocumentNumber(String importerDocumentNumber) {
        this.importerDocumentNumber = importerDocumentNumber;
    }

    public Importer getImporter() {
        return importer;
    }

    public void setImporter(Importer importer) {
        this.importer = importer;
    }

    public PaymentApplication getPaymentApplication() {
        return paymentApplication;
    }

    public void setPaymentApplication(PaymentApplication paymentApplication) {
        this.paymentApplication = paymentApplication;
    }

    public QauntityReport getQuantityReport() {
        return quantityReport;
    }

    public void setQuantityReport(QauntityReport quantityReport) {
        this.quantityReport = quantityReport;
    }

    public String getRegistrationNumber() {
        return RegistrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        RegistrationNumber = registrationNumber;
    }

    public boolean isProcessedFlag() {
        return processedFlag;
    }

    public void setProcessedFlag(boolean processedFlag) {
        this.processedFlag = processedFlag;
    }
}
