package guru.springframework.recipeapp.models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Ingredients {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    private String description;
    private Float amount;

    //No cascade used as Recipe owns the object and we dont want to remove recipe if Ingredients are removed
    @ManyToOne
    private Recipe recipe;

    //No cascade strategy as UOM is used everywhere, demonstrates an eager fetch type, this is th default
    @OneToOne(fetch = FetchType.EAGER)
    private UnitOfMeasure uom;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}
