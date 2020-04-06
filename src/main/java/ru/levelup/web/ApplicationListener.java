package ru.levelup.web;

import ru.levelup.db.DocumentsDAO;
import ru.levelup.db.UsersDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ApplicationListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ProdPersistenceUnit");
        sce.getServletContext().setAttribute("factory", factory);

        // по хорошему нужн создать форму для заведения групп
        // здесь можно создать специального пользователя админа
        // или создать настройки стартовые
        // ничего не начнется пока этот метод не закончится. тут можно все инициализировать
        EntityManager manager = factory.createEntityManager();
        UsersDAO usersDAO = new UsersDAO(manager);
        if (usersDAO.findGroupByName("test") == null) {
            usersDAO.createGroup("test");
        }

        /*DocumentsDAO documentsDAO = new DocumentsDAO(manager);
        documentsDAO.addImporter("ООО РосИмпорт1", "1234567890", "Россия",
                "Санкт-Петербург", "1-ая Советскяа улица д. 5", "Иванов Иван Иванович",
                "Петрова Ларисса Ивановна");*/
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        EntityManagerFactory factory = (EntityManagerFactory) sce.getServletContext()
                .getAttribute("factory");

        if (factory != null) {
            factory.close();
        }
    }
}