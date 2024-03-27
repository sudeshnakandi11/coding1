package com.hexaware.view;


import com.hexaware.controller.*;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws SQLException {
		OrderProcessorRepository ol = new OrderProcessorRepositoryImpl();
		System.out.println("Welcome to e-commerce!!");
		String c =null;
		do {
			System.out.println("1.Register customer");
			System.out.println("2.create product");
			System.out.println("3.delete product");
			System.out.println("4.Add to cart");
			System.out.println("5.view cart");
			System.out.println("6.place order");
			System.out.println("enter your choice::");
		    int choice = sc.nextInt();
			switch (choice) {
			case 1: {
				ol.createCustomer();
				break;
			}
			case 2: {
				ol.createProduct();
				break;
			}
			case 3: {
				System.out.println("enter the product id to delete:"); 
				ol.deleteProduct(sc.nextInt());		
				break;
			}
			case 4: {
				ol.addItemToCart();
			break;
			}
			case 5: {
				System.out.println("enter the customer id to view details:"); 

			            ol.viewcart(sc.nextInt());
			                 break;
			}
			case 6: {
				System.out.println("enter the customer id to place new orders:"); 
				ol.placeOrder(sc.nextInt());			                 
				break;
			}
			
	
			default: {
			System.out.println("Enter the right choice. ");
			}
			}
			System.out.println("Do you want to continue? Y or y");
			c = sc.next();
			} while (c.equals("Y") || c.equals("y"));
			System.out.println("Thanks for using our system !!!");
			System.exit(0);



}
}
