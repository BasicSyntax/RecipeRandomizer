package controller;

import model.Food;

import java.util.ArrayList;
import java.util.List;
import model.Drink;
import model.Product;

public class Control {

	/*
	 * encapsulated objects
	 */
	
	private static Food f = new Food();
	private static Drink d = new Drink();
	
	private static List<Product> listOfProducts = new ArrayList<>();
	
	/*
	 *  TODO factory method for products
	 */
	
//	public factoryMethod() {}
	
	/*
	 *  getter and setter
	 */
	public Food getFood() {
		return f;
	}
	
	public Drink getDrink() {
		return d;
	}
	
	public void setFood(String f) {
		listOfProducts.add(new Food());
	}
	
	public void setDrink() {
		listOfProducts.add(new Drink());

	}

}
