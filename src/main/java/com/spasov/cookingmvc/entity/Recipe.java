package com.spasov.cookingmvc.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany
    @JoinTable(
            name = "recipe_ingridient",
            joinColumns = {@JoinColumn(name = "recipe_id")},
            inverseJoinColumns = {@JoinColumn(name = "ingridient_id")}
    )
    private Set<Ingridient> ingridients;

    public Recipe() {}

    public Recipe(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Ingridient> getIngridients() {
        return ingridients;
    }

    public void setIngridients(Set<Ingridient> ingridients) {
        this.ingridients = ingridients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return Objects.equals(id, recipe.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
