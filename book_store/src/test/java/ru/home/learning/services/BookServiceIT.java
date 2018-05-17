package ru.home.learning.services;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.Test;
import ru.home.learning.interceptors.bindings.Loggable;
import ru.home.learning.models.Book;

import javax.inject.Inject;
import java.util.logging.Logger;

import static org.junit.Assert.assertTrue;

/**
 * Интеграционный тест BookService
 * Created by YANesterov on 17.05.2018.
 */
@Loggable
public class BookServiceIT {
    @Inject
    private Logger logger;

    @Test
    public void shouldCheckNumberIsMOCK() {
        logger.info("call shouldCheckNumberIsMOCK()");

        Weld weld = new Weld();
        WeldContainer container = weld.initialize();
        BookService service = container.instance().select(BookService.class).get();
        Book book = service.createBook("H2G2", 12.5f, "Изучаем Java EE 7");
        assertTrue(book.getNumber().startsWith("MOCK"));
        weld.shutdown();
    }
}
