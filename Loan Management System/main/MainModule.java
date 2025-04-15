package main;

import dao.ILoanRepository;
import dao.LoanRepositoryImpl;
import entity.Customer;
import entity.HomeLoan;
import exception.InvalidLoanException;

import java.util.Scanner;

public class MainModule {
    public static void main(String[] args) {
        ILoanRepository repo = new LoanRepositoryImpl();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n---- Loan Management Menu ----");
            System.out.println("1. Apply Loan");
            System.out.println("2. Calculate Interest");
            System.out.println("3. Get Loan Status");
            System.out.println("4. Calculate EMI");
            System.out.println("5. Loan Repayment");
            System.out.println("6. View All Loans");
            System.out.println("7. Get Loan by ID");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1:
                        Customer cust = new Customer(1, "Bala", "bala@email.com", "9999999999", "Chennai", 720);
                        HomeLoan loan = new HomeLoan(1001, cust, 500000, 7.5, 60, "Pending", "Chennai", 800000);
                        System.out.print("Confirm apply loan? (yes/no): ");
                        if (sc.next().equalsIgnoreCase("yes")) {
                            boolean applied = repo.applyLoan(loan);
                            System.out.println(applied ? "Loan applied." : "Loan failed.");
                        }
                        break;
                    case 2:
                        System.out.print("Enter loan ID: ");
                        System.out.println("Interest: " + repo.calculateInterest(sc.nextInt()));
                        break;
                    case 3:
                        System.out.print("Enter loan ID: ");
                        System.out.println(repo.loanStatus(sc.nextInt()));
                        break;
                    case 4:
                        System.out.print("Enter loan ID: ");
                        System.out.println("EMI: " + repo.calculateEMI(sc.nextInt()));
                        break;
                    case 5:
                        System.out.print("Enter loan ID and amount: ");
                        boolean paid = repo.loanRepayment(sc.nextInt(), sc.nextDouble());
                        System.out.println(paid ? "Repayment success" : "Repayment failed");
                        break;
                    case 6:
                        repo.getAllLoans().forEach(System.out::println);
                        break;
                    case 7:
                        System.out.print("Enter loan ID: ");
                        System.out.println(repo.getLoanById(sc.nextInt()));
                        break;
                    case 0:
                        System.out.println("Thank you!");
                        return;
                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (InvalidLoanException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
