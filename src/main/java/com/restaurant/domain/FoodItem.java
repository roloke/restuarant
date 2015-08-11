package com.restaurant.domain;

import java.math.BigDecimal;

public class FoodItem {

	//orm
	private long id;
	private long version;
	
	//attrbutes
	private String name;
	private String ingredients;
	private BigDecimal cost;
	
	
	public FoodItem(String name, String ingredients, BigDecimal cost) {
		super();
		this.name = name;
		this.ingredients = ingredients;
		this.cost = cost;
	}	
	
	public FoodItem(long id, long version, String name, String ingredients,
			BigDecimal cost) {
		super();
		this.id = id;
		this.version = version;
		this.name = name;
		this.ingredients = ingredients;
		this.cost = cost;
	}



	public String getName() {
		return name;
	}
	public String getIngredients() {
		return ingredients;
	}
	public BigDecimal getCost() {
		return cost;
	}

	public long getId() {
		return id;
	}

	public long getVersion() {
		return version;
	}	
	
}
