package controller;

import static java.lang.System.out;

import java.util.Scanner;

import model.GetProductFactory;
import model.Product;
import view.Functions;
import view.View;

/*
 * Menu is created as a Singleton
 * Implements Runnable to operate the run function on a thread
 */
final public class Menu implements Runnable {

	/*
	 * encapsulated class variables
	 */
	private static Menu menu;
	private boolean isRunning;
	private Scanner sc = new Scanner(System.in);
	private View viewConsole = new View();
	private Functions funcConsole = new Functions();
	private String s;
	
	/*
	 * private constructor
	 */
	private Menu() {
		
	}
	
	/*
	 * getter for Singleton instance
	 */
	public static Menu getInstance() {
        if(menu == null) {
            menu = new Menu();
        }
        
        return menu;
    }
	
	/*
	 * run method, keeps program alive while isRunning is true
	 */
	public void run() {
		try {
			viewConsole.onStart();
			funcConsole.help();
			isRunning = true;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		while(isRunning == true) {
			out.print("--> ");
			s = sc.next();
			
			if(s.equalsIgnoreCase("RECIPE")) {
				Product recipe = new GetProductFactory().getProduct();
				if(recipe != null) {
					out.println("Recipe : " + recipe.getName());
					recipe.getIng();
				} else {
					System.out.println("ERROR: No recipes in the system.");
				}
				
			} else if(s.equalsIgnoreCase("ADD")) { 
				System.out.print("Please specify a Food or Drink: ...(Hint: choose food) : ");
				String recipeType = sc.next();
				
				if(recipeType.equalsIgnoreCase("FOOD")) {
					System.out.print("What is the name of your dish? : ");
					String recipeName = sc.next();
					
					var food = new GetProductFactory().getProduct(recipeType, recipeName);
					
					System.out.print("How many ingredients are included? : ");
					int numOfIngredients = sc.nextInt();
					
					for(int i = 0; i < numOfIngredients; i++) {
						System.out.print("Next Ingredient : ");
						String ing = sc.next();
						food.addIng(ing);
					}
					
					System.out.println("Your recipe " + recipeName + ", has been added.");
					System.out.println();
					
				} else if (recipeType.equalsIgnoreCase("DRINK")) {
					//
				}
				
			} else if(s.equalsIgnoreCase("DELETE")) { 
				funcConsole.delete();
				System.out.println("DELETE : COMING SOON");
				
			} else if(s.equalsIgnoreCase("HELP")) { 
				funcConsole.help();
				
			} else if(s.equalsIgnoreCase("EXIT")) { 
				funcConsole.exit();
				
			} else if(s.equalsIgnoreCase("DEV")) { 
				funcConsole.dev();
				
			} else {
				viewConsole.error();
			}
		}	
		
		System.out.println();
		System.out.println("Terminating ...");
		System.out.println();
		System.out.println("I Hope you liked my work !");
		System.out.println();
		System.out.println("Goodbye !");
	}
	
	/*
	 * encapsulated method to terminate while loop and let thread end
	 */
	public void stopRunning() {
		menu.isRunning = false;
	}
}
