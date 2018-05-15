package ru.home.learning;

import ru.home.learning.models.Book;
import ru.home.learning.services.BookService;

/**
 * Точка входа
 * Created by YANesterov on 15.05.2018.
 */
public class Main {
    public static void main(String[] args) {
        Weld weld = new Weld();
        WeldContainer container = weld.initialize();
        BookService bookService = container.instance().select(BookService.class).get();
        Book book = bookService.createBook("H2G2", 12.5f, "Изучаем Java EE 7");
        System.out.println(book);
        weld.shutdown();
    }
}
