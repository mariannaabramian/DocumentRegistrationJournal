package model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class QauntityReport {
    @Id
    @GeneratedValue
    private int id;

    @Column
    private Date beginDate; // начальная дата отчетного периода

    @Column
    private Date endDate; // конечная дата отчетного периода

    @OneToMany
    private List<ReportGood> members;

}

