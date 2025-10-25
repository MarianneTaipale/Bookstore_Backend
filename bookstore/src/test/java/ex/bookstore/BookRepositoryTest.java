package ex.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import ex.bookstore.domain.Book;
import ex.bookstore.domain.Category;
import ex.bookstore.repos.BookRepository;
import ex.bookstore.repos.CategoryRepository;

@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository brepository;

    @Autowired
    private CategoryRepository crepository;

    // create
    @Test
    public void createNewBook() {
        Category category = new Category("Romance");
        crepository.save(category);

        Book book = new Book("Kallen seikkailut", "Roosa Suomi", 2020, 2121212110, 20.00,
                category);

        brepository.save(book);
        assertThat(book.getId()).isNotNull();
    }

    // delete

    @Test
    public void deleteBook() {
        Category category = new Category("Fiction");
        crepository.save(category);

        Book book = new Book("Sateinen keli", "Roope Ressu", 2023, 494994949, 24.99, category);

        brepository.save(book);

        Long id = book.getId();

        brepository.delete(book);
        assertThat(brepository.findById(id)).isEmpty();
    }

    // search
    @Test
    public void findByTitle() {
        Category category = new Category("Drama");
        crepository.save(category);

        Book book = new Book("Suomalainen sää", "Veera Salo", 2000, 393993399, 26.00, category);
        brepository.save(book);

        List<Book> books = brepository.findByTitle("Suomalainen sää");
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getPublicationYear()).isEqualTo(2000);
    }
}
