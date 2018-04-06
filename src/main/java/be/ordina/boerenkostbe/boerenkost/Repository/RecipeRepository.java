package be.ordina.boerenkostbe.boerenkost.Repository;

import be.ordina.boerenkostbe.boerenkost.Model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    Optional<Recipe> findById(Long id);
}
