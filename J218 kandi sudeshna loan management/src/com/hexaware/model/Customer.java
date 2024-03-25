package com.hexaware.model;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.hexaware.util.*;


// Customer class
public class Customer {
    private int customerId;
    private String name;
    private String emailAddress;
    private String phoneNumber;
    private String address;
    private int creditScore;

 

    // Constructors
    public Customer() {
    }

 

    public Customer(int customerId, String name, String emailAddress, String phoneNumber, String address, int creditScore) {
    	try {
            // Store the loan in the database
            String sql = "INSERT INTO Customer( customerId, name, emailAddress , phoneNumber , String address , creditScore) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, customerId);
            statement.setString(2,name);
            statement.setString(3,emailAddress);
            statement.setString(4,phoneNumber);
            statement.setString(5,address);
            statement.setLong(6, creditScore);
       
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Loan applied successfully.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle SQL exception
        }
    }

 

    // Getters and setters
    public int getCustomerId() {
        return customerId;
    }

 

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

 

    public String getName() {
        return name;
    }

 

    public void setName(String name) {
        this.name = name;
    }

 

    public String getEmailAddress() {
        return emailAddress;
    }

 

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

 

    public String getPhoneNumber() {
        return phoneNumber;
    }

 

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

 

    public String getAddress() {
        return address;
    }

 

    public void setAddress(String address) {
        this.address = address;
    }

 

    public int getCreditScore() {
        return creditScore;
    }

 

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }

 

    // Method to print customer information
    public void printCustomerInfo() {
        System.out.println("Customer ID: " + customerId);
        System.out.println("Name: " + name);
        System.out.println("Email Address: " + emailAddress);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Address: " + address);
        System.out.println("Credit Score: " + creditScore);
    }
}

 

 