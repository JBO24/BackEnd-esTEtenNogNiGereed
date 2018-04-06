package be.ordina.boerenkostbe.boerenkost.Service;

import be.ordina.boerenkostbe.boerenkost.Repository.RecipeRepository;
import org.springframework.stereotype.Service;

@Service
public class RecipeService {
    private RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    private void findById(Long id) {
        this.recipeRepository.findById(id);
    }
}
