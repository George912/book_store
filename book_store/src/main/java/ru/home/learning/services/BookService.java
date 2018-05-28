package ru.home.learning.services;

import ru.home.learning.generators.api.NumberGenerator;
import ru.home.learning.interceptors.bindings.Loggable;
import ru.home.learning.models.Book;
import ru.home.learning.qualifiers.ThirteenDigits;

import javax.inject.Inject;

/**
 * Сервис для для создания книг
 * Created by YANesterov on 15.05.2018.
 */
@Loggable
public class BookService {
    @Inject
    @ThirteenDigits
    private NumberGenerator numberGenerator;

    public Book createBook(String title, Float price, String description){
        Book book = new Book(title, price, description);
        book.setIsbn(numberGenerator.generateNumber());
        return book;
    }
}