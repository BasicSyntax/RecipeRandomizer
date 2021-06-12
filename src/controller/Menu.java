package controller;

import view.View;
import view.Functions;

import static java.lang.System.out;

import java.util.Scanner;

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
			
			if(s.equalsIgnoreCase("recipe")) {
				funcConsole.recipe();
				System.out.println("RECIPE : COMING SOON");
				
			} else if(s.equalsIgnoreCase("add")) { 
				funcConsole.add();
				System.out.println("ADD : COMING SOON");
				
			} else if(s.equalsIgnoreCase("delete")) { 
				funcConsole.delete();
				System.out.println("DELETE : COMING SOON");
				
			} else if(s.equalsIgnoreCase("help")) { 
				funcConsole.help();
				
			} else if(s.equalsIgnoreCase("exit")) { 
				funcConsole.exit();
				
			} else if(s.equalsIgnoreCase("dev")) { 
				funcConsole.dev();
				System.out.println("DEV : COMING SOON");
				
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
