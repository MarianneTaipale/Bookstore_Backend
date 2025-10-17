package ex.bookstore.web;

<<<<<<< HEAD
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class BookController {

    @GetMapping("/index")
        public String indexPage(){
            return "index page";
=======
import ex.bookstore.repos.CategoryRepository;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ex.bookstore.domain.Book;
import ex.bookstore.repos.BookRepository;

@Controller
public class BookController {

    private final CategoryRepository categoryRepository;

    private BookRepository repository;

    public BookController(BookRepository repository, CategoryRepository categoryRepository) {
        this.repository = repository;
        this.categoryRepository = categoryRepository;
    }

    @RequestMapping("/booklist")
    public String bookList(Model model) {
        model.addAttribute("books", repository.findAll()); // haetaan tietokannasta kirjat, SELECT
        return "booklist";
    }

    // edit book tunnilla
    @GetMapping("/editbook/{id}")
    public String getEditBookForm(@PathVariable(name = "id") Long id, Model model) {
        model.addAttribute("book", repository.findById(id));
        return "editbook";
    }

    // edit book
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String currentBook(@PathVariable("id") Long bookId, Model model) {
        repository.findAll();
        return "redirect:/booklist";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editBook(Model model) {
        model.addAttribute("edit", new Book());
        return "editbook";
    }

    // delete book
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long bookId) {
        repository.deleteById(bookId); // SQL DELETE
        return "redirect:/booklist";
    }

    // add book
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("category", categoryRepository.findAll());
        return "addbook";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveBook(Book book) {
        repository.save(book);
        return "redirect:/booklist";
    }

    @RequestMapping(value = "/login")
    public String login(){
        return "login";
>>>>>>> 83be9603ced19f5268515b9696f706c8a84ab4a0
    }
}
