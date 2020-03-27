package db;

import model.Document;
import model.QauntityReport;

import javax.persistence.EntityManager;
import java.util.Date;
import java.util.Objects;

public class QuantityReportDAO {
    private EntityManager manager;

    public QuantityReportDAO(EntityManager manager) {
        Objects.requireNonNull(manager, "EntityManager can't ");
        this.manager = manager;
    }

    public QauntityReport QauntityReportCreate(Document document, Date beginDate, Date endDate){
        QauntityReport qauntityReport = new QauntityReport();
        qauntityReport.setDocument(document);
        qauntityReport.setBeginDate(beginDate);
        qauntityReport.setEndDate(endDate);
        return qauntityReport;
    }
}
