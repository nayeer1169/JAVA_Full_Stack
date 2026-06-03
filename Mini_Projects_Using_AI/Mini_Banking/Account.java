// We don't define a package statement here to make compilation very simple for a beginner.

// We declare 'Account' as an abstract class using the 'abstract' keyword.
// This means you cannot create a generic account using 'new Account(...)'.
public abstract class Account {
    
    // Private variable for Account Number. Only accessible inside this class (Encapsulation).
    private String accountNumber;
    
    // Private variable for Holder Name. Only accessible inside this class (Encapsulation).
    private String holderName;
    
    // Protected variable for Balance. Accessible by subclasses (SavingsAccount, CurrentAccount) directly.
    protected double balance;

    // Constructor to initialize an Account object when a subclass is created.
    // It accepts parameters for account number, holder name, and initial deposit balance.
    public Account(String accountNumber, String holderName, double initialBalance) {
        // 'this.accountNumber' refers to the instance variable.
        // The right side 'accountNumber' refers to the constructor parameter.
        this.accountNumber = accountNumber; 
        this.holderName = holderName;
        this.balance = initialBalance;
    }

    // Getter method to retrieve the Account Number (Encapsulation read access).
    public String getAccountNumber() {
        return accountNumber;
    }

    // Getter method to retrieve the Holder Name (Encapsulation read access).
    public String getHolderName() {
        return holderName;
    }

    // Setter method to update the Holder Name (Encapsulation write access).
    // It performs validation to ensure the name is not empty or invalid.
    public void setHolderName(String holderName) {
        // String check: ensuring the string is not null and not blank
        if (holderName != null && !holderName.trim().isEmpty()) {
            // '.trim()' removes leading and trailing spaces from the name
            this.holderName = holderName.trim();
        } else {
            System.out.println("Invalid name! Holder name cannot be empty.");
        }
    }

    // Getter method to retrieve the current Balance (Encapsulation read access).
    public double getBalance() {
        return balance;
    }

    // Method to deposit money into the account.
    public void deposit(double amount) {
        // Validate if the amount is positive.
        if (amount > 0) {
            // Add the deposit amount to our current balance.
            this.balance += amount;
            System.out.println("Successfully deposited " + amount + ". New Balance: " + this.balance);
        } else {
            System.out.println("Error: Deposit amount must be positive.");
        }
    }

    // Method to withdraw money from the account.
    // This can be overridden by subclasses if they have different withdrawal rules.
    public void withdraw(double amount) {
        // Validate if the withdrawal amount is positive.
        if (amount > 0) {
            // Check if the account has enough money.
            if (this.balance >= amount) {
                // Deduct the amount from our balance.
                this.balance -= amount;
                System.out.println("Successfully withdrew " + amount + ". Remaining Balance: " + this.balance);
            } else {
                System.out.println("Error: Insufficient funds! Withdrawal failed.");
            }
        } else {
            System.out.println("Error: Withdrawal amount must be positive.");
        }
    }

    // Abstract method that MUST be implemented by any concrete subclass.
    // Demonstrates Abstraction: defining 'what' to do, leaving 'how' to the subclass.
    public abstract void displayDetails();
}
