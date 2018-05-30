package ru.home.learning.models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.validation.ConstraintViolationException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Интеграционный тест: создает и извлекает Book из базы данных
 * Created by YANesterov on 28.05.2018.
 */
public class BookIT {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("demoTestPU");
    private EntityManager em;
    private EntityTransaction tx;

    {
        Book book = new Book(null, 12.5f, "empty title - error", "1-84023-742-2", 354, false);
        em.persist(book);
    }

    @Before
    public void initEntityManager() throws Exception {
        em = emf.createEntityManager();
        tx = em.getTransaction();
    }

    @After
    public void closeEntityManager() throws Exception {
        if (em != null) {
            em.close();
        }
    }

    @Test
    public void shouldFindJavaEE7Book() throws Exception {
        Book book = em.find(Book.class, 1001L);
        assertEquals("H2G2", book.getTitle());
    }

    @Test
    public void shouldCreateH2G2Book() throws Exception {
        Book book = new Book("H2G2", 12.5f, "Learn Java EE 7", "1-84023-742-2", 354, false);
        tx.begin();
        em.persist(book);
        tx.commit();
        assertNotNull("ID не может быть пустым", book.getId());

        book = em.createNamedQuery("findBookH2G2", Book.class).getSingleResult();
        assertEquals("Learn Java EE 7", book.getDescription());
    }

    @Test(expected = ConstraintViolationException.class)
    public void shouldRaiseConstraintViolationCauseNullTitle() {
        Book book = new Book(null, 12.5f, "empty title - error", "1-84023-742-2", 354, false);
        em.persist(book);
    }
}
