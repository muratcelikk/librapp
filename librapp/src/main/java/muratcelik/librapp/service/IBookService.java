package muratcelik.librapp.service;

import muratcelik.librapp.entity.Book;

import java.util.List;
import java.util.Optional;

/**
 * @author Murat Çelik
 */
public interface IBookService {

    List<Book> getAllBook();

    Optional<Book> getBookById(Long id);

    void addBook(Book book);

    void deleteBook(Long id);

    void updateBook(Book bookDetails);

    Book findBookByName(String bookName);
}
