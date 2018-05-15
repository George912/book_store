package ru.home.learning.services;

import ru.home.learning.models.Book;

/**
 * Сервис для для создания книг
 * Created by YANesterov on 15.05.2018.
 */
@Loggable
public class BookService {
    @Inject @ThirteenDigits
    private NumberGenerator numberGenerator;

    public Book createBook(String title, Float price, String description){
        Book book = new BookService(title, price, description);
        book.setNumber(numberGenerator.generateNumber());
        return book;
    }
}
