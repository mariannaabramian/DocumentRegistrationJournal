package ru.levelup.model;

import javax.persistence.*;
import java.util.Date;

// Журнал документов и их регистраций
// Содержит инфу по загрузке документов, работе с ними (изменение статуса),
// инфа об инспекторе который работал с документом
@Entity
@Table
public class Journal {
    @Id
    @GeneratedValue
    private int id; // id записи в журнале

    public Journal(Document document, DocStatus docStatus,Date statusChangeDate, User inspector) {

        this.document = document;
        this.status = docStatus;
        this.statusChangeDate = statusChangeDate;
        this.inspector = inspector;
    }

    public Journal() {
    }

    @ManyToOne
    private Document document;

    @Column
    private DocStatus status;

    @Temporal(TemporalType.DATE)
    private Date statusChangeDate;

    @ManyToOne
    private User inspector;

    @Enumerated(EnumType.STRING)
    private RegistrarionRejectReason registrationRejectReason;

    @Column
    private String validationErrorText;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public DocStatus getStatus() {
        return status;
    }

    public void setStatus(DocStatus status) {
        this.status = status;
    }

    public Date getStatusChangeDate() {
        return statusChangeDate;
    }

    public void setStatusChangeDate(Date statusChangeDate) {
        this.statusChangeDate = statusChangeDate;
    }

    public User getInspector() {
        return inspector;
    }

    public void setInspector(User inspector) {
        this.inspector = inspector;
    }

    public RegistrarionRejectReason getRegistrationRejectReason() {
        return registrationRejectReason;
    }

    public void setRegistrationRejectReason(RegistrarionRejectReason registrationRejectReason) {
        this.registrationRejectReason = registrationRejectReason;
    }

    public String getValidationErrorText() {
        return validationErrorText;
    }

    public void setValidationErrorText(String validationErrorText) {
        this.validationErrorText = validationErrorText;
    }
}
