package view;

import static java.lang.System.out;

import java.util.InputMismatchException;
import java.util.Scanner;

import controller.ProductFactory;
import controller.Menu;
import model.Product;

public class Functions {
	
	/*
	 * Generate recipe from  collection
	 */
	public void generate() {
		var recipe = new ProductFactory().getProduct();
		if(recipe != null) {
			out.println("Name : " + recipe.getName());
			recipe.getIng();
		} else {
			System.out.println("ERROR: No recipes in the system.");
		}
	}
	
	/*
	 * add food
	 */
	public void addProduct(String productType, Scanner sc) {
//		Scanner scSweet = new Scanner(System.in);
		String recipeName = "";
		Product sweetFood = null;
		int numOfIngredients = 0;
		
		try {
			System.out.print("What is the name of your dish? : ");
			recipeName = sc.next();
			
			sweetFood = new ProductFactory().newProduct(productType, recipeName);
			
			System.out.print("How many ingredients are included? : ");
			numOfIngredients = sc.nextInt();
		
			for(int i = 0; i < numOfIngredients; i++) {
				System.out.print("Next Ingredient : ");
				String ing = sc.next();
				sweetFood.addIng(ing);
			}
		} catch (InputMismatchException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		sc.close();
		System.out.println("Your recipe " + recipeName + ", has been added.");
	}
	
//	public void addSavoury() {
//		Scanner scSavoury = new Scanner(System.in);
//		String recipeName = "";
//		Product savouryfood = null;
//		int numOfIngredients = 0;
//		
//		try {
//			System.out.print("What is the name of your dish? : ");
//			recipeName = scSavoury.next();
//			
//			savouryfood = new GetProductFactory().newProduct("Savoury", recipeName);
//			
//			System.out.print("How many ingredients are included? : ");
//			numOfIngredients = scSavoury.nextInt();
//		
//			for(int i = 0; i < numOfIngredients; i++) {
//				System.out.print("Next Ingredient : ");
//				String ing = scSavoury.next();
//				savouryfood.addIng(ing);
//			}
//		} catch (InputMismatchException e) {
//			e.printStackTrace();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		scSavoury.close();
//		System.out.println("Your recipe " + recipeName + ", has been added.");
//		System.out.println();
//	}
	
	/*
	 * essentially hidden from user 
	 * print all recipe function, just recipe names though
	 * TODO only accessible by admin user
	 */
	public void allRecipes() {
		new ProductFactory().printAllRecipes();
	}
	/*
	 * Termination function, 
	 */
	public void exit() {
		Menu.getInstance().stopRunning();
	}
	
	/*
	 * Information about me as a Java Developer
	 */
	public void dev() {
		out.println("RecipeRandomizer, Made by Beaumont Spinks using Java 11");
		out.println();
		out.println("Github link: https://github.com/BasicSyntax/RecipeRandomizer");
		out.println();
		out.println("LinkedIn profile: https://www.linkedin.com/in/beauspinks/");
	}
}
