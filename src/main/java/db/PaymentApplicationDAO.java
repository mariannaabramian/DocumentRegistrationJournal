package db;

import model.Document;
import model.PaymentApplication;

import javax.persistence.EntityManager;
import java.util.Objects;

public class PaymentApplicationDAO {
    private EntityManager manager;

    public PaymentApplicationDAO(EntityManager manager) {
        Objects.requireNonNull(manager, "EntityManager can't ");
        this.manager = manager;
    }

    public PaymentApplication PaymentApplicationCreate(Document document, String paymentDocumentNumber,
                                                       int totalQuantity){
        PaymentApplication paymentApplication = new PaymentApplication();
        paymentApplication.setDocument(document);
        paymentApplication.setPaymentDocNumber(paymentDocumentNumber);
        paymentApplication.setTotalQuantity(totalQuantity);
        return paymentApplication;
    }
}
