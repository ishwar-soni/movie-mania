package com.upgrad.moviemana.repositories;

import com.upgrad.moviemana.domain.Ingredient;

public interface IngredientRepository {

	Iterable<Ingredient> findAll();
	Ingredient findOne(String id);
	Ingredient save(Ingredient ingredient);
}
