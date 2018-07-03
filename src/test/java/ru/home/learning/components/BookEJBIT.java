package ru.home.learning.components;

import org.junit.Test;
import ru.home.learning.models.Book;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Интеграционный тест BookEJB с использованием
 * встраиваемого контейнера
 */
public class BookEJBIT {
    @Test
    public void shouldCreateBook() throws Exception {
        Map<String, Object> properties = new HashMap<>();
        properties.put(EJBContainer.MODULES, new File("target/classes"));

        try (EJBContainer container = EJBContainer.createEJBContainer(properties)) {
            Context context = container.getContext();
            assertNotNull(context.lookup("java:global/jdbc/demoPUDS"));
            assertNotNull(context.lookup(
                    "java:global/classes/BookEJB!ru.home.learning.components.interfaces.BookEJBRemote"));
            assertNotNull(context.lookup("java:global/classes/BookEJB!ru.home.learning.components.BookEJB"));

            BookEJB bookEJB = (BookEJB) context.lookup(
                    "java:global/classes/BookEJB!ru.home.learning.components.BookEJB");
            assertEquals(2, bookEJB.findBooks().size());

            Book book = new Book("H2G2", 12.5F, "Научная фантастика", "1-24561-799-0"
                    , 354, false);
            book = bookEJB.createBook(book);
            assertNotNull("ID не может быть пустым", book.getId());
            assertEquals(3, bookEJB.findBooks().size());

            bookEJB.deleteBook(book);
            assertEquals(2, bookEJB.findBooks().size());
        }
    }
}