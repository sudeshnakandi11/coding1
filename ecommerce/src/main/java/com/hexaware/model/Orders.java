package com.hexaware.model;

import java.sql.Date;

public class Orders {
	public int order_id;
	public int customer_id;
	public Date order_date;
	public int total_price;
	public String shipping_address;
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public Date getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Date date) {
		this.order_date = date;
	}
	public int getTotal_price() {
		return total_price;
	}
	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}
	public String getShipping_address() {
		return shipping_address;
	}
	public void setShipping_address(String shipping_address) {
		this.shipping_address = shipping_address;
	}
	public Orders(int order_id, int customer_id, Date order_date, int total_price, String shipping_address) {
		super();
		this.order_id = order_id;
		this.customer_id = customer_id;
		this.order_date = order_date;
		this.total_price = total_price;
		this.shipping_address = shipping_address;
	}
	public Orders() {
		super();
	}
	@Override
	public String toString() {
		return "Orders [order_id=" + order_id + ", customer_id=" + customer_id + ", order_date=" + order_date
				+ ", total_price=" + total_price + ", shipping_address=" + shipping_address + "]";
	}
	
	

}
