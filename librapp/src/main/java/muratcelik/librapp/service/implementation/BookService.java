package muratcelik.librapp.service.implementation;

import lombok.RequiredArgsConstructor;
import muratcelik.librapp.entity.Book;
import muratcelik.librapp.repository.BookRepository;
import muratcelik.librapp.service.IBookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Murat Çelik
 */
@Service
@RequiredArgsConstructor
public class BookService implements IBookService {

    private final BookRepository bookRepository;  //@RequiredArgsConstructor ve final ifadesi-->Constructor İnjection yerine kullanılır. //Değer atanmak zorunda oda constructor olur.

    @Override
    public List<Book> getAllBook() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public void addBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public void updateBook(Book bookDetails) {
        Book book = bookRepository.getOne(bookDetails.getId());
        book.setBook_name(bookDetails.getBook_name());
        book.setAuthor_name(bookDetails.getAuthor_name());
        book.setBook_date(bookDetails.getBook_date());
        bookRepository.save(book);
    }

    @Override
    public Book findBookByName(String bookName) {
        return bookRepository.findBookByName(bookName);
    }
}
