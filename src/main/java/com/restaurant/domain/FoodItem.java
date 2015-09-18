package com.restaurant.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class FoodItem {

	//attrbutes
	private String name;
	private List<String> ingredients;
	private BigDecimal cost;
	
	public FoodItem(String name, List<String> ingredients, BigDecimal cost) {
		super();
		this.name = name;
		this.ingredients = ingredients;
		this.cost = cost;
	}

	public String getName() {
		return name;
	}
	public BigDecimal getCost() {
		return cost;
	}
	public List<String> getIngredients() {
		if(ingredients == null || ingredients.isEmpty()) {
			return new ArrayList<String>();
		}
		return ingredients;
	}

	
	public void setIngredients(List<String> ingredients) {
		this.ingredients = ingredients;
	}
}
