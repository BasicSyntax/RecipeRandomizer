package model;

import java.util.List;

public class Drink extends Product {

	private String name;
	private List<String> listOfIngredients;
	
	public Drink() {
		this.setName("Unnamed");
	}
	
	public Drink(String s) {
		this.setName(s);
		
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public void addIng(String ingredient) {
		this.listOfIngredients.add(ingredient);
	}
	
	@Override
	public void getIng() {
		int len = this.listOfIngredients.size();
		
		for (int i = 0; i < len; i++) {
			System.out.println(i + ") " + this.listOfIngredients.get(i));
		}
	}
}
