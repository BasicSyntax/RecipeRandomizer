package view;

import static java.lang.System.out;
import java.util.concurrent.TimeUnit;

public class View {

	/*
	 * Method to run once at the start
	 * as an introduction to the program 
	 * TODO uncomment the pause to allow program to run smoother
	 * TODO once finished
	 */
	public void onStart() throws InterruptedException {
		out.println("Hello and welcome to the Recipe Randomizer");
		out.println();
//		TimeUnit.SECONDS.sleep(2);
		out.println("Within this program you are able to : ");
//		TimeUnit.SECONDS.sleep(1);
		out.println("--> adding and deleting recipes");
//		TimeUnit.SECONDS.sleep(1);
		out.println("--> printing out all saved recipes");
//		TimeUnit.SECONDS.sleep(1);
		out.println("--> and of course generating a random recipe");
//		TimeUnit.SECONDS.sleep(1);
		out.println();
		out.println("Please choose one of the following functions you would like to use.");
//		TimeUnit.SECONDS.sleep(1);
		out.println();
	}
	
	/*
	 * error messages if command is not valid
	 */
	public void error() {
		out.println("Error, not valid syntax");
		out.println();
		out.println("Please only enter one of the following: ");
		out.println("-> Recipe");
		out.println("-> add");
		out.println("-> delete");
		out.println("-> help");
		out.println("-> exit");
		out.println("-> dev");

	}
	
}
