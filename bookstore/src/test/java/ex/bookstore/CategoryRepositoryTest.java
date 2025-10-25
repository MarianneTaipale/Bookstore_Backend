package ex.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import ex.bookstore.domain.Category;
import ex.bookstore.repos.CategoryRepository;

@DataJpaTest
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository crepository;

    // create

    @Test
    public void createNewCategory() {
        Category category = new Category("Romance");

        crepository.save(category);
        assertThat(category).isNotNull();
    }

    // delete

    @Test
    public void deleteCategory() {
        Category category = new Category("Fiction");

        crepository.save(category);

        Long id = category.getCategoryid();

        crepository.delete(category);
        assertThat(crepository.findById(id)).isEmpty();
    }

    // search

    @Test
    public void findByName(){
        Category category = new Category("Drama");

        crepository.save(category);

        List<Category> categories = crepository.findByName("Drama");
        assertThat(categories).hasSize(1);
        assertThat(categories.get(0).getName()).isEqualTo("Drama");
    }
}
