package model;

import javax.persistence.*;
import java.util.List;

@Entity
public class PaymentApplication {
    @Id
    @GeneratedValue
    private int id;

    @Column
    private String paymentDocNumber; // номер платежного документа

    @Column
    private int totalQuantity; //Общая стоимость к  оплате, указанная в документе (значение, которое надо проверить)

    @OneToMany
    private List<ApplicationGood> members;

}
