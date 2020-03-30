package ru.levelup.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class QauntityReport {
    @Id
    @GeneratedValue
    private int id;

    @OneToOne
    private Document document;

    @Column
    private Date beginDate; // начальная дата отчетного периода

    @Column
    private Date endDate; // конечная дата отчетного периода

    @OneToMany
    private List<ReportGood> members;

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

    public Date getBeginDate() {

        return beginDate;
    }

    public void setBeginDate(Date beginDate) {

        this.beginDate = beginDate;
    }

    public Date getEndDate() {

        return endDate;
    }

    public void setEndDate(Date endDate) {

        this.endDate = endDate;
    }
}

