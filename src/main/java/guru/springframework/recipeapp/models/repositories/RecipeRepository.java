package guru.springframework.recipeapp.models.repositories;

import guru.springframework.recipeapp.models.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
