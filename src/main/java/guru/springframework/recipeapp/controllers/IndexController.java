package guru.springframework.recipeapp.controllers;

import guru.springframework.recipeapp.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    RecipeService recipeService;

    public IndexController() {
        this.recipeService = new RecipeService();
    }

    @RequestMapping({"","/","index","index.html"})
    public String index(Model model){
        //This refers to index.html in template folder
        model.addAttribute("recipe", recipeService.getAllRecipes());
        return "index";
    }
}
