package guru.springframework.service;

import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
@Service
public class RecipeSerivceImpl implements  RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeSerivceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> getRecipes() {
        Set<Recipe> recipeSet = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipeSet:: add);
        return recipeSet;
    }
    @Override
    public Recipe findById(Long id){
        Optional<Recipe> recipeOptional = recipeRepository.findById(id);

        if(!recipeOptional.isPresent()){
            throw new RuntimeException("Recipe Not Found!");
        }
        return recipeOptional.get();
    }
}
