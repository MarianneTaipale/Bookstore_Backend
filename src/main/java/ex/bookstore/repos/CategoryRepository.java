package ex.bookstore.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import ex.bookstore.domain.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
