package ex.bookstore.web;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ex.bookstore.domain.Book;
import ex.bookstore.repos.BookRepository;

@RestController
public class BookRestController {

    private final BookRepository repository;

    public BookRestController(BookRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value = "/api/books", method = RequestMethod.GET)
    public @ResponseBody List<Book> bookListRest() {
        return (List<Book>) repository.findAll();
    }

    @RequestMapping(value = "/api/books/{id}", method = RequestMethod.GET)
    public @ResponseBody Book findBookRest(@PathVariable("id") Long bookId) {
        return repository.findById(bookId).orElse(null);
    }
}
