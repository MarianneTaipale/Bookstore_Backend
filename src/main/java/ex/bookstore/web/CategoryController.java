package ex.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ex.bookstore.domain.Category;
import ex.bookstore.repos.CategoryRepository;

@Controller
public class CategoryController {

    private CategoryRepository cRepository;

    public CategoryController(CategoryRepository cRepository){
        this.cRepository = cRepository;
    }

    @RequestMapping(value = "/categorylist", method = RequestMethod.GET)
    public String categoryList(Model model){
        model.addAttribute("categories", cRepository.findAll());
        return "categorylist";
    }

    @GetMapping("/addcategory")
    public String addCategoryFrom(Model model) {
        model.addAttribute("category", new Category());
        return "addcategory";
    }

    @RequestMapping(value = "/addcategory", method = RequestMethod.POST)
    public String saveCategory(Category category) {
        cRepository.save(category);
        return "redirect:/booklist";
    }

}

