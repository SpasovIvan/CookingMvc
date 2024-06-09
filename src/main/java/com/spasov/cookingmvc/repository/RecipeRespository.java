package com.spasov.cookingmvc.repository;

import com.spasov.cookingmvc.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRespository extends JpaRepository<Recipe, Long> {
}
