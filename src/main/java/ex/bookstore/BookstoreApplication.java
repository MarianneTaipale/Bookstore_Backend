package ex.bookstore;

<<<<<<< HEAD
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
=======
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ex.bookstore.domain.Book;
import ex.bookstore.domain.Category;
import ex.bookstore.repos.BookRepository;
import ex.bookstore.repos.CategoryRepository;
import ex.bookstore.repos.UserRepository;
import ex.bookstore.domain.User;
>>>>>>> 83be9603ced19f5268515b9696f706c8a84ab4a0

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

<<<<<<< HEAD
=======
	@Bean 
	CommandLineRunner demo(BookRepository brepository, CategoryRepository cRepository, UserRepository uRepository){
		return(args) -> {
			Category c1 = new Category("Scifi");
			Category c2 = new Category("Comedy");

			cRepository.save(c1);
			cRepository.save(c2);
			
			Book b1 = new Book("Missio vai mielenrauha", "Jare Henrik Tiihonen", 2025, 9789510504260L, 31.95, c1);
			Book b2 = new Book("Niko, Kaikki mitä en ole kertonut", "Mari Koppinen", 2025, 9789511500971L, 29.95, c2);

			brepository.save(b1);
			brepository.save(b2);

			User user1 = new User("user", "$2a$10$6MNnSEt3Wusif9dGPPggs.s34KbuzgEvAJiC7bJUZnDU0u4MzrPgK", "user@user.com" , "USER");
			User user2 = new User("admin", "$2a$10$SitR96dwQZqcclbwmF8mLORXQQsoVagp34ehYiquA.0mRBXxvhvwK", "admin@admin.com" , "ADMIN");

			uRepository.save(user1);
			uRepository.save(user2);
		};
	}
>>>>>>> 83be9603ced19f5268515b9696f706c8a84ab4a0
}
