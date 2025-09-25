package ex.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ex.bookstore.domain.Book;
import ex.bookstore.domain.Category;
import ex.bookstore.repos.BookRepository;
import ex.bookstore.repos.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean 
	CommandLineRunner demo(BookRepository brepository, CategoryRepository cRepository){
		return(args) -> {
			Category c1 = new Category("Scifi");
			Category c2 = new Category("Comedy");

			cRepository.save(c1);
			cRepository.save(c2);
			
			Book b1 = new Book("Missio vai mielenrauha", "Jare Henrik Tiihonen", 2025, 9789510504260L, 31.95, c1);
			Book b2 = new Book("Niko, Kaikki mitä en ole kertonut", "Mari Koppinen", 2025, 9789511500971L, 29.95, c2);

			brepository.save(b1);
			brepository.save(b2);
		};
	}
}
