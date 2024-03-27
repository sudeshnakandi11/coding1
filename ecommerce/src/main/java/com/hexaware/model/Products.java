package com.hexaware.model;

public class Products {
	public int product_id;
	public String name;
	public int price;
	public String description;
	public int stockQuantity;
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getStockQuantity() {
		return stockQuantity;
	}
	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	public Products(int product_id, String name, int price, String description, int stockQuantity) {
		super();
		this.product_id = product_id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.stockQuantity = stockQuantity;
	}
	public Products() {
		super();
	}
	@Override
	public String toString() {
		return "Products [product_id=" + product_id + ", name=" + name + ", price=" + price + ", description="
				+ description + ", stockQuantity=" + stockQuantity + "]";
	}
	
	

}
