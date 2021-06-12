package model;

public class Launcher {

	public static void main(String[] args) {
		try{
			controller.Menu menu = new controller.Menu();
			menu.run();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception occured : " + e);
		}

	}

}
