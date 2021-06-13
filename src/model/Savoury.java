package model;

import java.util.ArrayList;
import java.util.List;

public class Savoury extends Product {

	// Class variables
	private String name;
	private List<String> listOfIngredients;
	
	// Constructors
	public Savoury() {
		this.setName("Unnamed");
		listOfIngredients = new ArrayList<>();
	}
	
	public Savoury(String name) {
		if(name.isBlank()) this.setName("Unnamed");
		else this.setName(name);
		listOfIngredients = new ArrayList<>();
		
	}
	
	public Savoury(String name, int numOfIngredients) {
		if(name.isBlank()) this.setName("Unnamed");
		else this.setName(name);
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
