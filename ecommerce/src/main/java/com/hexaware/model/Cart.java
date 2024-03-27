package com.hexaware.model;

public class Cart {
	public int cart_id;
	public int customer_id;
	public int product_id;
	public int quantity;
	
	public int getCart_id() {
		return cart_id;
	}
	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
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
	public Cart(int cart_id, int customer_id, int product_id, int quantity) {
		super();
		this.cart_id = cart_id;
		this.customer_id = customer_id;
		this.product_id = product_id;
		this.quantity = quantity;
	}
	public Cart() {
		super();
	}
	@Override
	public String toString() {
		return "Cart [cart_id=" + cart_id + ", customer_id=" + customer_id + ", product_id=" + product_id
				+ ", quantity=" + quantity + "]";
	}
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void displayCart() {
		// TODO Auto-generated method stub
		
	}
	
	

}
