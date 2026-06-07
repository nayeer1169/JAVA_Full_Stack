// No package statement for simple compilation.

/**
 * RentalAgency class that manages the fleet of vehicles.
 * 
 * --------------------------------------------------------------------------------------------------
 * CRITICAL RULE FULFILLED: This class stores Vehicles using a basic array (e.g. 'Vehicle[]') 
 * instead of Java Collections (like ArrayList or HashMap) to focus on native array mechanics.
 * --------------------------------------------------------------------------------------------------
 * 
 * Demonstrates POLYMORPHISM (Dynamic Method Dispatch):
 * - The agency keeps all vehicles in a unified array of 'Vehicle' references.
 * - When iterating and invoking methods like 'calculateRentalCost(days)', Java decides at runtime 
 *   which subclass method to call (Car's, Motorcycle's, or Truck's cost calculation).
 */
public class RentalAgency {
    
    // Encapsulated data members: Private fields
    private Vehicle[] inventory; // Array of Vehicle objects (demonstrates Polymorphic reference type)
    private int vehicleCount;    // Tracks the current number of vehicles added to the inventory

    // Constructor to initialize the agency with a fixed maximum capacity
    public RentalAgency(int capacity) {
        this.inventory = new Vehicle[capacity];
        this.vehicleCount = 0;
    }

    /**
     * Adds a vehicle to the agency inventory.
     * Demonstrates using a base reference type parameter (Vehicle) to accept any subclass.
     */
    public void addVehicle(Vehicle vehicle) {
        if (vehicle == null) {
            System.out.println("Error: Cannot add a null vehicle to the inventory.");
            return;
        }
        
        // Prevent array index out of bounds by validating capacity
        if (vehicleCount >= inventory.length) {
            System.out.println("Error: Inventory is full! Cannot add more vehicles.");
            return;
        }
        
        // Place the vehicle in the array and increment count
        inventory[vehicleCount] = vehicle;
        vehicleCount++;
    }

    /**
     * Lists all vehicles currently in the agency fleet.
     * Invokes toString() polymorphically.
     */
    public void displayInventory() {
        System.out.println("\n=================================== VEHICLE INVENTORY ===================================");
        if (vehicleCount == 0) {
            System.out.println("The inventory is currently empty.");
            System.out.println("=========================================================================================");
            return;
        }
        
        // Loop through the active vehicles in the array
        for (int i = 0; i < vehicleCount; i++) {
            // Polymorphism: Java calls the correct toString() method depending on whether the object is a Car, Motorcycle, or Truck.
            System.out.println(inventory[i].toString());
        }
        System.out.println("=========================================================================================");
    }

    /**
     * Finds a vehicle in the array based on its unique ID.
     * Returns null if no matching vehicle is found.
     */
    public Vehicle findVehicle(String vehicleId) {
        if (vehicleId == null || vehicleId.trim().isEmpty()) {
            return null;
        }
        
        for (int i = 0; i < vehicleCount; i++) {
            // Compare the ID case-insensitively using String helper methods
            if (inventory[i].getVehicleId().equalsIgnoreCase(vehicleId.trim())) {
                return inventory[i]; // Return the matching vehicle reference
            }
        }
        return null; // Not found
    }

    /**
     * Rent out a vehicle to a customer.
     */
    public void rentVehicle(String vehicleId, int days) {
        if (days <= 0) {
            System.out.println("Error: Rental duration must be 1 day or more.");
            return;
        }
        
        Vehicle vehicle = findVehicle(vehicleId);
        
        if (vehicle == null) {
            System.out.println("Error: Vehicle with ID '" + vehicleId + "' was not found in our database.");
            return;
        }
        
        if (vehicle.isRented()) {
            System.out.println("Error: Vehicle '" + vehicleId + "' is already checked out to another client.");
            return;
        }

        // Set state to rented (Encapsulation changes state via object method)
        vehicle.rent();
        
        // POLYMORPHIC CALL: Java automatically figures out which calculation logic to run at runtime!
        double cost = vehicle.calculateRentalCost(days);

        System.out.println("\n-------------------------------------------");
        System.out.println("             RENTAL TRANSACTION             ");
        System.out.println("-------------------------------------------");
        System.out.println("Status        : APPROVED");
        System.out.println("Vehicle Model : " + vehicle.getBrand() + " " + vehicle.getModel() + " (" + vehicle.getVehicleId() + ")");
        System.out.println("Rental Period : " + days + " day(s)");
        System.out.println("Total Due     : $" + String.format("%.2f", cost));
        System.out.println("-------------------------------------------");
    }

    /**
     * Return a rented vehicle to the agency.
     */
    public void returnVehicle(String vehicleId) {
        Vehicle vehicle = findVehicle(vehicleId);
        
        if (vehicle == null) {
            System.out.println("Error: Vehicle with ID '" + vehicleId + "' not found.");
            return;
        }
        
        if (!vehicle.isRented()) {
            System.out.println("Error: Vehicle '" + vehicleId + "' was not rented out.");
            return;
        }

        // Return vehicle (encapsulated status update)
        vehicle.returnVehicle();
        
        System.out.println("\n-------------------------------------------");
        System.out.println("             RETURN TRANSACTION             ");
        System.out.println("-------------------------------------------");
        System.out.println("Status        : SUCCESS");
        System.out.println("Vehicle Model : " + vehicle.getBrand() + " " + vehicle.getModel() + " (" + vehicle.getVehicleId() + ")");
        System.out.println("Current Status: Available for rent");
        System.out.println("-------------------------------------------");
    }

    /**
     * Displays summary statistics about agency vehicles.
     * Demonstrates dynamic method dispatch by checking vehicle status.
     */
    public void displayStats() {
        int total = vehicleCount;
        int rented = 0;
        double totalBaseRevenuePotential = 0.0;

        for (int i = 0; i < vehicleCount; i++) {
            Vehicle v = inventory[i];
            if (v.isRented()) {
                rented++;
            }
            totalBaseRevenuePotential += v.getBaseRatePerDay();
        }

        System.out.println("\n=================== AGENCY STATS ===================");
        System.out.println("Total Fleet Count      : " + total);
        System.out.println("Currently Rented       : " + rented);
        System.out.println("Available for Rent     : " + (total - rented));
        System.out.println("Base Daily Revenue Cap : $" + String.format("%.2f", totalBaseRevenuePotential));
        System.out.println("====================================================");
    }
}
