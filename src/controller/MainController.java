package controller;

import static java.lang.System.out;

import java.util.Scanner;

import view.Functions;
import view.MainView;

/*
 * Menu is created as a Singleton 
 * to enforce that only one instance of the run() occurs
 * Implements Runnable to operate the run function on a thread
 */
final public class MainController implements Runnable {

	// encapsulated class variables
	private static MainController menu;
	private boolean isRunning;
	private Scanner sc = new Scanner(System.in);
	private MainView viewConsole = new MainView();
	private Functions funcConsole = new Functions();
	private String s;
	
	// private constructor
	private MainController() {
		
	}
	
	// getter for Singleton instance
	public static MainController getInstance() {
        if(menu == null) {
            menu = new MainController();
            
        }
        return menu;
        
    }
	
	// run method, keeps program alive while isRunning is true
	public void run() {
		try {
			viewConsole.onStart();
			viewConsole.commands();
			isRunning = true;
			
		} catch (InterruptedException e) {
			e.printStackTrace();
			
		}
		
		while(isRunning == true) {
			out.println();
			out.print("--> ");
			s = sc.nextLine();
			
			if(s.equalsIgnoreCase("G")) {
				System.out.print("Please choose vegetarian, vegan or any (press \"C\" to cancel)  : ");
				String recipeType = sc.nextLine().toUpperCase();
				if(recipeType.equals("VEGETARIAN")) {
					funcConsole.generate("VEGETARIAN");
					
				} else if (recipeType.equals("VEGAN")) {
					funcConsole.generate("VEGAN");
					
				} else if (recipeType.equals("ANY")) {
					funcConsole.generate("ANY");
					
				} else if(recipeType.equalsIgnoreCase("C")) {
					System.out.println();
					viewConsole.commands();
				} else {
					viewConsole.error();
				}
				
			} else if(s.equalsIgnoreCase("A")) { 
				System.out.print("Please choose vegetarian, vegan or any (press \"C\" to cancel)  : ");
				String recipeType = sc.nextLine();
				if(recipeType.equalsIgnoreCase("VEGETARIAN") || recipeType.equalsIgnoreCase("VEGAN") || recipeType.equalsIgnoreCase("ANY")) {
					funcConsole.addProduct(recipeType, sc, viewConsole);
					
				} else if(recipeType.equalsIgnoreCase("C")) {
					System.out.println();
					viewConsole.commands();
				} else {
					viewConsole.error();
				}
				
			} else if(s.equalsIgnoreCase("E")) { 
				funcConsole.exit();
				
			} else if(s.equalsIgnoreCase("D")) { 
				funcConsole.dev();
				
			} else if(s.equalsIgnoreCase("PRINTALL"))  {
				funcConsole.allRecipes();
				
			} else if(s.equalsIgnoreCase("PRINTALLWI"))  {
				funcConsole.allRecipesAndIngredients();
				
			} else {
				viewConsole.error();
				
			}
			
		}	
		
		sc.close();
		System.out.println();
		System.out.println("Terminating ...");
		System.out.println();
		System.out.println("I Hope you liked my work !");
		System.out.println();
		System.out.println("Goodbye !");
		
	}
	
	// encapsulated method to terminate while loop and let thread end
	public void stopRunning() {
		menu.isRunning = false;
		
	}
	
}
