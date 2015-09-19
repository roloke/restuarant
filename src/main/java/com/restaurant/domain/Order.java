package com.restaurant.domain;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@JsonInclude(Include.NON_NULL)
public class Order {

	private String orderNo;
	private List<FoodItem> foodItems;
	private BigDecimal totalAmount;
	
	public String getOrderNo() {
		return orderNo;
	}
		
	public List<FoodItem> getFoodItems() {
		return foodItems;
	}
		
	public BigDecimal getTotalAmount() {
		BigDecimal total = new BigDecimal(0);
		for (FoodItem item : this.foodItems) {
			total = total.add(item.getCost());
		}
		return total;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public void setFoodItems(List<FoodItem> foodItems) {
		this.foodItems = foodItems;
	}

	@Override
	public String toString() {
		return "Order [orderNo=" + orderNo + ", foodItems=" + foodItems
				+ ", totalAmount=" + totalAmount + "]";
	}
	
}
