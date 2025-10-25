package ex.bookstore;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ex.bookstore.web.BookController;
import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class BookControllerTest {

    @Autowired
    private BookController controller;

    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }
}
