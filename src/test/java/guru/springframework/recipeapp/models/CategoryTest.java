package guru.springframework.recipeapp.models;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {

    Category category;

    @BeforeEach
    public void setup ()
    {
        category = new Category();
    }


    @Test
    void setId() {
        Long id = 4L;
        category.setId(id);
        assertEquals(id, category.getId());
    }

    @Test
    void setDescription() {
        String testValue = "nice description";
        category.setDescription(testValue);
        assertEquals(testValue, category.getDescription());
    }

    @Test
    void setRecipe() {
        Set<Recipe> recipes = new HashSet<>();
        Recipe recipe = new Recipe();
        recipe.setDescription("recipe description");

        recipes.add(recipe);
        category.setRecipe(recipes);
        assertEquals(recipes, category.getRecipe());
    }
}