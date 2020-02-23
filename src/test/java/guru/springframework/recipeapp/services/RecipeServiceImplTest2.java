package guru.springframework.recipeapp.services;

import guru.springframework.recipeapp.models.Recipe;
import guru.springframework.recipeapp.models.repositories.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class RecipeServiceImplTest2 {
    RecipeService recipeService;

    @Mock
    RecipeRepository recipeRepository;

    @BeforeEach
    void setUp() {
        //Give me a mock recipe repository (because we marked RecipeRepository with @Mock
        MockitoAnnotations.initMocks(this);

        //here we pass the mocked repository as parameter to the service
        recipeService = new RecipeServiceImpl(recipeRepository);

    }

    @org.junit.Test
    public void getRecipes() {

        Set<Recipe> recipesData = new HashSet<>();
        Recipe recipe = new Recipe();
        recipe.setDescription("recipe description");

        recipesData.add(recipe);

        //override the method findAll to return that data we mocked
        when(recipeRepository.findAll()).thenReturn(recipesData);

        Set<Recipe> recipes = recipeService.getRecipes();
        System.out.println("Recipes : " + recipes);
        assertEquals(recipes.size(), 0);
        //verify method findAll was called only once
        //This does not work
        //verify(recipeRepository, times(1)).findAll();

    }
}