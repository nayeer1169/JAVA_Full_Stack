// We import the Scanner utility class to read user input from the console.
import java.util.Scanner;

public class Main {
    // The main method is the entry point of any Java program.
    public static void main(String[] args) {
        
        // We create an instance of the Scanner class.
        // 'System.in' means the scanner reads from standard console input.
        Scanner scanner = new Scanner(System.in);
        
        // We declare a variable 'account' of type 'Account' (our abstract class).
        // It is set to 'null' because no account has been created yet.
        // Polymorphism: This single reference variable can store a SavingsAccount OR a CurrentAccount.
        Account account = null;

        // Print welcome banners to the console.
        System.out.println("=================================================");
        System.out.println("    WELCOME TO THE MINI BANKING SYSTEM           ");
        System.out.println("=================================================");

        // We declare a boolean variable 'exit' to control when the menu loop should stop.
        boolean exit = false;

        // A 'while' loop that continues to run as long as 'exit' is false.
        while (!exit) {
            // Print the main menu choices to the user.
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. Create Savings Account");
            System.out.println("2. Create Current Account");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Apply Savings Interest");
            System.out.println("6. Display Account Details");
            System.out.println("7. Exit");
            System.out.print("Enter your choice (1-7): ");

            // Read the whole line entered by the user.
            // '.trim()' cleans up any spaces they might have accidentally typed before/after.
            String choice = scanner.nextLine().trim();

            // A 'switch' statement to evaluate the user's choice.
            switch (choice) {
                
                case "1":
                    // --- CASE 1: CREATE SAVINGS ACCOUNT ---
                    System.out.print("Enter Account Number (e.g. SA101): ");
                    String saNum = scanner.nextLine().trim();
                    
                    System.out.print("Enter Account Holder Name: ");
                    String saName = scanner.nextLine().trim();
                    
                    // Validation: if the name string is empty, we print an error and stop.
                    if (saName.isEmpty()) {
                        System.out.println("Error: Account holder name cannot be empty!");
                        break; // Exits this switch block, returning to the menu loop.
                    }

                    System.out.print("Enter Initial Deposit Amount: ");
                    // We parse the string input into a double decimal value.
                    double saBalance = Double.parseDouble(scanner.nextLine().trim());

                    System.out.print("Enter Interest Rate (e.g. 4.5): ");
                    double saInterest = Double.parseDouble(scanner.nextLine().trim());

                    // Dynamic instantiation: 'new SavingsAccount' creates a savings account object.
                    // Polymorphism: We assign it to our base 'Account' reference variable.
                    account = new SavingsAccount(saNum, saName, saBalance, saInterest);
                    System.out.println("Success: Savings Account created successfully!");
                    break; // End of Case 1

                case "2":
                    // --- CASE 2: CREATE CURRENT ACCOUNT ---
                    System.out.print("Enter Account Number (e.g. CA101): ");
                    String caNum = scanner.nextLine().trim();
                    
                    System.out.print("Enter Account Holder Name: ");
                    String caName = scanner.nextLine().trim();
                    
                    if (caName.isEmpty()) {
                        System.out.println("Error: Account holder name cannot be empty!");
                        break;
                    }

                    System.out.print("Enter Initial Deposit Amount: ");
                    double caBalance = Double.parseDouble(scanner.nextLine().trim());

                    System.out.print("Enter Overdraft Limit (e.g. 5000): ");
                    double caOverdraft = Double.parseDouble(scanner.nextLine().trim());

                    // Instantiating CurrentAccount and assigning it to the parent 'Account' reference.
                    account = new CurrentAccount(caNum, caName, caBalance, caOverdraft);
                    System.out.println("Success: Current Account created successfully!");
                    break;

                case "3":
                    // --- CASE 3: DEPOSIT MONEY ---
                    // We check if 'account' is null to prevent the application from crashing.
                    // This is a safety check: you cannot deposit into a non-existent account!
                    if (account == null) {
                        System.out.println("Error: Please create an account first (Option 1 or 2)!");
                        break;
                    }
                    System.out.print("Enter deposit amount: ");
                    double depAmount = Double.parseDouble(scanner.nextLine().trim());
                    // Call the deposit method on the account.
                    account.deposit(depAmount);
                    break;

                case "4":
                    // --- CASE 4: WITHDRAW MONEY ---
                    if (account == null) {
                        System.out.println("Error: Please create an account first (Option 1 or 2)!");
                        break;
                    }
                    System.out.print("Enter withdrawal amount: ");
                    double wAmount = Double.parseDouble(scanner.nextLine().trim());
                    
                    // Polymorphic invocation: Java knows whether to call CurrentAccount's withdraw()
                    // or parent Account's withdraw() depending on the object currently referenced.
                    account.withdraw(wAmount);
                    break;

                case "5":
                    // --- CASE 5: APPLY SAVINGS INTEREST ---
                    if (account == null) {
                        System.out.println("Error: Please create an account first!");
                        break;
                    }
                    
                    // 'instanceof' is a Java operator that returns true if the object matches the type.
                    // We verify if our account is a SavingsAccount because CurrentAccounts don't earn interest.
                    if (account instanceof SavingsAccount) {
                        // DOWNCASTING: Since 'applyInterest' is only defined in SavingsAccount,
                        // we must cast our generic 'Account' type to a 'SavingsAccount' type.
                        SavingsAccount sa = (SavingsAccount) account;
                        // Now we can call the interest method.
                        sa.applyInterest();
                    } else {
                        System.out.println("Error: Interest can only be applied to a Savings Account!");
                    }
                    break;

                case "6":
                    // --- CASE 6: DISPLAY ACCOUNT DETAILS ---
                    if (account == null) {
                        System.out.println("Error: Please create an account first!");
                        break;
                    }
                    // Polymorphism in action: runs the overridden displayDetails method.
                    account.displayDetails();
                    break;

                case "7":
                    // --- CASE 7: EXIT ---
                    exit = true; // Set loop flag to true so the loop ends.
                    System.out.println("Thank you for using the Banking System. Goodbye!");
                    break;

                default:
                    // If they enter something else (like choice = "9" or choice = "hello"), print error.
                    System.out.println("Error: Invalid choice! Please select an option between 1 and 7.");
            }
        }
        
        // Close the scanner input to free up system memory resources.
        scanner.close();
    }
}
