package controller;

import static java.lang.System.out;

public class Menu implements Runnable {

	private static boolean isRunning = true;

	public void run() {
		out.println("Hello");
		
		while(isRunning) {
			
			isRunning = false;
			
			out.println("Running...");

		}
		
		out.println("Finished");
		
	}

}
