package com.hexaware.main;
import com.hexaware.model.*;
import com.hexaware.dao.*;
import com.hexaware.exception.InvalidLoanException;

import java.util.List;
import java.util.Scanner;

public class LoanManagement {
    private static ILoanRepository loanRepository = new ILoanRepositoryImpl();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            System.out.println("\n===== Loan Management System =====");
            System.out.println("1. Apply Loan");
            System.out.println("2. Get All Loans");
            System.out.println("3. Get Loan by ID");
            System.out.println("4. Loan Repayment");
            System.out.println("5.create customer");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    applyLoan();
                    break;
                case 2:
                    getAllLoans();
                    break;
                case 3:
                    getLoanById();
                    break;
                case 4:
                    loanRepayment();
                    break;
                case 5:
                	Customer( scanner.nextInt(),scanner.nextLine(),scanner.nextLine(),scanner.nextLine(),scanner.next(),scanner.nextInt());
                	break;
                case 6:
                    exit = true;
                    System.out.println("Exiting Loan Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 5.");
            }
        }
    }

	private static void Customer(int nextInt, String nextLine, String nextLine2, String nextLine3, String next,
			int nextInt2) {
		// TODO Auto-generated method stub
		
	}

	private static void createcustomer() {
		// TODO Auto-generated method stub
		
	}

	private static void loanRepayment() {
		// TODO Auto-generated method stub
        System.out.println("Loan repayment processed.");

	}

	private static void applyLoan() {
		// TODO Auto-generated method stub
        System.out.println("Loan application submitted.");

	}

	private static void getLoanById() {
		// TODO Auto-generated method stub
		System.out.print("Enter Loan ID: ");
        int id = scanner.nextInt();
        try {
            Loan loan = loanRepository.getLoanById(id);
            System.out.println(loan); // Assuming Loan class has a meaningful toString() implementation
        } catch (InvalidLoanException e) {
            System.out.println("Loan not found with ID: " + id);
        } catch (Exception e) {
            System.out.println("An error occurred.");
        }
	}

	private static void getAllLoans() {
		// TODO Auto-generated method stub
		 try {
	            List<Loan> loans = loanRepository.getAllLoan();
	            for (Loan loan : loans) {
	                System.out.println(loan); // Assuming Loan class has a meaningful toString() implementation
	            }
	        } catch (Exception e) {
	            System.out.println("Failed to retrieve loans.");
	        }
	}
}
