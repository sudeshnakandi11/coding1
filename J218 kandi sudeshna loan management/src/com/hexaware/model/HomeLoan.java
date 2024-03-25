package com.hexaware.model;


//HomeLoan class
public class HomeLoan extends Loan {
 public String propertyAddress;
 public int propertyValue;



 // Constructors
 public HomeLoan() {
 }



 public HomeLoan(int loanId, Customer customer, double principalAmount, double interestRate, int loanTerm, String loanStatus, String propertyAddress, int propertyValue) {
     super(loanId, customer, principalAmount, interestRate, loanTerm, "HomeLoan", loanStatus);
     this.propertyAddress = propertyAddress;
     this.propertyValue = propertyValue;
 }



 // Getters and setters
 public String getPropertyAddress() {
     return propertyAddress;
 }



 public static void setPropertyAddress(String propertyAddress) {
     propertyAddress = propertyAddress;
 }



 public int getPropertyValue() {
     return propertyValue;
 }



 public static void setPropertyValue(int propertyValue) {
     propertyValue = propertyValue;
 }



 // Method to print home loan information
 public void printHomeLoanInfo() {
     System.out.println("Home Loan Information:");
     printLoanInfo();
     System.out.println("Property Address: " + propertyAddress);
     System.out.println("Property Value: " + propertyValue);
 }
}
