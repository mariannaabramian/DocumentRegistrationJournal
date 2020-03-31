package ru.levelup.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class PaymentApplication {
    @Id
    @GeneratedValue
    private int id;

    @OneToOne(optional = false)
    private Document document;

    @Column(nullable = false)
    private String paymentDocNumber; // номер платежного документа

    @Column(nullable = false)
    private int totalQuantity; //Общая стоимость к  оплате, указанная в документе (значение, которое надо проверить)

    @OneToMany(mappedBy = "paymentApplication")
    private List<ApplicationGood> members;

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

    public String getPaymentDocNumber() {
        return paymentDocNumber;
    }

    public void setPaymentDocNumber(String paymentDocNumber) {
        this.paymentDocNumber = paymentDocNumber;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }
}
