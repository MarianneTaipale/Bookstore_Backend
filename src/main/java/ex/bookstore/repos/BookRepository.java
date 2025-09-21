package ex.bookstore.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import ex.bookstore.domain.Book;

public interface BookRepository extends JpaRepository<Book, Long>{
    //perii mm. palvelut save, deleteById, findByID, findAll
}
