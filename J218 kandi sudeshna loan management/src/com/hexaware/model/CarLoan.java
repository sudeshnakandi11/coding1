package com.hexaware.model;

// CarLoan class
public class CarLoan extends Loan {
    private String carModel;
    private int carValue;

 

    // Constructors
    public CarLoan() {
    }

 

    public CarLoan(int loanId, Customer customer, double principalAmount, double interestRate, int loanTerm, String loanStatus, String carModel, int carValue) {
        super(loanId, customer, principalAmount, interestRate, loanTerm, "CarLoan", loanStatus);
        this.carModel = carModel;
        this.carValue = carValue;
    }

 

    // Getters and setters
    public String getCarModel() {
        return carModel;
    }

 

    public static void setCarModel(String carModel) {
        carModel = carModel;
    }

 

    public int getCarValue() {
        return carValue;
    }

 

    public static void setCarValue(int carValue) {
        carValue = carValue;
    }

 

    // Method to print car loan information
    public void printCarLoanInfo() {
        System.out.println("Car Loan Information:");
        printLoanInfo();
        System.out.println("Car Model: " + carModel);
        System.out.println("Car Value: " + carValue);
    }
}
  