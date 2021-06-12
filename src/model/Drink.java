package model;

public class Drink extends Product {

	private static String name;
	
	public Drink() {
		Drink.setName("Unnamed");
	}
	
	public Drink(String s) {
		Drink.setName(s);
		
	}

	public static String getName() {
		return name;
	}

	public static void setName(String name) {
		Drink.name = name;
	}
}
