package muratcelik.librapp.entity;

/**
 * @author Murat Çelik
 */

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.FilterJoinTable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name = "book")
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "book_name", unique = true, nullable = false)
    private String book_name;

    @Column(name = "author_name", nullable = false)
    private String author_name;

    @Column(name = "book_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String book_date;

    @OneToMany(mappedBy = "book", targetEntity = User.class,cascade = CascadeType.ALL, orphanRemoval = false)
    private List<User> user;
}
