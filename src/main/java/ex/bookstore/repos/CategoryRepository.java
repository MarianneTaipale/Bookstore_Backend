package ex.bookstore.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ex.bookstore.domain.Category;

@RepositoryRestResource
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
