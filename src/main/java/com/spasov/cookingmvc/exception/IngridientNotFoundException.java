package com.spasov.cookingmvc.exception;

public class IngridientNotFoundException extends RuntimeException{
    public IngridientNotFoundException(Long id) {
        super("Ingridient with id:" + id + " not found");
    }
}
