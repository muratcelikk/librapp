package muratcelik.librapp.repository;

import muratcelik.librapp.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

/**
 * @author Murat Çelik
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Query(value = "SELECT b.author_name,b.book_name FROM Book b ")
    Book findBookByName(String bookName);
}
