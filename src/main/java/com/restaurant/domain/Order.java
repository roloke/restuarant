package com.restaurant.domain;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="ORDERS")
@JsonInclude(Include.NON_NULL)
public class Order implements RestaurantEntity{

	@Id
	@Column(name="ORDER_ID")
	@JsonIgnore
	private long orderId;
	
	@Version
	@JsonIgnore
	private long version;
	
	@Column(name="ORDER_NO")
	private String orderNo;
	
	@OneToMany
	@JoinTable(name="ORDER_FOOD_ITEM_MAP",
	joinColumns= @JoinColumn(name = "ORDER_ID"),
	inverseJoinColumns =  @JoinColumn(name = "ITEM_ID"))
	private List<FoodItem> foodItems;
	
	@Column(name="TOTAL_AMOUNT")
	private BigDecimal totalAmount;
	
	public Order() {
		super();
	}

	public Order(@JsonProperty("orderNo")String orderNo, @JsonProperty("foodItems")List<FoodItem> foodItems,
			@JsonProperty("totalAmount")BigDecimal totalAmount) {
		super();
		this.orderNo = orderNo;
		this.foodItems = foodItems;
		this.totalAmount = totalAmount;
	}

	public String getOrderNo() {
		return orderNo;
	}
		
	public List<FoodItem> getFoodItems() {
		return foodItems;
	}
		
	public BigDecimal getTotalAmount() {		
		return totalAmount;
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

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	public Order generateTotalAmount() {
		this.totalAmount = new BigDecimal(0);
		for (FoodItem item : this.foodItems) {
			totalAmount = totalAmount.add(item.getCost());
		}
		return this; 
	}
}
