package guru.springframework.recipeapp.models;

import lombok.*;

import javax.persistence.*;

@Data
@EqualsAndHashCode(exclude = {"recipe"})
@Entity
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Dont cascade back to Recipe
    @OneToOne
    private Recipe recipe;

    //cater for large string values in database, this will be a character large object field because opf type String
    @Lob
    private String recipeNotes;

    public Notes() {
    }


}
