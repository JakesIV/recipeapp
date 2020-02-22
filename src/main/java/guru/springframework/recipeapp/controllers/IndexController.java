package guru.springframework.recipeapp.controllers;

import guru.springframework.recipeapp.models.Category;
import guru.springframework.recipeapp.models.UnitOfMeasure;
import guru.springframework.recipeapp.models.repositories.CategoryRepository;
import guru.springframework.recipeapp.models.repositories.UnitOfMeasureRepository;
import guru.springframework.recipeapp.services.RecipeService;
import guru.springframework.recipeapp.services.RecipeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.swing.text.html.Option;
import java.util.Optional;

@Controller
@Slf4j
public class IndexController {
    private RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"","/","index","index.html"})
    public String index(Model model){
        log.debug("We are now in the Index controller class");
        //This refers to index.html in template folder
        model.addAttribute("recipes", recipeService.getRecipes());
        return "index";
    }
}
