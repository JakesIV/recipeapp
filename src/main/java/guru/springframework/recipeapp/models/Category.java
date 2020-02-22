package guru.springframework.recipeapp.models;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

//specifying @Data
//Generate typical boilerplate code for POJOs, combines @Getter, @Setter, @ToString , @EqualsAndHashCode, RequiredArgsConstructor
//this was done by using Refactor and selecting Lombok and then @Data
//
@Data
@EqualsAndHashCode(exclude = {"recipe"})
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    //the mappedBy name should match the property name on the Recipe class
    @ManyToMany(mappedBy = "categories")
    private Set<Recipe> recipe;

}
