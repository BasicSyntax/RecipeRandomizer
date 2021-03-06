package view;

import static java.lang.System.out;

import java.util.InputMismatchException;
import java.util.Scanner;

import controller.ProductFactory;
import controller.MainController;
import model.Product;

public class Functions {
	
	// Generate recipe from collection
	public void generate(String recipeType) {
		var recipe = new ProductFactory().getProduct(recipeType);
		
		if(recipe != null) {
			out.println("Name : " + recipe.getName());
			recipe.getIng();
			
		} else {
			System.out.println("ERROR: No recipes in the system.");
			
		}
	
	}
	
	// add food
	public void addProduct(String productType, Scanner sc, MainView viewConsole) {
		String recipeName = "";
		Product sweetFood = null;
		
		while(true) {
			try {
				System.out.print("What is the name of your dish? (press \"C\" to cancel) : ");
				recipeName = sc.nextLine();
				
				if(recipeName.equalsIgnoreCase("C")) {
					System.out.println();
					viewConsole.commands();
					break;
				} 
				
				sweetFood = new ProductFactory().newProduct(productType, recipeName);
				
				System.out.print("Type out all the ingredients (press \"C\" to cancel) : ");
				String stringOfIng = sc.nextLine();
				
				if(stringOfIng.equalsIgnoreCase("C")) {
					System.out.println();
					viewConsole.commands();
					break;
				} 
				
				String[] listOfIng = stringOfIng.split( "[\\s,]+" );
	
				for(int i = 0; i < listOfIng.length; i++) {
					String ing = listOfIng[i];
					sweetFood.addIng(ing);
					
				}
			} catch (InputMismatchException e) {
				e.printStackTrace();
				
			} catch (Exception e) {
				e.printStackTrace();
				
			}
			
			System.out.println("Your recipe " + recipeName + ", has been added.");
			break;
		}
	}
	
	/*
	 * essentially hidden from user 
	 * print all recipe function, just recipe names though
	 * TODO only accessible by admin user
	 */
	public void allRecipes() {
		new ProductFactory().printAllRecipes();
		
	}
	
	/*
	 * essentially hidden from user 
	 * print all recipe function, just recipe names though
	 * TODO only accessible by admin user
	 */
	public void allRecipesAndIngredients() {
		new ProductFactory().printAllRecipesAndIngredients();
		
	}
	
	// Termination function, 
	public void exit() {
		MainController.getInstance().stopRunning();
		
	}
	
	// Information about me as a Java Developer
	public void dev() {
		out.println("RecipeRandomizer, Made by Beaumont Spinks using Java 11");
		out.println();
		out.println("Github link: https://github.com/BasicSyntax/RecipeRandomizer");
		out.println();
		out.println("LinkedIn profile: https://www.linkedin.com/in/beauspinks/");
		
	}
	
}
