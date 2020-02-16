package guru.springframework.recipeapp.controllers;

import guru.springframework.recipeapp.models.Category;
import guru.springframework.recipeapp.models.UnitOfMeasure;
import guru.springframework.recipeapp.models.repositories.CategoryRepository;
import guru.springframework.recipeapp.models.repositories.UnitOfMeasureRepository;
import guru.springframework.recipeapp.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.swing.text.html.Option;
import java.util.Optional;

@Controller
public class IndexController {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;
    private RecipeService recipeService;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.recipeService = new RecipeService();
    }

    @RequestMapping({"","/","index","index.html"})
    public String index(Model model){
        Optional<Category>  categoryDescription  = categoryRepository.findByDescription("Junk Food");
        Optional<UnitOfMeasure>  uomDescription  = unitOfMeasureRepository.findByDescription("Teaspoon");
        //This refers to index.html in template folder
        model.addAttribute("recipes", recipeService.getAllRecipes());
        model.addAttribute("categoryDescription", categoryDescription);
        model.addAttribute("uomDescription", uomDescription);
        return "index";
    }
}
