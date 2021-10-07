package com.abn.springboot.repository;

import com.abn.springboot.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;



public interface RecipeRepository extends JpaRepository<Recipe, Long> {

}
