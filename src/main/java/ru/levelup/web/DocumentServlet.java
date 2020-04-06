package ru.levelup.web;

import ru.levelup.db.UsersDAO;
import ru.levelup.db.DocumentsDAO;
import ru.levelup.model.*;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/document")
public class DocumentServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EntityManager manager = PersistenceUtils.createManager(req.getServletContext());
        List<Group> groups;
        try {
            groups = new UsersDAO(manager).findAllGroups();
        } finally {
            manager.close();
        }

       DocumentForm form = new DocumentForm();
        form.setDocType(DocType.APPLICATION);
        form.setTytle("");
        form.setImporterDocNumber("");

        req.setAttribute("form", form);

        req.getRequestDispatcher("/pages/document.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DocType docType = DocType.APPLICATION;
        String tytle = req.getParameter("tytle");
        String importerDocNumber = req.getParameter("importerDocNumber");
        String importerName = req.getParameter("importerName");

        EntityManager manager = PersistenceUtils.createManager(req.getServletContext());
        DocumentsDAO documentsDAO = new DocumentsDAO(manager);
        UsersDAO usersDAO = new UsersDAO(manager);
        try {
            User user = new User();
            user = usersDAO.findUserByLogin("User1");

            Importer importer = documentsDAO.findImporterByName(importerName);
            //if (importer == null) {
               // throw new IllegalStateException("No importer " + importerName + " found");
            //}

            Document document = new Document();
            document.setDocType(docType);
            document.setTitle(tytle);
            document.setImporterDocumentNumber(importerDocNumber);

            Journal journal = new Journal();

            documentsDAO.storeDocument(importer, document, journal, user);

        } finally {
            manager.close();
        }

        resp.sendRedirect(req.getContextPath() + "/journal");
    }
}
