package model;

import controller.Menu;

/**
 * @author Beaumont Spinks, 2021
 *
 */
public class Main {

	/*
	 * Main method of Main class, very confusing
	 * calls Menu controller to run program
	 */
	public static void main(String[] args) {
		try{
			Menu.getInstance().run();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception occured : " + e);
		}
	}

}
