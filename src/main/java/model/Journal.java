package model;

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

    @ManyToOne
    private Document document;

    @Column
    private int status;

    @Column
    private Date statusChangeDate;

    @ManyToOne
    private User inspector;

    @Enumerated(EnumType.STRING)
    private RegistrarionRejectReason registrationRejectReason;

    @Column
    private String validationErrorText;

}
