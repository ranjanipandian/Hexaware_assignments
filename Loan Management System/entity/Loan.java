package entity;

public class Loan {
    private int loanId;
    private Customer customer;
    private double principalAmount;
    private double interestRate;
    private int loanTerm;
    private String loanType;
    private String loanStatus;

    public Loan() {}

    public Loan(int loanId, Customer customer, double principalAmount, double interestRate,
                int loanTerm, String loanType, String loanStatus) {
        this.loanId = loanId;
        this.customer = customer;
        this.principalAmount = principalAmount;
        this.interestRate = interestRate;
        this.loanTerm = loanTerm;
        this.loanType = loanType;
        this.loanStatus = loanStatus;
    }

    public int getLoanId() { return loanId; }
    public void setLoanId(int loanId) { this.loanId = loanId; }

    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }

    public double getPrincipalAmount() { return principalAmount; }
    public void setPrincipalAmount(double principalAmount) { this.principalAmount = principalAmount; }

    public double getInterestRate() { return interestRate; }
    public void setInterestRate(double interestRate) { this.interestRate = interestRate; }

    public int getLoanTerm() { return loanTerm; }
    public void setLoanTerm(int loanTerm) { this.loanTerm = loanTerm; }

    public String getLoanType() { return loanType; }
    public void setLoanType(String loanType) { this.loanType = loanType; }

    public String getLoanStatus() { return loanStatus; }
    public void setLoanStatus(String loanStatus) { this.loanStatus = loanStatus; }

    @Override
    public String toString() {
        return "Loan ID: " + loanId + ", " + customer + ", Amount: " + principalAmount +
                ", Rate: " + interestRate + ", Term: " + loanTerm +
                ", Type: " + loanType + ", Status: " + loanStatus;
    }
}
