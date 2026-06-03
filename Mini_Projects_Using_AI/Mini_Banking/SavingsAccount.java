// SavingsAccount inherits from Account using the 'extends' keyword.
// This means SavingsAccount is-a Account and gets all its fields and methods.
public class SavingsAccount extends Account {
    
    // Private variable for interest rate, specific only to SavingsAccount (Encapsulation).
    private double interestRate;

    // Constructor to initialize a SavingsAccount.
    // It accepts account number, holder name, initial balance, and interest rate.
    public SavingsAccount(String accountNumber, String holderName, double initialBalance, double interestRate) {
        // 'super' calls the constructor of the parent class (Account).
        // This initializes the accountNumber, holderName, and balance fields.
        super(accountNumber, holderName, initialBalance);
        // Set the interest rate for this specific savings account.
        this.interestRate = interestRate;
    }

    // Getter for the interest rate.
    public double getInterestRate() {
        return interestRate;
    }

    // Setter for the interest rate.
    public void setInterestRate(double interestRate) {
        // Validate that interest rate is non-negative
        if (interestRate >= 0) {
            this.interestRate = interestRate;
        }
    }

    // Method to calculate and apply interest to the account.
    // Interest formula: Interest = Balance * (Interest Rate / 100).
    public void applyInterest() {
        // Calculate the interest amount.
        double interest = balance * (interestRate / 100);
        // Add interest to the balance (since balance is protected, we can access it directly).
        balance += interest;
        System.out.println("Interest of " + interest + " applied at " + interestRate + "%. New Balance: " + balance);
    }

    // Implementation of the abstract method displayDetails() from the parent class.
    // Overriding is a form of runtime Polymorphism.
    @Override
    public void displayDetails() {
        System.out.println("\n----------------------------------------");
        System.out.println("           SAVINGS ACCOUNT DETAILS      ");
        System.out.println("----------------------------------------");
        // We use getter methods for private fields from parent class
        System.out.println("Account Number : " + getAccountNumber());
        System.out.println("Account Holder : " + getHolderName());
        // We can access 'balance' directly or use 'getBalance()'
        System.out.println("Current Balance: " + balance);
        System.out.println("Interest Rate  : " + interestRate + "%");
        System.out.println("----------------------------------------");
    }
}
