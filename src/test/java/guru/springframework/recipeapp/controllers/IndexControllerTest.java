package guru.springframework.recipeapp.controllers;

import guru.springframework.recipeapp.models.Recipe;
import guru.springframework.recipeapp.services.RecipeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.*;

public class IndexControllerTest {

    @Mock
    RecipeService recipeService;

    @Mock
    Model model;

    IndexController indexController;

    @Before
    public void setUp() throws Exception {
        //Initialize the @Mocks
        MockitoAnnotations.initMocks(this);
        indexController = new IndexController(recipeService);

    }

    @Test
    public void index() {


        //given
        Set<Recipe> recipes = new HashSet<>();
        Recipe recipe1 = new Recipe();
        recipe1.setDescription("descr1");

        recipes.add(recipe1);

        Recipe recipe2 = new Recipe();
        recipe2.setDescription("descr2");
        recipes.add(recipe2);

        when(recipeService.getRecipes()).thenReturn(recipes);

        //Arguments matcher
        ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);

        //when
        String viewName = indexController.getIndexPage(model);

        //then
        assertEquals("index", viewName);
        //Verify getRecipes are only called once
        verify(recipeService, times(1)).getRecipes();
        //verify the any set method was called on Recipes class at least once
        //verify(model, times(1)).addAttribute(eq("recipes"), anySet());
        //verify specific argument set
        verify(model, times(1)).addAttribute(eq("recipes"), argumentCaptor.capture());
        Set<Recipe> setInController  = argumentCaptor.getValue();
        //verifies that two arguments were set
        assertEquals(2, setInController.size());


    }
}