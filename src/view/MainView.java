package view;

import static java.lang.System.out;
import java.util.concurrent.TimeUnit;

public class MainView {

	/*
	 * Method to run once at the start
	 * as an introduction to the program 
	 * TODO uncomment the pause to allow program to run smoother
	 * TODO once finished
	 */
	public void onStart() throws InterruptedException {
		out.println("Hello and welcome to the Recipe Randomizer");
		out.println();
		TimeUnit.SECONDS.sleep(1);
		out.println("Please choose one of the following functions you would like to use.");
		TimeUnit.SECONDS.sleep(1);
		
	}
	
	/** 
	  * method which will run after the introduction
	  */
	public void commands() {
		out.println("to generate a random recipe please enter : \"G\"");
		out.println("to add a recipe please enter : \"A\"");
		out.println("to exit out of the program please enter : \"E\"");
		out.println();
		out.println("to see more details about the amazing developer ");
		out.println("with links to GitHub and LinkedIn, please enter : \"D\"");
		
	}
	
	// error messages if command is not valid
	public void error() {
		out.println("Error, not valid syntax");
		out.println();
		out.println("Please only enter one of the following: ");
		out.println("-> \"G\" for Generate");
		out.println("-> \"A\" for Add");
		out.println("-> \"E\" for Exit");
		out.println("-> \"D\" for Developer");

	}
	
}
