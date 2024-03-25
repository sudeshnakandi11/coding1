package com.hexaware.dao;
import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hexaware.exception.InvalidLoanException;
import com.hexaware.model.CarLoan;
import com.hexaware.model.HomeLoan;
import com.hexaware.model.Loan;

public  class ILoanRepositoryImpl implements ILoanRepository {
    private Scanner scanner;
    private Connection connection;

    @Override
    public void applyLoan(Loan loan) throws InvalidLoanException {
        System.out.println("Do you want to apply for this loan? (Yes/No)");
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("Yes")) {
            System.out.println("Choose the type of loan:");
            System.out.println("1. Home Loan");
            System.out.println("2. Car Loan");
            System.out.print("Enter your choice: ");
            int loanTypeChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            
            String loanType = "";
            switch (loanTypeChoice) {
                case 1:
                    loanType = "HomeLoan";
                    HomeLoan.setPropertyAddress(scanner.nextLine());
                    HomeLoan.setPropertyValue(scanner.nextInt());
                    break;
                case 2:
                    loanType = "CarLoan";
         CarLoan.setCarModel(scanner.nextLine());
                    CarLoan.setCarValue(scanner.nextInt());
                    break;
                default:
                    throw new InvalidLoanException("Invalid loan type choice.");
            }

     

            try {
                // Store the loan in the database
                String sql = "INSERT INTO loans (loanId, customerId, principalAmount, interestRate, loanTerm, loanType, loanStatus) VALUES (?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1, loan.getLoanId());
                statement.setInt(2, loan.getCustomer().getCustomerId());
                statement.setDouble(3, loan.getPrincipalAmount());
                statement.setDouble(4, loan.getInterestRate());
                statement.setInt(5, loan.getLoanTerm());
                statement.setString(6, loanType);
                statement.setString(7, "Pending");
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Loan applied successfully.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                // Handle SQL exception
            }
        } else {
            throw new InvalidLoanException("Loan application cancelled.");
        }
    }

    @Override
    public double calculateInterest(int loanId) throws InvalidLoanException {
        try {
            // Retrieve loan details from database
            String sql = "SELECT principalAmount, interestRate, loanTerm FROM loans WHERE loanId = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, loanId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                double principalAmount = resultSet.getDouble("principalAmount");
                double interestRate = resultSet.getDouble("interestRate");
                int loanTerm = resultSet.getInt("loanTerm");
                // Calculate interest
                return (principalAmount * interestRate * loanTerm) / 12;
            } else {
                throw new InvalidLoanException("Loan not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle SQL exception
            throw new InvalidLoanException("Failed to calculate interest.");
        }
    }

    // Overloaded method to calculate interest while creating loan
    public double calculateInterest(double principalAmount, double interestRate, int loanTerm) {
        return (principalAmount * interestRate * loanTerm) / 12;
    }

    @Override
    public void loanStatus(int loanId) throws InvalidLoanException {
        try {
            // Retrieve loan details from database
            String sql = "SELECT creditScore FROM customers INNER JOIN loans ON customers.customerId = loans.customerId WHERE loanId = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, loanId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int creditScore = resultSet.getInt("creditScore");
                // Check credit score and update loan status
                String status = (creditScore > 650) ? "Approved" : "Rejected";
                // Update loan status in database
                String updateSql = "UPDATE loans SET loanStatus = ? WHERE loanId = ?";
                PreparedStatement updateStatement = connection.prepareStatement(updateSql);
                updateStatement.setString(1, status);
                updateStatement.setInt(2, loanId);
                int rowsUpdated = updateStatement.executeUpdate();
                if (rowsUpdated > 0) {
                    System.out.println("Loan status updated successfully.");
                }
            } else {
                throw new InvalidLoanException("Loan not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle SQL exception
            throw new InvalidLoanException("Failed to update loan status.");
        }
    }

    @Override
    public double calculateEMI(int loanId) throws InvalidLoanException {
        try {
            // Retrieve loan details from database
            String sql = "SELECT principalAmount, interestRate, loanTerm FROM loans WHERE loanId = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, loanId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                double principalAmount = resultSet.getDouble("principalAmount");
                double interestRate = resultSet.getDouble("interestRate");
                int loanTerm = resultSet.getInt("loanTerm");
                // Calculate EMI
                double r = interestRate / 12 / 100;
                double emi = (principalAmount * r * Math.pow(1 + r, loanTerm)) / (Math.pow(1 + r, loanTerm) - 1);
                return emi;
            } else {
                throw new InvalidLoanException("Loan not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle SQL exception
            throw new InvalidLoanException("Failed to calculate EMI.");
        }
    }

    // Overloaded method to calculate EMI while creating loan
    public double calculateEMI(double principalAmount, double interestRate, int loanTerm) {
        double r = interestRate / 12 / 100;
        double emi = (principalAmount * r * Math.pow(1 + r, loanTerm)) / (Math.pow(1 + r, loanTerm) - 1);
        return emi;
    }

    @Override
    public void loanRepayment(int loanId, double amount) throws InvalidLoanException {
        try {
            // Calculate number of EMIs that can be paid with the amount
            double emi = calculateEMI(loanId);
            int noOfEmi = (int) (amount / emi);
            // Update the loan repayment variable
            String sql = "UPDATE loans SET noOfEmi = ? WHERE loanId = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, noOfEmi);
            statement.setInt(2, loanId);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Loan repayment updated successfully.");
            } else {
                throw new InvalidLoanException("Loan not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle SQL exception
            throw new InvalidLoanException("Failed to update loan repayment.");
        }
    }

    @Override
    public List<Loan> getAllLoan() {
        try {
            // Retrieve all loans from database and print details
            String sql = "SELECT * FROM loans";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                // Print loan details
                System.out.println("Loan ID: " + resultSet.getInt("loanId"));
                System.out.println("Customer ID: " + resultSet.getInt("customerId"));
                // Print other loan details
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle SQL exception
        }
		return null;
    }

    @Override
    public Loan getLoanById(int loanId) throws InvalidLoanException {
        try {
            // Retrieve loan details from database based on loanId and print details
            String sql = "SELECT * FROM loans WHERE loanId = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, loanId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                // Print loan details
                System.out.println("Loan ID: " + resultSet.getInt("loanId"));
                System.out.println("Customer ID: " + resultSet.getInt("customerId"));
                // Print other loan details
            } else {
                throw new InvalidLoanException("Loan not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle SQL exception
            throw new InvalidLoanException("Failed to retrieve loan details.");
        }
		return null;
    }
}