package com.upgrad.moviemana.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.upgrad.moviemana.domain.Ingredient;
import com.upgrad.moviemana.domain.Movie;
import com.upgrad.moviemana.repositories.IngredientRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/search")
@SessionAttributes("order")
public class SearchMovieController {
	
	private final IngredientRepository ingredientRepository;
	
	@Autowired
	public SearchMovieController(IngredientRepository ingredientRepository) {
		this.ingredientRepository = ingredientRepository;
	}
	
	@GetMapping
	public String showSearchPage (Model model) {
		/*
		 * List<Ingredient> ingredients = Arrays.asList(
		 * new Ingredient("GEHR", "Horrer", Ingredient.Type.GENRE),
		 * new Ingredient("GECO", "Comedy", Ingredient.Type.GENRE),
		 * new Ingredient("GETH", "Thriller", Ingredient.Type.GENRE),
		 * new Ingredient("ACSH", "Shahrukh Khan", Ingredient.Type.ACTOR),
		 * new Ingredient("ACSL", "Salman Khan", Ingredient.Type.ACTOR),
		 * new Ingredient("ACAM", "Amir Khan", Ingredient.Type.ACTOR),
		 * new Ingredient("LNEN", "English", Ingredient.Type.LANGUAGE),
		 * new Ingredient("LNHI", "Hindi", Ingredient.Type.LANGUAGE),
		 * new Ingredient("YE20", "2020", Ingredient.Type.YEAR),
		 * new Ingredient("YE19", "2019", Ingredient.Type.YEAR),
		 * new Ingredient("YE18", "2018", Ingredient.Type.YEAR),
		 * new Ingredient("IDHO", "Hollywood", Ingredient.Type.INDUSTRY),
		 * new Ingredient("IDBO", "Bollywood", Ingredient.Type.INDUSTRY) );
		 */
		
		List<Ingredient> ingredients = new ArrayList<>();
		ingredientRepository.findAll().forEach(ingredients::add);
		
		Arrays.asList(Ingredient.Type.values())
			.stream()
			.forEach (type -> model.addAttribute(
						type.toString().toLowerCase(),
						ingredients.stream()
							.filter(ingredient -> ingredient.getType() == type)
							.collect(Collectors.toList())
					));
		
		model.addAttribute("design", new Movie());
		
		return "search";
	}
	
	@PostMapping
	public String processSearch (@Valid Movie design, Errors errors) {
		if (errors.hasErrors()) {
			return "search";
		}
		log.info("Processing search: " + design);
		return "redirect:/orders/current";
	}
}
