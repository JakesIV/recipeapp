package guru.springframework.recipeapp.bootstrap;

import guru.springframework.recipeapp.models.*;
import guru.springframework.recipeapp.models.repositories.CategoryRepository;
import guru.springframework.recipeapp.models.repositories.RecipeRepository;
import guru.springframework.recipeapp.models.repositories.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by jt on 6/13/17.
 */
@Component
@Slf4j
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final CategoryRepository categoryRepository;
    private final RecipeRepository recipeRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public RecipeBootstrap(CategoryRepository categoryRepository, RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        recipeRepository.saveAll(getRecipes());
    }

    private List<Recipe> getRecipes() {

        log.debug("Loading default data for test purposes");

        List<Recipe> recipes = new ArrayList<>(2);

        log.debug("Get unit of measures");
        //get UOMs
        Optional<UnitOfMeasure> eachUomOptional = unitOfMeasureRepository.findByDescription("Each");

        if(!eachUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Found");
        }

        Optional<UnitOfMeasure> tableSpoonUomOptional = unitOfMeasureRepository.findByDescription("Tablespoon");

        if(!tableSpoonUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Found");
        }

        Optional<UnitOfMeasure> teaSpoonUomOptional = unitOfMeasureRepository.findByDescription("Teaspoon");

        if(!teaSpoonUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Found");
        }

        Optional<UnitOfMeasure> dashUomOptional = unitOfMeasureRepository.findByDescription("Dash");

        if(!dashUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Found");
        }

        Optional<UnitOfMeasure> pintUomOptional = unitOfMeasureRepository.findByDescription("Pint");

        if(!pintUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Found");
        }

        Optional<UnitOfMeasure> cupsUomOptional = unitOfMeasureRepository.findByDescription("Cup");

        if(!cupsUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Found");
        }

        log.debug("Get optionals for UOM");
        //get optionals
        UnitOfMeasure eachUom = eachUomOptional.get();
        UnitOfMeasure tableSpoonUom = tableSpoonUomOptional.get();
        UnitOfMeasure teaspoonUom = tableSpoonUomOptional.get();
        UnitOfMeasure dashUom = dashUomOptional.get();
        UnitOfMeasure pintUom = pintUomOptional.get();
        UnitOfMeasure cupsUom = cupsUomOptional.get();

        log.debug("Get categories");
        //get Categories
        Optional<Category> americanCategoryOptional = categoryRepository.findByDescription("American");

        if(!americanCategoryOptional.isPresent()){
            throw new RuntimeException("Expected Category Not Found");
        }

        Optional<Category> mexicanCategoryOptional = categoryRepository.findByDescription("Mexican");

        if(!mexicanCategoryOptional.isPresent()){
            throw new RuntimeException("Expected Category Not Found");
        }

        Category americanCategory = americanCategoryOptional.get();
        Category mexicanCategory = mexicanCategoryOptional.get();

        log.debug("Create recipe for Guacamole");
        //Yummy Guac
        Recipe guacRecipe = new Recipe();
        guacRecipe.setDescription("Perfect Guacamole");
        guacRecipe.setPrepTime(10);
        guacRecipe.setCookTime(0);
        guacRecipe.setServings(2);
        guacRecipe.setUrl("");
        //guacRecipe.setImage(new Byte[10]);
        guacRecipe.setDifficulty(Difficulty.EASY);
        log.debug("Add directions to recipe for Guacamole");
        guacRecipe.setDirections("1 Cut avocado, remove flesh: Cut the avocados in half. Remove seed. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon" +
                "\n" +
                "2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)" +
                "\n" +
                "3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n" +
                "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\n" +
                "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.\n" +
                "4 Cover with plastic and chill to store: Place plastic wrap on the surface of the guacamole cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.\n" +
                "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.\n" +
                "\n" +
                "\n" +
                "Read more: http://www.simplyrecipes.com/recipes/perfect_guacamole/#ixzz4jvpiV9Sd");

        log.debug("Create recipe notes for Guacamole");
        Notes guacNotes = new Notes();
        guacNotes.setRecipeNotes("For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados.\n" +
                "Feel free to experiment! One classic Mexican guacamole has pomegranate seeds and chunks of peaches in it (a Diana Kennedy favorite). Try guacamole with added pineapple, mango, or strawberries.\n" +
                "The simplest version of guacamole is just mashed avocados with salt. Don't let the lack of availability of other ingredients stop you from making guacamole.\n" +
                "To extend a limited supply of avocados, add either sour cream or cottage cheese to your guacamole dip. Purists may be horrified, but so what? It tastes great.\n" +
                "\n" +
                "\n" +
                "Read more: http://www.simplyrecipes.com/recipes/perfect_guacamole/#ixzz4jvoun5ws");
        guacNotes.setRecipe(guacRecipe);
        guacRecipe.setNotes(guacNotes);

        log.debug("Add ingredients to recipe for Guacamole");
        guacRecipe.addIngredient("ripe avocados", new BigDecimal(2), eachUom);
        guacRecipe.addIngredient("Kosher salt", new BigDecimal(".5"), teaspoonUom);
        guacRecipe.addIngredient("fresh lime juice or lemon juice", new BigDecimal(2), tableSpoonUom);
        guacRecipe.addIngredient("minced red onion or thinly sliced green onion", new BigDecimal(2), tableSpoonUom);
        guacRecipe.addIngredient("serrano chiles, stems and seeds removed, minced", new BigDecimal(2), eachUom);
        guacRecipe.addIngredient("Cilantro", new BigDecimal(2), tableSpoonUom);
        guacRecipe.addIngredient("freshly grated black pepper", new BigDecimal(2), dashUom);
        guacRecipe.addIngredient("ripe tomato, seeds and pulp removed, chopped", new BigDecimal(".5"), eachUom);

        guacRecipe.getCategories().add(americanCategory);
        guacRecipe.getCategories().add(mexicanCategory);

        //add to return list
        recipes.add(guacRecipe);

        log.debug("Create recipe for Taco");
        //Yummy Tacos
        Recipe tacosRecipe = new Recipe();
        tacosRecipe.setDescription("Spicy Grilled Chicken Taco");
        tacosRecipe.setCookTime(9);
        tacosRecipe.setPrepTime(20);
        tacosRecipe.setServings(2);
        tacosRecipe.setUrl("");
        //tacosRecipe.setImage(new Byte[10]);
        tacosRecipe.setDifficulty(Difficulty.MODERATE);
        log.debug("Add directions to recipe for Taco");
        tacosRecipe.setDirections("1 Prepare a gas or charcoal grill for medium-high, direct heat.\n" +
                "2 Make the marinade and coat the chicken: In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over.\n" +
                "Set aside to marinate while the grill heats and you prepare the rest of the toppings.\n" +
                "\n" +
                "\n" +
                "3 Grill the chicken: Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat registers 165F. Transfer to a plate and rest for 5 minutes.\n" +
                "4 Warm the tortillas: Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side.\n" +
                "Wrap warmed tortillas in a tea towel to keep them warm until serving.\n" +
                "5 Assemble the tacos: Slice the chicken into strips. On each tortilla, place a small handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges.\n" +
                "\n" +
                "\n" +
                "Read more: http://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/#ixzz4jvtrAnNm");

        log.debug("Create recipe notes for Taco");
        Notes tacoNotes = new Notes();
        tacoNotes.setRecipeNotes("We have a family motto and it is this: Everything goes better in a tortilla.\n" +
                "Any and every kind of leftover can go inside a warm tortilla, usually with a healthy dose of pickled jalapenos. I can always sniff out a late-night snacker when the aroma of tortillas heating in a hot pan on the stove comes wafting through the house.\n" +
                "Today’s tacos are more purposeful – a deliberate meal instead of a secretive midnight snack!\n" +
                "First, I marinate the chicken briefly in a spicy paste of ancho chile powder, oregano, cumin, and sweet orange juice while the grill is heating. You can also use this time to prepare the taco toppings.\n" +
                "Grill the chicken, then let it rest while you warm the tortillas. Now you are ready to assemble the tacos and dig in. The whole meal comes together in about 30 minutes!\n" +
                "\n" +
                "\n" +
                "Read more: http://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/#ixzz4jvu7Q0MJ");
        tacoNotes.setRecipe(tacosRecipe);
        tacosRecipe.setNotes(tacoNotes);

        log.debug("Add ingredients to recipe for Taco");
        tacosRecipe.addIngredient("Ancho Chili Powder", new BigDecimal(2), tableSpoonUom);
        tacosRecipe.addIngredient("Dried Oregano", new BigDecimal(1), teaspoonUom );
        tacosRecipe.addIngredient("Dried Cumin", new BigDecimal(1), teaspoonUom);
        tacosRecipe.addIngredient("Sugar", new BigDecimal(1), teaspoonUom);
        tacosRecipe.addIngredient("Salt", new BigDecimal(".5"), teaspoonUom);
        tacosRecipe.addIngredient("Clove of Garlic, Choppedr", new BigDecimal(1), eachUom);
        tacosRecipe.addIngredient("finely grated orange zestr", new BigDecimal(1), tableSpoonUom);
        tacosRecipe.addIngredient("fresh-squeezed orange juice", new BigDecimal(3), tableSpoonUom);
        tacosRecipe.addIngredient("Olive Oil", new BigDecimal(2), tableSpoonUom);
        tacosRecipe.addIngredient("boneless chicken thighs", new BigDecimal(4), tableSpoonUom);
        tacosRecipe.addIngredient("small corn tortillasr", new BigDecimal(8), eachUom);
        tacosRecipe.addIngredient("packed baby arugula", new BigDecimal(3), cupsUom );
        tacosRecipe.addIngredient("medium ripe avocados, slic", new BigDecimal(2), eachUom );
        tacosRecipe.addIngredient("radishes, thinly sliced", new BigDecimal(4), eachUom );
        tacosRecipe.addIngredient("cherry tomatoes, halved", new BigDecimal(".5"), pintUom );
        tacosRecipe.addIngredient("red onion, thinly sliced", new BigDecimal(".25"), eachUom );
        tacosRecipe.addIngredient("Roughly chopped cilantro", new BigDecimal(4), eachUom );
        tacosRecipe.addIngredient("cup sour cream thinned with 1/4 cup milk", new BigDecimal(4), cupsUom );
        tacosRecipe.addIngredient("lime, cut into wedges", new BigDecimal(4), eachUom );

        tacosRecipe.getCategories().add(americanCategory);
        tacosRecipe.getCategories().add(mexicanCategory);

        recipes.add(tacosRecipe);
        log.debug("Load completed successfully");
        return recipes;
    }
}