package ex.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ex.bookstore.web.CategoryController;

@SpringBootTest
public class CategoryControllerTest {

    @Autowired
    private CategoryController controller;

    @Test 
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }
}
