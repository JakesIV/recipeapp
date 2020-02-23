package guru.springframework.recipeapp.models.repositories;

import guru.springframework.recipeapp.models.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

//Brings in Spring context
@RunWith(SpringRunner.class)
//Bring up imbedded database and configure Spring data JPA
@DataJpaTest
public class UnitOfMeasureRepositoryIT {

    @Autowired
    UnitOfMeasureRepository unitOfMeasureRepository;


    @Before
    public void setUp() throws Exception {
    }

    @Test
    //@DirtiesContext , this will refresh the spring context
    public void findByDescription() {
        String uomString = "Teaspoon";
        Optional<UnitOfMeasure> unitOfMeasure = unitOfMeasureRepository.findByDescription(uomString);
        assertEquals(uomString, unitOfMeasure.get().getDescription());
    }

    @Test
    public void findByDescriptionCup() {
        String uomString = "Cup";
        Optional<UnitOfMeasure> unitOfMeasure = unitOfMeasureRepository.findByDescription(uomString);
        assertEquals(uomString, unitOfMeasure.get().getDescription());
    }
}