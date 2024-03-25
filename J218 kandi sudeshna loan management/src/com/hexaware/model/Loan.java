package com.hexaware.model;
// Loan class
public class Loan {
    private int loanId;
    private Customer customer;
    private double principalAmount;
    private double interestRate;
    private int loanTerm;
    private String loanType;
    private String loanStatus;

 

    // Constructors
    public Loan() {
    }

 

    public Loan(int loanId, Customer customer, double principalAmount, double interestRate, int loanTerm, String loanType, String loanStatus) {
        this.loanId = loanId;
        this.customer = customer;
        this.principalAmount = principalAmount;
        this.interestRate = interestRate;
        this.loanTerm = loanTerm;
        this.loanType = loanType;
        this.loanStatus = loanStatus;
    }

 

    // Getters and setters
    public int getLoanId() {
        return loanId;
    }

 

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }

 

    public Customer getCustomer() {
        return customer;
    }
 

    public double getPrincipalAmount() {
        return principalAmount;
    }

 

    public void setPrincipalAmount(double principalAmount) {
        this.principalAmount = principalAmount;
    }

 

    public double getInterestRate() {
        return interestRate;
    }

 

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

 

    public int getLoanTerm() {
        return loanTerm;
    }

 

    public void setLoanTerm(int loanTerm) {
        this.loanTerm = loanTerm;
    }

 

    public String getLoanType() {
        return loanType;
    }

 

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

 

    public String getLoanStatus() {
        return loanStatus;
    }

 

    public void setLoanStatus(String loanStatus) {
        this.loanStatus = loanStatus;
    }

 

    // Method to print loan information
    public void printLoanInfo() {
        System.out.println("Loan ID: " + loanId);
        System.out.println("Customer Information:");
        customer.printCustomerInfo();
        System.out.println("Principal Amount: " + principalAmount);
        System.out.println("Interest Rate: " + interestRate);
        System.out.println("Loan Term: " + loanTerm + " months");
        System.out.println("Loan Type: " + loanType);
        System.out.println("Loan Status: " + loanStatus);
    }
}