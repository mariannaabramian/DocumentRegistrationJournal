package model;

import javax.persistence.*;

// Документ. Содержит инфу по  документу
// и ссылку на внутренние данные каждого типа документа
@Entity
public class Document {
    @Id
    @GeneratedValue
    private int id;

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
    private int RegistrationNumber;

    @Column
    private boolean processedFlag; // флаг того что правильный  зарегистрированный документ обработан, т.е.
    // выполнены необходимые действия
    // например, отправлено уведомление импортеру об обработке Заявления
    // или посчитан коэффициент по Отчету

}
