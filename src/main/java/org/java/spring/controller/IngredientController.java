package org.java.spring.controller;

import java.util.List;

import org.java.spring.db.pojo.Ingredient;
import org.java.spring.db.serv.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

@Controller
public class IngredientController {

	@Autowired
	private IngredientService ingredientService;
	
	@GetMapping("/ingredients")
	public String getIngredients(Model model) {
		
		List<Ingredient> ingredients = ingredientService.findAll();
		
		model.addAttribute("ingredients", ingredients);
		
		return "ingredients";
	}
	
	@GetMapping("/ingredients/create")
	public String createIngredient(Model model) {
		
		Ingredient ingredient = new Ingredient();
		
		model.addAttribute("ingredient", ingredient);
		
		return "ingredient-form";
	}
	@PostMapping("/ingredients/create")
	public String storeIngredient(Model model, @Valid @ModelAttribute Ingredient ingredient, BindingResult bindingResult) {
		
		return saveIngredient(model, ingredient, bindingResult);
	}
	
	@PostMapping("/ingredients/delete/{id}")
	public String deleteIngredient(@PathVariable int id) {
		
		Ingredient ingredient = ingredientService.findById(id);
		ingredientService.delete(ingredient);
		
		System.out.println(ingredient);
		
		return "redirect:/";
	}
	
	private String saveIngredient(Model model, @Valid @ModelAttribute Ingredient ingredient, BindingResult bindingResult) {
		
		System.out.println("Ingrediente:\n" + ingredient);
		System.out.println("\n---------------\n");
		System.out.println("Error:\n" + bindingResult);
		
		if (bindingResult.hasErrors()) {
			
			System.out.println(bindingResult);
			
			model.addAttribute("ingredient", ingredient);
			return "ingredient-form";
		}
		
		ingredientService.save(ingredient);
		
		return "redirect:/";
	}
}
