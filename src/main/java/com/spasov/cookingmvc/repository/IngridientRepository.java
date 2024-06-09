package com.spasov.cookingmvc.repository;

import com.spasov.cookingmvc.entity.Ingridient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngridientRepository extends JpaRepository<Ingridient, Long> {
}
