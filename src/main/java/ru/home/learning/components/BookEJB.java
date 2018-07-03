package ru.home.learning.components;

import ru.home.learning.components.interfaces.BookEJBRemote;
import ru.home.learning.models.Book;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Сессионный компонент, не сохраняющий состояние,
 * действует как фасад для операций CRUD
 */
@Stateless
@LocalBean
public class BookEJB implements BookEJBRemote {
    @Inject
    private EntityManager entityManager;

    public List<Book> findBooks() {
        TypedQuery<Book> query = entityManager.createNamedQuery(Book.FIND_ALL, Book.class);
        return query.getResultList();
    }

    public Book createBook(Book book) {
        entityManager.persist(book);
        return book;
    }

    public Book updateBook(Book book) {
        return entityManager.merge(book);
    }

    public void deleteBook(Book book) {
        entityManager.remove(entityManager.merge(book));
    }
}
