package muratcelik.librapp.controller;

import lombok.RequiredArgsConstructor;
import muratcelik.librapp.entity.Book;
import muratcelik.librapp.service.implementation.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

/**
 * @author Murat Çelik
 */
@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    //GetAll
    @RequestMapping(value = "/book", method = RequestMethod.GET)
    public ResponseEntity<Collection<Book>> getAllBook() {  //Collection
        return new ResponseEntity<>(bookService.getAllBook(), HttpStatus.OK);
    }

    //GetById
    @RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
    public ResponseEntity<Optional<Book>> getBookById(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    //Add
    @RequestMapping(value = "/book", method = RequestMethod.POST)
    public ResponseEntity<String> addBook(@RequestBody Book book) {
        bookService.addBook(book);
        return new ResponseEntity<>("OK", HttpStatus.CREATED);
    }

    //Delete
    @RequestMapping(value = "/book/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    //Update
    @RequestMapping(value = "/book/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable Long id) {
        book.setId(id);
        bookService.updateBook(book);
        return ResponseEntity.noContent().build();
    }

//    //FindBy
//    @RequestMapping(value = "/book/{bookName}", method = RequestMethod.GET)
//    public Book findBookByName(@PathVariable String bookName) {
//        return bookService.findBookByName(bookName);
//    }
}
