package ru.home.learning.components.interfaces;

import ru.home.learning.models.Book;

import javax.ejb.Remote;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Удаленный интерфейс компонента BookEJB
 */
@Remote
public interface BookEJBRemote {
    /**
     * Использует именованный запрос findAllBooks, определенный
     * в сущности Book, чтобы получить все экземпляры книг из базы данных
     *
     * @return
     */
    List<Book> findBooks();

    /**
     * Принимает объект типа Book (которая не может иметь значение null)
     * в качестве параметра, сохраняет его в базе данных и затем возвращает его
     *
     * @param book объект типа Book
     * @return объект типа Book
     */
    @NotNull
    Book createBook(@NotNull Book book);

    void deleteBook(@NotNull Book book);

    /**
     * Принимает отдельные объекты типа Book (которые не могут иметь
     * значение null) в качестве параметра и объединяет их.
     * С помощью метода merge() объект прикрепляется к менеджеру сущностей
     * и синхронизируется с базой данных
     *
     * @param book объект типа Book
     * @return объект типа Book
     */
    @NotNull Book updateBook(@NotNull Book book);
}
