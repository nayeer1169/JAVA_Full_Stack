// CurrentAccount inherits from Account using the 'extends' keyword.
// This means CurrentAccount is-a Account and gets all its fields and methods.
public class CurrentAccount extends Account {
    
    // Private variable for overdraft limit, specific only to CurrentAccount.
    // Overdraft allows the balance to drop below zero up to this positive limit.
    private double overdraftLimit;

    // Constructor to initialize a CurrentAccount.
    // It accepts account number, holder name, initial balance, and overdraft limit.
    public CurrentAccount(String accountNumber, String holderName, double initialBalance, double overdraftLimit) {
        // 'super' calls the constructor of the parent class (Account).
        // This initializes the accountNumber, holderName, and balance fields.
        super(accountNumber, holderName, initialBalance);
        // Set the overdraft limit for this specific current account.
        this.overdraftLimit = overdraftLimit;
    }

    // Getter for the overdraft limit.
    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    // Setter for the overdraft limit.
    public void setOverdraftLimit(double overdraftLimit) {
        if (overdraftLimit >= 0) {
            this.overdraftLimit = overdraftLimit;
        }
    }

    // We OVERRIDE the parent class 'withdraw' method to implement different rules.
    // This is Polymorphism: the child class redefines withdrawal behavior.
    @Override
    public void withdraw(double amount) {
        // Validate if withdrawal amount is positive.
        if (amount > 0) {
            // Check if the withdrawal is within the available balance PLUS the overdraft limit.
            // For example, if balance is 1000 and overdraft is 500, we can withdraw up to 1500.
            if (this.balance + this.overdraftLimit >= amount) {
                // Deduct the amount from the balance (balance can become negative).
                this.balance -= amount;
                System.out.println("Successfully withdrew " + amount + ". Remaining Balance: " + this.balance);
            } else {
                System.out.println("Error: Overdraft limit exceeded! Withdrawal failed.");
            }
        } else {
            System.out.println("Error: Withdrawal amount must be positive.");
        }
    }

    // Implementation of the abstract method displayDetails() from the parent class.
    @Override
    public void displayDetails() {
        System.out.println("\n----------------------------------------");
        System.out.println("           CURRENT ACCOUNT DETAILS      ");
        System.out.println("----------------------------------------");
        // Accessing parent fields using getters
        System.out.println("Account Number  : " + getAccountNumber());
        System.out.println("Account Holder  : " + getHolderName());
        // Accessing the protected balance field directly
        System.out.println("Current Balance : " + balance);
        System.out.println("Overdraft Limit : " + overdraftLimit);
        System.out.println("----------------------------------------");
    }
}
