package ru.home.learning;

import ru.home.learning.models.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Точка входа
 * Created by YANesterov on 15.05.2018.
 */
public class Main {
    public static void main(String[] args) {
        Book book = new Book("H2G2", 12.5f, "Learn Java EE 7", "1-84023-742-2", 354, false);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("demoPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(book);
        tx.commit();
        em.close();
        emf.close();
    }
}