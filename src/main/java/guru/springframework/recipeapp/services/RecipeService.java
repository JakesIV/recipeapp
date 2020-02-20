package guru.springframework.recipeapp.services;


import guru.springframework.recipeapp.models.Recipe;

import java.util.Set;

public interface RecipeService  {
    Set<Recipe> getRecipes();

}
