package guru.springframework.service;

import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;
import javafx.beans.binding.When;
import org.h2.command.dml.MergeUsing;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.verification.Times;

import javax.swing.text.html.Option;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class RecipeSerivceImplTest {

    RecipeSerivceImpl recipeSerivce;

    @Mock
    RecipeRepository recipeRepository;
    @Before
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);

        recipeSerivce = new RecipeSerivceImpl(recipeRepository);
    }


    @Test
    public void getRecipes() throws Exception{
        Recipe recipe = new Recipe();
        HashSet receipesData = new HashSet();
        receipesData.add(recipe);

         when(recipeSerivce.getRecipes()).thenReturn(receipesData);
        Set<Recipe> recipes = recipeSerivce.getRecipes();
        assertEquals(recipes.size(),1);
        verify(recipeRepository, times(1)).findAll();
    }

    @Test
    public void getRecipeByIdTest() throws  Exception {
        Recipe recipe = new Recipe();
        recipe.setId(1l);
        Optional<Recipe> recipeOptional = Optional.of(recipe);

        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);

        Recipe recipeReturned = recipeSerivce.findById(1l);

        assertNotNull("Null recipe returned",recipeReturned);
        verify(recipeRepository,times(1)).findById(anyLong());
        verify(recipeRepository,never()).findAll();

    }
}