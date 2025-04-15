package dao;

import entity.Loan;
import exception.InvalidLoanException;

import java.util.List;

public interface ILoanRepository {
    boolean applyLoan(Loan loan);
    double calculateInterest(int loanId) throws InvalidLoanException;
    double calculateInterest(double principal, double rate, int months);
    String loanStatus(int loanId) throws InvalidLoanException;
    double calculateEMI(int loanId) throws InvalidLoanException;
    double calculateEMI(double principal, double rate, int months);
    boolean loanRepayment(int loanId, double amount) throws InvalidLoanException;
    List<Loan> getAllLoans();
    Loan getLoanById(int loanId) throws InvalidLoanException;
}
