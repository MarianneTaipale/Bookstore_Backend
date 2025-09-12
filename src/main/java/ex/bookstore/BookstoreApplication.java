package ex.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ex.bookstore.domain.Book;
import ex.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean CommandLineRunner demo(BookRepository repository){
		return(args) -> {
			Book b1 = new Book("Missio vai mielenrauha", "Jare Henrik Tiihonen", 2025, 9789510504260L, 31.95);
			Book b2 = new Book("Niko, Kaikki mitä en ole kertonut", "Mari Koppinen", 2025, 9789511500971L, 29.95);

			repository.save(b1);
			repository.save(b2);
		};
	}
}
