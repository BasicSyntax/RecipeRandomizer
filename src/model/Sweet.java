package model;

import java.util.ArrayList;
import java.util.List;

public class Sweet extends Product {

	private String name;
	private List<String> listOfIngredients;
	
	public Sweet() {
		this.setName("Unnamed");
		listOfIngredients = new ArrayList<>();
	}
	
	public Sweet(String name) {
		this.setName(name);
		listOfIngredients = new ArrayList<>();
		
	}
	
	public Sweet(String name, int numOfIngredients) {
		this.setName(name);
		listOfIngredients = new ArrayList<>(numOfIngredients);
		
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	protected void setName(String name) {
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
			System.out.println(( i + 1 ) + ") " + this.listOfIngredients.get(i));
		}
	}
}
