package guru.springframework.recipeapp.services;


import guru.springframework.recipeapp.models.Recipe;
import guru.springframework.recipeapp.models.repositories.RecipeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RecipeService implements RecipeRepository {

    @Override
    public <S extends Recipe> S save(S s) {
        return null;
    }

    @Override
    public <S extends Recipe> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Recipe> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Recipe> findAll() {
        return null;
    }

    @Override
    public Iterable<Recipe> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Recipe recipe) {

    }

    @Override
    public void deleteAll(Iterable<? extends Recipe> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
