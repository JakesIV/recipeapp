package guru.springframework.recipeapp.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Data
@EqualsAndHashCode(exclude = {"recipe"})
@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    private String description;
    private BigDecimal amount;

    //No cascade used as Recipe owns the object and we dont want to remove recipe if Ingredients are removed
    @ManyToOne
    private Recipe recipe;

    //No cascade strategy as UOM is used everywhere, demonstrates an eager fetch type, this is th default
    @OneToOne(fetch = FetchType.EAGER)
    private UnitOfMeasure uom;

    public Ingredient()
    {
    }

    public Ingredient(String description, BigDecimal amount, UnitOfMeasure uom, Recipe recipe) {
        setDescription(description);
        setAmount(amount);
        setRecipe(recipe);
        setUom(uom);
    }



}
