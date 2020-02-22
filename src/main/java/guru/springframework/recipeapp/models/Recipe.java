package guru.springframework.recipeapp.models;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String url;

    @Lob
    private String directions;

    //This will create a binary large object field in database because of the Byte array
    @Lob
    private Byte[] image;

    //Ordinal will be persisted as the enum sequence value e.g 1,2,3 etc. or String
    @Enumerated(value = EnumType.STRING)
    private Difficulty difficulty;

    @OneToOne(cascade = CascadeType.ALL)
    private Notes notes;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private Set<Ingredient> ingredients = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "recipe_category",
            joinColumns = @JoinColumn(name= "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories= new HashSet<>();

    public Recipe() {
    }

    public void addIngredient(String description, BigDecimal amount, UnitOfMeasure uom)
    {
        getIngredients().add(new Ingredient("ripe avocados", new BigDecimal(2), uom, this));
    }


}
