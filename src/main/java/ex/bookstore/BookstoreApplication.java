package ex.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ex.bookstore.domain.Book;
import ex.bookstore.domain.BookRepository;
import ex.bookstore.domain.Category;
import ex.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean 
	CommandLineRunner demo(BookRepository repository){
		return(args) -> {
			Book b1 = new Book("Missio vai mielenrauha", "Jare Henrik Tiihonen", 2025, 9789510504260L, 31.95);
			Book b2 = new Book("Niko, Kaikki mitä en ole kertonut", "Mari Koppinen", 2025, 9789511500971L, 29.95);

			repository.save(b1);
			repository.save(b2);
		};
	}

	@Bean 
	CommandLineRunner categoriesDemo(CategoryRepository categoryRepository){
		return(args) -> {
			Category c1 = new Category("Scifi");
			Category c2 = new Category("Comedy");

			categoryRepository.save(c1);
			categoryRepository.save(c2);
		};
	}
}
