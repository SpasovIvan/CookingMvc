package com.spasov.cookingmvc.service;

import com.spasov.cookingmvc.entity.Ingridient;
import com.spasov.cookingmvc.exception.IngridientNotFoundException;
import com.spasov.cookingmvc.repository.IngridientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Service
public class IngridientService {
    @Autowired
    private IngridientRepository ingridientRepository;

    public void save(Ingridient ingridient) {
        ingridientRepository.save(ingridient);
    }

    public List<Ingridient> getAllIngridients() {
        return ingridientRepository.findAll();
    }

    public Ingridient getIngridientById(Long id) {
        return ingridientRepository.findById(id).orElseThrow(()-> new IngridientNotFoundException(id));
    }


}
