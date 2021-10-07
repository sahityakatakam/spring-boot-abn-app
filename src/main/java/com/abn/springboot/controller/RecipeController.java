package com.abn.springboot.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.abn.springboot.model.Recipe;
import com.abn.springboot.payload.request.RecipeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.abn.springboot.repository.RecipeRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/food")
public class RecipeController {

	@Autowired
	RecipeRepository recipeRepository;

	@GetMapping("/recipes")
	public ResponseEntity<List<Recipe>> getAllRecipes() {
		try {
			List<Recipe> recipes = new ArrayList<Recipe>();

			System.out.println("Fetching data from the DB");
			recipeRepository.findAll().forEach(recipes::add);

			if (recipes.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(recipes, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("Exception: " + e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/recipe")
	public ResponseEntity<Recipe> createRecipe(@RequestBody RecipeRequest recipe) {
		try {
			Recipe recipeData = Recipe.builder().dateTime(String.valueOf(new Date(System.currentTimeMillis())))
					.typeOfDish(recipe.getTypeOfDish())
					.servedfor(recipe.getServedfor())
					.ingredients(recipe.getIngredients())
					.instructions(recipe.getInstructions()).build();
			Recipe recipeDtls = recipeRepository
					.save(recipeData);
			return new ResponseEntity<>(recipeDtls, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/recipe/{id}")
	public ResponseEntity<Recipe> updateRecipe(@PathVariable("id") long id, @RequestBody RecipeRequest recipe) {
		Optional<Recipe> recipeData = recipeRepository.findById(id);

		if (recipeData.isPresent()) {
			Recipe recipeDtls = recipeData.get();
			recipeDtls.setTypeOfDish(recipe.getTypeOfDish());
			recipeDtls.setServedfor(recipe.getServedfor());
			recipeDtls.setIngredients(recipe.getIngredients());
			recipeDtls.setInstructions(recipe.getInstructions());
			return new ResponseEntity<>(recipeRepository.save(recipeDtls), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/recipe/{id}")
	public ResponseEntity<HttpStatus> deleteRecipe(@PathVariable("id") long id) {
		try {
			recipeRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
