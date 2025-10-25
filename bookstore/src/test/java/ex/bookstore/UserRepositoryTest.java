package ex.bookstore;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import ex.bookstore.domain.User;
import ex.bookstore.repos.UserRepository;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository urepository;

    // create

    @Test
    public void createUser() {
        User user = new User("user", "user", "user.user@gmail.com", "USER");

        urepository.save(user);
        assertThat(user.getId()).isNotNull();
    }

    // delete

    @Test
    public void deleteUser() {
        User user = new User("admin", "admin", "admin.admin@gmail.com", "ADMIN");

        urepository.save(user);

        Long id = user.getId();
        urepository.delete(user);

        assertThat(urepository.findById(id).isEmpty());
    }

    // search

    @Test
    public void findUserByUsername() {
        User user = new User("admin2", "admin", "admin.admin@gmail.com", "ADMIN");
        urepository.save(user);

        User user1 = urepository.findByUsername("admin2");

        assertThat(user1).isNotNull();
        assertThat(user1.getEmail()).isEqualTo("admin.admin@gmail.com");
        assertThat(user1.getRole()).isEqualTo("ADMIN");
    }
}
