package ex.bookstore.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ex.bookstore.domain.Book;

@RepositoryRestResource(path = "books")
public interface BookRepository extends JpaRepository<Book, Long>{
    List<Book> findByPublicationYear(@Param("year")int publicationYear);
    //perii mm. palvelut save, deleteById, findByID, findAll
}
