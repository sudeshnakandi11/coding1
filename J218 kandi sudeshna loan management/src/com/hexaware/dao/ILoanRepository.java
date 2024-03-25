package com.hexaware.dao;

import java.util.List;

import com.hexaware.exception.InvalidLoanException;
import com.hexaware.model.Loan;

public interface ILoanRepository {
 void applyLoan(Loan loan) throws InvalidLoanException;
 double calculateInterest(int loanId) throws InvalidLoanException; 
double calculateInterest(double principalAmount, double interestRate, int loanTerm); 
void loanStatus(int loanId) throws InvalidLoanException;
 double calculateEMI(int loanId) throws InvalidLoanException;
 void loanRepayment(int loanId, double amount) throws InvalidLoanException;
 List<Loan> getAllLoan(); 
Loan getLoanById(int loanId) throws InvalidLoanException; 
}
