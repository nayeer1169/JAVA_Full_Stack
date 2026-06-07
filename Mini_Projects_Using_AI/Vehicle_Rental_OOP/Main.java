// No package statement for simple compilation.

import java.util.Scanner;

/**
 * Main Class - The CLI Driver program.
 * 
 * --------------------------------------------------------------------------------------------------
 * OOP CONCEPT CHECKLIST ILLUSTRATED IN THIS DEMO:
 * 1. Abstraction  : Use of the 'Vehicle' abstract class as a general blueprint.
 * 2. Encapsulation: Accessing fields only via methods like 'getBrand()', 'isRented()', etc.
 * 3. Inheritance  : 'Car', 'Motorcycle', and 'Truck' extending 'Vehicle' and inheriting code.
 * 4. Polymorphism :
 *    - Passing subclass objects ('new Car(...)') directly to the agency's 'addVehicle(Vehicle v)' method.
 *    - Relying on dynamic method dispatch when calling overridden methods like 'calculateRentalCost()'.
 * --------------------------------------------------------------------------------------------------
 */
public class Main {
    public static void main(String[] args) {
        // Create the agency object with a capacity of up to 10 vehicles.
        // It manages the fleet using a standard Java array.
        RentalAgency agency = new RentalAgency(10);

        // Prepopulate the agency inventory.
        // Note: we can pass Car, Motorcycle, and Truck references into the addVehicle(Vehicle) method.
        // This is implicit upcasting, a form of polymorphism.
        agency.addVehicle(new Car("C001", "Toyota", "Camry", 50.00, true));
        agency.addVehicle(new Car("C002", "Honda", "Civic", 40.00, false));
        agency.addVehicle(new Car("C003", "Tesla", "Model 3", 85.00, true));
        
        agency.addVehicle(new Motorcycle("M001", "Harley-Davidson", "Sportster", 60.00, true));
        agency.addVehicle(new Motorcycle("M002", "Kawasaki", "Ninja 400", 35.00, false));
        
        agency.addVehicle(new Truck("T001", "Ford", "F-150", 75.00, 1.5));
        agency.addVehicle(new Truck("T002", "Chevrolet", "Silverado", 80.00, 2.0));
        agency.addVehicle(new Truck("T003", "Volvo", "Heavy Hauler", 250.00, 18.0));

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        System.out.println("=========================================================================");
        System.out.println("               W E L C O M E  T O  O O P  R E N T A L S                  ");
        System.out.println("=========================================================================");
        System.out.println("This system showcases the 4 Pillars of Object-Oriented Programming (OOP) ");
        System.out.println("using Car, Motorcycle, and Truck vehicles stored in a native array.      ");

        while (!exit) {
            System.out.println("\n--------------------------- MAIN MENU ---------------------------");
            System.out.println("1. List All Vehicles");
            System.out.println("2. Rent a Vehicle");
            System.out.println("3. Return a Vehicle");
            System.out.println("4. Inspect Specific Vehicle (Detailed Info)");
            System.out.println("5. Show Agency Performance Statistics");
            System.out.println("6. Exit Application");
            System.out.print("Choose an option: ");

            // Input validation: Check if user entered an integer
            if (!scanner.hasNextInt()) {
                System.out.println("Error: Please enter a valid menu number (1-6).");
                scanner.nextLine(); // Clear the invalid input from scanner buffer
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the trailing newline character from buffer

            switch (choice) {
                case 1:
                    // Display all vehicles in inventory
                    agency.displayInventory();
                    break;
                case 2:
                    System.out.print("Enter Vehicle ID to rent (e.g. C001): ");
                    String rentId = scanner.nextLine();
                    
                    System.out.print("Enter rental duration in days: ");
                    if (!scanner.hasNextInt()) {
                        System.out.println("Error: Rental days must be a positive number.");
                        scanner.nextLine(); // Clear the invalid input
                        break;
                    }
                    int days = scanner.nextInt();
                    scanner.nextLine(); // Clear scanner buffer
                    
                    // Call the rent method (surcharge calculated dynamically based on type)
                    agency.rentVehicle(rentId, days);
                    break;
                case 3:
                    System.out.print("Enter Vehicle ID to return (e.g. C001): ");
                    String returnId = scanner.nextLine();
                    agency.returnVehicle(returnId);
                    break;
                case 4:
                    System.out.print("Enter Vehicle ID to inspect: ");
                    String inspectId = scanner.nextLine();
                    
                    Vehicle found = agency.findVehicle(inspectId);
                    if (found != null) {
                        System.out.println("\n--- Vehicle Details ---");
                        // Polymorphism: Java prints the subclass-specific details
                        System.out.println(found);
                        // Show cost simulation for different days
                        System.out.println("Cost simulation for 1 day : $" + String.format("%.2f", found.calculateRentalCost(1)));
                        System.out.println("Cost simulation for 7 days: $" + String.format("%.2f", found.calculateRentalCost(7)));
                        System.out.println("-----------------------");
                    } else {
                        System.out.println("Error: Vehicle with ID '" + inspectId + "' not found.");
                    }
                    break;
                case 5:
                    // Show global agency performance statistics
                    agency.displayStats();
                    break;
                case 6:
                    exit = true;
                    System.out.println("\nThank you for using OOP Rentals! Good luck upskilling your Core Java.");
                    break;
                default:
                    System.out.println("Error: Choice out of bounds. Please select 1 through 6.");
            }
        }

        scanner.close();
    }
}
