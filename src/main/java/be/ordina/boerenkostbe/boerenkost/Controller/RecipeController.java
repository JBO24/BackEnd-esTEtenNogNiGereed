package be.ordina.boerenkostbe.boerenkost.Controller;

import be.ordina.boerenkostbe.boerenkost.Model.Recipe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RecipeController {
    private static final String recipe = "Hello From Recipe!";
    private final Logger log = LoggerFactory.getLogger(RecipeController.class);

    @GetMapping("/recipe")
    public String getAllRecipes() {
        log.debug("Request to get all recipes");
        return recipe;
    }

    @GetMapping("/recipe/{id}")
    public ResponseEntity<Recipe> getRecipe(@PathVariable("id") Long id) {
        log.debug("REST request to get QuestionInterval : {}", id);
        Recipe recipe = new Recipe();
        recipe.setName("Boerenkost");
        recipe.setCategory("Hoofdgerecht");
        recipe.setDescription("Echte goeie boerenkost");
        return ResponseEntity.ok().header("Content-Type", "application/json").body(recipe);
    }
}
