package be.ordina.boerenkostbe.boerenkost.Service;

import be.ordina.boerenkostbe.boerenkost.Model.Result;
import be.ordina.boerenkostbe.boerenkost.Repository.RecipeRepository;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class RecipeService {
    private RecipeRepository recipeRepository;
    private final String URL = "https://api.edamam.com/search?q=chicken&app_id=f86460be&app_key=a1a5a1c37a6df85df542693488a81bc7";

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public ResponseEntity<Result> getResults() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("Content-Type", "application/json");
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<Result> entity = new HttpEntity<>(new Result(), headers);
        return restTemplate.exchange(
                URL, HttpMethod.GET, entity, Result.class);
    }

    public ResponseEntity<Result> getRecipeBySearch(String search) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("Content-Type", "application/json");
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<Result> entity = new HttpEntity<>(new Result(), headers);
        String search_URL = "https://api.edamam.com/search?q=" + search + "&app_id=f86460be&app_key=a1a5a1c37a6df85df542693488a81bc7";
        return restTemplate.exchange(
                search_URL, HttpMethod.GET, entity, Result.class);
    }


}
