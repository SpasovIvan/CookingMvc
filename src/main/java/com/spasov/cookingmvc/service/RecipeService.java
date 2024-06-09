package com.spasov.cookingmvc.service;

import com.spasov.cookingmvc.entity.Ingridient;
import com.spasov.cookingmvc.exception.RecipeNotFoundException;
import com.spasov.cookingmvc.entity.Recipe;
import com.spasov.cookingmvc.repository.RecipeRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class RecipeService {
    @Autowired
    private RecipeRespository recipeRespository;

    public void save(Recipe recipe) {
        recipeRespository.save(recipe);
    }

    public List<Recipe> getAllRecipes() {
        return recipeRespository.findAll();
    }

    public Recipe getRecipeById(Long id) {
        return recipeRespository.findById(id).orElseThrow(() -> new RecipeNotFoundException(id));
    }

    public void deleteRecipeById(Long id) {
        recipeRespository.deleteById(id);
    }

    public List<Recipe> getRecipesByIngridientName(String name) {
        List<Recipe> recipes = recipeRespository.findAll();
        ArrayList<Recipe> recipesContainName = new ArrayList<>();
        for (Recipe recipe : recipes) {
            for (Ingridient ingridient : recipe.getIngridients()) {
                if (ingridient.getName().equalsIgnoreCase(name)) {
                    recipesContainName.add(recipe);
                    break;
                }
            }
        }
        return recipesContainName;
    }

}
