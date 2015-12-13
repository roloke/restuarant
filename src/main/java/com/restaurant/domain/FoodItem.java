package com.restaurant.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name="FOOD_ITEM")
@JsonInclude(Include.NON_NULL)
public class FoodItem implements RestaurantEntity{

	@Id
	@Column(name="ITEM_ID")
	@JsonIgnore
	private long itemId;
	
	@Version
	@JsonIgnore
	private long version;
	
	//attrbutes
	private String name;
	
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(
	        name="INGREDIENTS",
	        joinColumns=@JoinColumn(name="ITEM_ID")
	  )
	private List<String> ingredients;
	
	private BigDecimal cost;

	
	public FoodItem() {
		super();
	}

	@JsonCreator
	public FoodItem(@JsonProperty("name") String name, 
			@JsonProperty("ingredients")List<String> ingredients, 
			@JsonProperty("cost")BigDecimal cost) {
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

	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}
		
}
