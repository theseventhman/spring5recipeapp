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

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
}