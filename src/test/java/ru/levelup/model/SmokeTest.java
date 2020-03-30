package ru.levelup.model;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class SmokeTest {
    private EntityManagerFactory factory;
    private EntityManager manager;

    @Before
    public void connect() {
        factory = Persistence.createEntityManagerFactory("TestPersistenceUnit");
        manager = factory.createEntityManager();
    }

    @After
    public void close() {
        if (manager != null) {
            manager.close();
        }
        if (factory != null){
            factory.close();
        }
    }

    @Test
    public void createUserTest() {
        User user = new User();
        user.setLogin("test-user");

        Group group = new Group();
        group.setName("test-group");
        user.setGroup(group);
        user.setStatus(UserStatus.REMOVED);


        manager.getTransaction().begin();
        manager.persist(group);
        manager.persist(user);

        User foundUser = manager.find(User.class, user.getId());
        Assert.assertNotNull(foundUser);
        Assert.assertSame(foundUser, user);

        manager.getTransaction().commit();
        manager.refresh(foundUser);

    }

    @Test
    public void testSearchGroups(){
        createUserTest();

        //List<User> foundUser =
        //        //        manager.createQuery("SELECT u from User u where u.group.name = :group", User.class)
        //        //                .setParameter("group", "test-group")
        //        //                .getResultList();

        List<User> foundUser =
                manager.createQuery("SELECT u from User u where u.status = :status", User.class)
                        .setParameter("status", UserStatus.REMOVED)
                        .getResultList();

        Assert.assertEquals(1, foundUser.size());
        Assert.assertEquals("test-user", foundUser.get(0).getLogin());

    }
}
