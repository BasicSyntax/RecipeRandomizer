package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.Savoury;
import model.Sweet;
import model.Product;

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
	
	// Factory method to create Product subclasses 
	public Product newProduct(String productType, String recipeName){  
		if(productType == null){  
			return null; 
			
		} 
		
		if(productType.equalsIgnoreCase("SWEET")) {  
			var sweetFood = new Sweet(recipeName); 
			listOfProducts.add(sweetFood);
			return sweetFood;
			
		} else if(productType.equalsIgnoreCase("SAVOURY")) {  
			var savouryFood = new Savoury(recipeName); 
			listOfProducts.add(savouryFood);
			return savouryFood;
			
		}  
		
		return null;  
	}
	
	 // getters and setters
	public Product getProduct() {
		if(listOfProducts.size() <= 0) return null;
		Random rand = new Random();
		int pos = rand.nextInt(listOfProducts.size());
		return listOfProducts.get(pos);
		
	}
	
	// secret method to print all recipes
	public void printAllRecipes() {
		listOfProducts.stream().forEach(e -> System.out.println("Recipe : " + e.getName()));
		
	}
	
	public void printAllRecipesAndIngredients() {
		listOfProducts.stream().forEach(e -> {
			System.out.println("Recipe : " + e.getName());
			e.getIng();
			System.out.println();
		});
		
	}
	
	// method with details on product to load at initialisation
	private void loadRecipes() {
		var butterChicken = newProduct("Savoury", "Butter Chicken"); 
		butterChicken.addIng("Chicken");
		butterChicken.addIng("Butter");
		butterChicken.addIng("Ghee");
		butterChicken.addIng("Oil");
		butterChicken.addIng("Cashew");
		
		var pancake = newProduct("Sweet", "Pancake"); 
		pancake.addIng("Milk");
		pancake.addIng("Butter");
		pancake.addIng("Flour");
		pancake.addIng("Baking Powder");
		
		var omelette = newProduct("Savoury", "Omelette"); 
		omelette.addIng("Egg");
		omelette.addIng("Salt");
		omelette.addIng("Butter");
		
		var caesarSalad = newProduct("Savoury", "Caesar Salad"); 
		caesarSalad.addIng("Chicken");
		caesarSalad.addIng("Salad");
		
		var cheeseCake = newProduct("Sweet", "Cheesecake"); 
		cheeseCake.addIng("Butter");
		cheeseCake.addIng("Digestive Biscuits");
		cheeseCake.addIng("Soft Cheese");
		cheeseCake.addIng("Strawberries");
		
	}
	
}
