package com.spasov.cookingmvc.controller;

import com.spasov.cookingmvc.entity.Recipe;
import com.spasov.cookingmvc.service.IngridientService;
import com.spasov.cookingmvc.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/recipes")
public class RecipeController {
    @Autowired
    private RecipeService recipeService;
    @Autowired
    private IngridientService ingridientService;

    @GetMapping
    public String allRecipe(Model model) {
        model.addAttribute("recipes", recipeService.getAllRecipes());
        return "recipes/recipes";
    }

    @GetMapping("/{id}")
    public String showRecipe(@PathVariable Long id, Model model) {
        model.addAttribute("recipe", recipeService.getRecipeById(id));
        return "recipes/recipe";
    }

    @GetMapping("../")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/search")
    public String searchRecipe(@RequestParam String text, Model model) {
        List<Recipe> recipesByIngridientName = recipeService.getRecipesByIngridientName(text);
        model.addAttribute("containsIngridient", recipesByIngridientName);
        return "recipes/search";
    }
}
