package be.ordina.boerenkostbe.boerenkost.Controller;

import be.ordina.boerenkostbe.boerenkost.Model.Recipe;
import be.ordina.boerenkostbe.boerenkost.Model.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
@RequestMapping("/api")
public class RecipeController {
    private static final String recipe = "Hello From Recipe!";
    private final Logger log = LoggerFactory.getLogger(RecipeController.class);
    //used below for testing
    private final String URL = "https://api.edamam.com/search?q=chicken&app_id=f86460be&app_key=a1a5a1c37a6df85df542693488a81bc7";

    @GetMapping("/recipe")
    public String getAllRecipes() {
        log.debug("Request to get all recipes");
        Recipe recipe = new Recipe();
        return recipe.toString();
    }

    //id is being ignored for now
    @GetMapping("/recipe/{id}")
    public ResponseEntity<Result> getRecipe(@PathVariable("id") Long id) {
        log.debug("REST request to get Recipe : {}", id);
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("Content-Type", "application/json");
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<Result> entity = new HttpEntity<>(new Result(), headers);
        ResponseEntity<Result> responseEntity = restTemplate.exchange(
                URL, HttpMethod.GET, entity,Result.class);
        log.info(responseEntity.toString());
        return responseEntity;
    }

}
