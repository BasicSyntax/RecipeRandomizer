package controller;

import static java.lang.System.out;

import java.util.Scanner;

import view.Functions;
import view.View;

/*
 * Menu is created as a Singleton 
 * to enforce that only one instance of the run() occurs
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
			viewConsole.commands();
			isRunning = true;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		while(isRunning == true) {
			out.println();
			out.print("--> ");
			s = sc.next();
			
			if(s.equalsIgnoreCase("G")) {
				funcConsole.generate();
				
			} else if(s.equalsIgnoreCase("A")) { 
				System.out.print("Please choose Sweet or Savoury: ");
				String recipeType = sc.next();
				
//				if(recipeType.equalsIgnoreCase("SWEET")) {
					funcConsole.addProduct(recipeType, sc);
					
//				} else if (recipeType.equalsIgnoreCase("SAVOURY")) {
//					funcConsole.addSavoury();
//				}
				
			} else if(s.equalsIgnoreCase("E")) { 
				funcConsole.exit();
				
			} else if(s.equalsIgnoreCase("D")) { 
				funcConsole.dev();
				
			} else if(s.equalsIgnoreCase("PRINTALL"))  {
				funcConsole.allRecipes();
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
	
	/*
	 * encapsulated method to terminate while loop and let thread end
	 */
	public void stopRunning() {
		menu.isRunning = false;
	}
}
