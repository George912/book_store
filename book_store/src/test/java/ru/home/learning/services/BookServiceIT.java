package ru.home.learning.services;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.Test;
import ru.home.learning.models.Book;

import static org.junit.Assert.assertTrue;

/**
 * Интеграционный тест BookService
 * Created by YANesterov on 17.05.2018.
 */
public class BookServiceIT {
    @Test
    public void shouldCheckNumberIsMOCK() {
        Weld weld = new Weld();
        WeldContainer container = weld.initialize();
        BookService service = container.instance().select(BookService.class).get();
        Book book = service.createBook("H2G2", 12.5f, "Learn Java EE 7");
        assertTrue(book.getNumber().startsWith("MOCK"));
        weld.shutdown();
    }
}
