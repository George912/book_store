package ru.home.learning.components.interfaces;

import ru.home.learning.models.Book;

import javax.ejb.Remote;
import java.util.List;

/**
 * Удаленный интерфейс компонента BookEJB
 */
@Remote
public interface BookEJBRemote {
    List<Book> findBooks();

    Book createBook(Book book);

    void deleteBook(Book book);

    Book updateBook(Book book);
}
