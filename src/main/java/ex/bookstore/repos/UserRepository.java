package ex.bookstore.repos;

import org.springframework.data.repository.CrudRepository;

import ex.bookstore.domain.User;

public interface UserRepository extends CrudRepository<User, Long>{
    User findByUsername(String username);
}
