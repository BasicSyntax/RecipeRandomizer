package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GetProductFactory {

	/*
	 * encapsulated static list of recipes
	 * TODO transferred to an postgreSQL database
	 */
	
	private static List<Product> listOfProducts = new ArrayList<>();
	
	/*
    * Factory method to create Product subclasses 
    */
	public Product getProduct(String productType, String recipeName){  
		if(productType == null){  
			return null; 
			
		} 
		
		if(productType.equalsIgnoreCase("FOOD")) {  
			var food = new Food(recipeName); 
			listOfProducts.add(food);
			return food;
			
		} else if(productType.equalsIgnoreCase("DRINK")) {  
			var drink = new Drink(recipeName); 
			listOfProducts.add(drink);
			return drink;
			
		}  
		
		return null;  
	}
	
	/*
	 *  getter and setter
	 */
	public Product getProduct() {
		if(listOfProducts.size() <= 0) return null;
		Random rand = new Random();
		int pos = rand.nextInt(listOfProducts.size());
		return listOfProducts.get(pos);
	}
	
	public void setFood(String f) {
		listOfProducts.add(new Food());
	}
	
	public void setDrink() {
		listOfProducts.add(new Drink());

	}
}
