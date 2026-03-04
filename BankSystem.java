import java.util.Scanner;
abstract class Account {
    protected double balance;
    Account(double balance) {
        this.balance = balance;
    }
    abstract void deposit(double amount);
    abstract void withdraw(double amount);
    void showBalance() {
        System.out.println("Available Balance: " + balance);
    }
}
class CustomerAccount extends Account {
    CustomerAccount(double balance) {
        super(balance);
    }
    @Override
    void deposit(double amount) {
        if (amount > 0) {
            double interest = amount * 0.02;
            balance = balance + amount + interest;
            System.out.println("Deposit Amount: " + amount);
            System.out.println("Interest Added: " + interest);
        } else {
            System.out.println("Deposit amount must be positive");
        }
    }
    @Override
    void withdraw(double amount) {
        double serviceCharge = amount * 0.01;
        double totalDeduction = amount + serviceCharge;
        if (amount > 0 && totalDeduction <= balance) {
            balance = balance - totalDeduction;
            System.out.println("Withdraw Amount: " + amount);
            System.out.println("Service Charge: " + serviceCharge);
        } else {
            System.out.println("Withdrawal not possible");
        }
    }
}
public class BankSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter initial balance: ");
        double initialBalance = sc.nextDouble();
        Account acc = new CustomerAccount(initialBalance);
        System.out.print("Enter deposit amount: ");
        double depositAmount = sc.nextDouble();
        acc.deposit(depositAmount);
        System.out.print("Enter withdraw amount: ");
        double withdrawAmount = sc.nextDouble();
        acc.withdraw(withdrawAmount);
        acc.showBalance();
    }
}
