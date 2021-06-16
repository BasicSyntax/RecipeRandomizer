package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import model.AnyFood;
import model.Product;
import model.Vegan;
import model.Vegetarian;

public class ProductFactory {

	/*
	 * static initialiser
	 * with the goal of loading recipes once at the start of runtime
	 * list of products needs to be initialised first 
	 */
	static {
		listOfProducts = new ArrayList<>();
		new ProductFactory().loadRecipes();
		
	}
	
	/*
	 * encapsulated static list of recipes
	 * TODO transferred to an postgreSQL database
	 */
	private static List<Product> listOfProducts;
	private static List<Product> selectedProducts;
	
	// Factory method to create Product subclasses 
	public Product newProduct(String productType, String recipeName){  
		if(productType == null){  
			return null; 
			
		} 
		
		if(productType.equalsIgnoreCase("VEGAN")) {  
			var veganFood = new Vegan(recipeName); 
			listOfProducts.add(veganFood);
			return veganFood;
			
		} else if(productType.equalsIgnoreCase("VEGETARIAN")) {  
			var vegetarianFood = new Vegetarian(recipeName); 
			listOfProducts.add(vegetarianFood);
			return vegetarianFood;
			
		}  else if(productType.equalsIgnoreCase("ANY")) {  
			var anyFood = new AnyFood(recipeName); 
			listOfProducts.add(anyFood);
			return anyFood;
			
		}  
		
		return null;  
	}
	
	 // getters and setters
	public Product getProduct(String recipeType) {
		if(recipeType == "VEGETARIAN") {
			selectedProducts = listOfProducts
					.stream()
					.filter(o -> !(o instanceof AnyFood))
					.collect(Collectors.toList());
			
		} else if (recipeType == "VEGAN") {
			selectedProducts = listOfProducts
					.stream()
					.filter(o -> o instanceof Vegan)
					.collect(Collectors.toList());
			
		} else if (recipeType == "ANY") {
			if(listOfProducts.size() <= 0) return null;
			Random rand = new Random();
			return listOfProducts.get( rand.nextInt( listOfProducts.size()));
			
		}
		
		if(selectedProducts.size() <= 0) return null;
		Random rand = new Random();
		return selectedProducts.get( rand.nextInt(selectedProducts.size()));
		
	}
	
	// secret method to print all recipes
	public void printAllRecipes() {
		listOfProducts.stream().forEach(e -> System.out.println("Recipe : " + e.getName()));
		
	}
	
	public void printAllRecipesAndIngredients() {
		listOfProducts.stream().forEach(e -> {
				System.out.println("Recipe : " + e.getName());
				e.getIng();
				
				});
		
	}
	
	// method with details on product to load at initialisation
	private void loadRecipes() {
		var butterChicken = newProduct("Any", "Butter Chicken"); 
		butterChicken.addIng("Chicken");
		butterChicken.addIng("Butter");
		butterChicken.addIng("Ghee");
		butterChicken.addIng("Cashew");
		butterChicken.addIng("Rice");
		
		var caesarSalad = newProduct("Any", "Chicken Caesar Salad"); 
		caesarSalad.addIng("Chicken");
		caesarSalad.addIng("Salad");
		caesarSalad.addIng("Lemon");
		
		var pancake = newProduct("Vegetarian", "Pancake"); 
		pancake.addIng("Milk");
		pancake.addIng("Butter");
		pancake.addIng("Flour");
		pancake.addIng("Baking Powder");
		
		
		var omelette = newProduct("Vegetarian", "Omelette"); 
		omelette.addIng("Egg");
		omelette.addIng("Salt");
		omelette.addIng("Butter");
		
		var cheeseCake = newProduct("Vegetarian", "Cheesecake"); 
		cheeseCake.addIng("Butter");
		cheeseCake.addIng("Digestive Biscuits");
		cheeseCake.addIng("Soft Cheese");
		cheeseCake.addIng("Strawberries");
		
		var sataySweetPotatoCurry = newProduct("Vegan", "Satay Sweet Potato Curry"); 
		sataySweetPotatoCurry.addIng("Peanut Satay");
		sataySweetPotatoCurry.addIng("Sweet Potato");
		sataySweetPotatoCurry.addIng("Spinach");
		sataySweetPotatoCurry.addIng("Coconut Milk");
		sataySweetPotatoCurry.addIng("Rice");

		var falafel = newProduct("Vegan", "Falafel"); 
		falafel.addIng("Chickpeas");
		falafel.addIng("Parsley");
		falafel.addIng("Coriander");
		falafel.addIng("Dill");
		
	}
	
}
