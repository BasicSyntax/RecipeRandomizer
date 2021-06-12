package view;

import static java.lang.System.out;
import controller.Menu;

public class Functions {
	
	
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
		out.println("RecipeRandomizer, Made by Beaumont Spinks using Java 11");
		out.println();
		out.println("Github link: https://github.com/BasicSyntax/RecipeRandomizer");
		out.println();
		out.println("LinkedIn profile: https://www.linkedin.com/in/beauspinks/");
		out.println();
	}
}
