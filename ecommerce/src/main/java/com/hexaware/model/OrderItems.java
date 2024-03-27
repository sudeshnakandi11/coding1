package com.hexaware.model;

public class OrderItems {
	public int order_item_id;
	public int order_id;
	public int product_id;
	public int quantity;
	public int getOrder_item_id() {
		return order_item_id;
	}
	public void setOrder_item_id(int order_item_id) {
		this.order_item_id = order_item_id;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public OrderItems(int order_item_id, int order_id, int product_id, int quantity) {
		super();
		this.order_item_id = order_item_id;
		this.order_id = order_id;
		this.product_id = product_id;
		this.quantity = quantity;
	}
	public OrderItems() {
		super();
	}
	
	
	
}
