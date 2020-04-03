package ru.levelup.web;

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
        UsersDAO users = new UsersDAO(manager);
        if (users.findGroupByName("test") == null) {
            users.createGroup("test");
        }
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