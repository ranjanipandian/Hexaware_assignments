package dao;


import entity.Loan;
import exception.InvalidLoanException;

import java.util.ArrayList;
import java.util.List;

public class LoanRepositoryImpl implements ILoanRepository {

    private List<Loan> loanList = new ArrayList<>();

    @Override
    public boolean applyLoan(Loan loan) {
        return loanList.add(loan);
    }

    @Override
    public double calculateInterest(int loanId) throws InvalidLoanException {
        Loan loan = getLoanById(loanId);
        double principal = loan.getPrincipalAmount();
        double rate = loan.getInterestRate();
        int term = loan.getLoanTerm();
        return (principal * rate * term) / (100 * 12); 
    }

    @Override
    public String loanStatus(int loanId) throws InvalidLoanException {
        return getLoanById(loanId).getLoanStatus();
    }

    @Override
    public double calculateEMI(int loanId) throws InvalidLoanException {
        Loan loan = getLoanById(loanId);
        double principal = loan.getPrincipalAmount();
        double rate = loan.getInterestRate() / (12 * 100); 
        int term = loan.getLoanTerm(); 

        return (principal * rate * Math.pow(1 + rate, term)) /
                (Math.pow(1 + rate, term) - 1);
    }

    @Override
    public boolean loanRepayment(int loanId, double amount) throws InvalidLoanException {
        Loan loan = getLoanById(loanId);
        if (amount >= loan.getPrincipalAmount()) {
            loan.setLoanStatus("Paid");
            return true;
        }
        return false;
    }

    @Override
    public List<Loan> getAllLoans() {
        return loanList;
    }

    @Override
    public Loan getLoanById(int loanId) throws InvalidLoanException {
        return loanList.stream()
                .filter(l -> l.getLoanId() == loanId)
                .findFirst()
                .orElseThrow(() -> new InvalidLoanException("Loan ID " + loanId + " not found."));
    }
}
