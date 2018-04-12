package be.ordina.boerenkostbe.boerenkost.Controller;

import be.ordina.boerenkostbe.boerenkost.Model.Recipe;
import be.ordina.boerenkostbe.boerenkost.Model.Result;
import be.ordina.boerenkostbe.boerenkost.Repository.RecipeRepository;
import be.ordina.boerenkostbe.boerenkost.Service.RecipeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class RecipeController {
    private final Logger log = LoggerFactory.getLogger(RecipeController.class);
    private RecipeRepository recipeRepository;
    private RecipeService recipeService;
    //used below for testing

    @GetMapping("/recipe")
    public ResponseEntity<Result> getAllRecipes() {
        ResponseEntity<Result> responseEntity = recipeService.getResults();
        log.info(responseEntity.toString());
        return responseEntity;
    }

    //id is being ignored for now
    @GetMapping("/recipe/{id}")
    public String getRecipe(@PathVariable("id") Long id) {
        log.debug("REST request to get Recipe : {}", id);
        Recipe recipe = recipeRepository.findById(id).orElse(null);
        assert recipe != null;
        return recipe.toString();
    }

    @GetMapping("/recipe/search")
    public ResponseEntity<Result> getRecipeBySearch(@RequestParam(value = "search", required = false) String search) {
        System.out.println(search);
        return recipeService.getRecipeBySearch(search);
    }


    public RecipeController(RecipeRepository recipeRepository, RecipeService recipeService) {
        this.recipeRepository = recipeRepository;
        this.recipeService = recipeService;
    }
}
