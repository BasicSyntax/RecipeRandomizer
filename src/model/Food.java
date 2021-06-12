package model;

public class Food extends Product {

	private static String name;
	
	public Food() {
		Food.setName("Unnamed");
	}
	
	public Food(String s) {
		Food.setName(s);
		
	}

	public static String getName() {
		return name;
	}

	public static void setName(String name) {
		Food.name = name;
	}
}
