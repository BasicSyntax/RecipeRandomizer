package view;

import static java.lang.System.out;
import controller.Menu;

public class Functions {
	
	/*
	 * Random recipe generator
	 */
	public void recipe() {
		//
	}
	
	/*
	 * Recipe add function, will be collection for testing, then perm file 
	 */
	public void add() {
		//
	}
	
	/*
	 * Recipe delete function, will be collection for testing, then perm file
	 */
	public void delete() {
		//
	}
	 
	/** 
	  * method which will run after the introduction
	  * also runs when "help" command is called
	  */
	public void help() {
		out.println("to show all user command please enter : help");
		out.println("to add a recipe please enter : add");
		out.println("to delete a recipe please enter : delete");
		out.println("to generate a random recipe please enter : recipe");
		out.println("to exit out of the program please enter : exit");
		out.println("to see more details from the amazing developer ");
		out.println("with links to GitHub and LinkedIn, please enter : dev");
		out.println();
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
		//
	}
}
