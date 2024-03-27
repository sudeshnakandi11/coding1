package com.hexaware.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.hexaware.model.*;
import com.hexaware.dao.*;
import com.hexaware.exception.CustomerNotFoundException;
import com.hexaware.exception.ProductNotFoundException;

public class OrderProcessorRepositoryImpl implements OrderProcessorRepository {
 Customers customers;
 Products products;
 Cart cart = new Cart();
 Orders orders;
 OrderItems ordersitems;
 
 List<Customers> custlist=new ArrayList<>();
 List<Products> productlist=new ArrayList<>();
 List<Cart> cartList=new ArrayList<>();
 List<Orders> orderList=new ArrayList<>();
 
CustomerDao cdao = new CustomerDao();
ProductsDao pdao = new ProductsDao();
CartDao cadao = new CartDao();
OrdersDao odao = new OrdersDao();
OrdersItemsDao oidao = new OrdersItemsDao();

Scanner sc=new Scanner(System.in);

@Override
public void createCustomer() {
	 customers = new Customers();
	 System.out.println("enter the customer_id");
	 int cid = sc.nextInt() ;
	 customers.setCustomer_id(cid);
	 System.out.println("enter email");
	 String email = sc.next();
	 customers.setEmail(email);
	 System.out.println("enter the name");
	 String name = sc.next();
	 customers.setName(name);
	 System.out.println("enter the password");
	 String pswd = sc.next();
	 customers.setPassword(pswd);
	 cdao.addCustomer(customers);
	 custlist.add(customers);
	 System.out.println("customer  "+customers.getCustomer_id()+ " "+"successfully added");
}

 @Override
 public void createProduct() {
	products = new Products();
	System.out.println("product name : ");
	String name = sc.next();
	products.setName(name);
	System.out.println("enter the description");
	String des = sc.next();
	products.setDescription(des);
	System.out.println("product id : ");
	int pid = sc.nextInt();
	products.setProduct_id(pid);
	System.out.println("price of the product : ");
	int pp = sc.nextInt();
	products.setPrice(pp);
	System.out.println("stock quantity : ");
	int sq = sc.nextInt();
	products.setStockQuantity(sq);
	pdao.addProduct(products);
	productlist.add(products);
	System.out.println("product added successfully");
 }
 

 @Override
 public boolean deleteProduct(int product_id) {
	 	
		try {
			boolean del = pdao.deleteProduct(product_id);
			if(del) {
				System.out.println("deleted suucessfullly!1");

			}else {
				System.out.println(" not deleted ");

	 }	
			return del;

		} catch (ProductNotFoundException e) {
			System.out.println("product id not found");
		}
		return false;

 }
 

 
 @Override
 public boolean addItemToCart() {
	 System.out.print("Enter cart ID: ");
     int cartId = sc.nextInt();
     cart.setCart_id(cartId);
     System.out.print("Enter customer ID: ");
     int customerId = sc.nextInt();
     cart.setCustomer_id(customerId);
     System.out.print("Enter product ID: ");
     int productId = sc.nextInt();
     cart.setProduct_id(productId);
     System.out.print("Enter quantity: ");
     int quantity = sc.nextInt();
     cart.setQuantity(quantity);

    

     boolean addedToCart = false;
	try {
		addedToCart = cadao.addToCart(cart);
	} catch (ProductNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
     if (addedToCart) {
         System.out.println("Product added to cart successfully.");
     } else {
         System.out.println("Failed to add product to cart.");
     }
	return addedToCart;
 }
 
 
 @Override
 public void viewcart(int customerid) {
	 List<Products> mycart = new ArrayList<Products>();
	 mycart = cadao.viewCart(customerid);
	 if (mycart.isEmpty())
			System.out.println("\nYour cart is empty");
		else {
			for(Products p:mycart)
			System.out.println(p);
 }}
 
 @Override
	public boolean placeOrder(int cid) {
 boolean r = false;
		
		System.out.println("Enter the shipping address : ");
		String address = sc.next();
		
		

		try {
			r= odao.placeOrder(cid, address);
		} catch (CustomerNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return r;

	}
 

}
