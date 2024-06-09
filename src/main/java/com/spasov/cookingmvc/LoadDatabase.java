package com.spasov.cookingmvc;

import com.spasov.cookingmvc.entity.Ingridient;
import com.spasov.cookingmvc.entity.Recipe;
import com.spasov.cookingmvc.service.IngridientService;
import com.spasov.cookingmvc.service.RecipeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Set;

@Configuration
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(RecipeService recipeService, IngridientService ingridientService) {
        return args -> {
            Ingridient pomidor = new Ingridient();
            pomidor.setName("Pomidor");
            ingridientService.save(pomidor);

            Ingridient cucumber = new Ingridient();
            cucumber.setName("Cucumber");
            ingridientService.save(cucumber);

            Ingridient cheese = new Ingridient();
            cheese.setName("Cheese");
            ingridientService.save(cheese);

            Ingridient sauce = new Ingridient();
            sauce.setName("Sauce");
            ingridientService.save(sauce);

            Ingridient broad = new Ingridient();
            broad.setName("Broad");
            ingridientService.save(broad);

            Ingridient meat = new Ingridient();
            meat.setName("Meat");
            ingridientService.save(meat);

            Recipe simpleSandwich = new Recipe();
            simpleSandwich.setName("Simple Sandwich");
            simpleSandwich.setIngridients(Set.of(meat, broad));
            recipeService.save(simpleSandwich);

            Recipe cheeseSandwich = new Recipe();
            cheeseSandwich.setName("Cheese Sandwich");
            cheeseSandwich.setIngridients(Set.of(cheese, broad));
            recipeService.save(cheeseSandwich);

            Recipe maximumSandwich = new Recipe();
            maximumSandwich.setName("Maximum Sandwich");
            maximumSandwich.setIngridients(Set.of(cheese, broad, meat, sauce, cucumber, pomidor));
            recipeService.save(maximumSandwich);

            Recipe veganSandwich = new Recipe();
            veganSandwich.setName("Vegan Sandwich");
            veganSandwich.setIngridients(Set.of(cucumber, pomidor, broad));
            recipeService.save(veganSandwich);
        };
    }
}
