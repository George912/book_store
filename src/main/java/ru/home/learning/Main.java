package ru.home.learning;

import ru.home.learning.components.BookEJB;
import ru.home.learning.models.Book;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.List;

/**
 * Класс Main, вызывающий BookEJBRemote
 * Created by YANesterov on 15.05.2018.
 */
public class Main {
    public static void main(String[] args) throws NamingException {
        Context context = new InitialContext();
        BookEJB bookEJB = (BookEJB) context.lookup("java:global/book_store-1.0-SNAPSHOT/BookEJB!" +
                "ru.home.learning.components.interfaces.BookEJBRemote");

        List<Book> books = bookEJB.findBooks();
        for (Book book : books) {
            System.out.println("--- " + book);
        }
        Book book = new Book("The Hitchhiker's Guide to the Galaxy", 12.5F
                , "Science fiction by Douglas Adams.", "1-24561-799-0", 354, false);
        book = bookEJB.createBook(book);
        System.out.println("### Book created : " + book);
        book.setTitle("H2G2");
        book = bookEJB.updateBook(book);
        System.out.println("### Book updated : " + book);
        bookEJB.deleteBook(book);
        System.out.println("### Book deleted");
    }
}