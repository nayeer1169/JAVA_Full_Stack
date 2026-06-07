// No package statement for simple compilation.

// The 'extends' keyword demonstrates INHERITANCE.
// Truck inherits all properties and methods of the Vehicle base class.
public class Truck extends Vehicle {

    // Encapsulation: Subclass-specific private property (cargo capacity in tons)
    private double cargoCapacity;

    // Subclass constructor
    public Truck(String vehicleId, String brand, String model, double baseRatePerDay, double cargoCapacity) {
        // Calls the constructor of the parent class (Vehicle).
        super(vehicleId, brand, model, baseRatePerDay);
        
        // We use the setter method to run validation checks.
        setCargoCapacity(cargoCapacity);
    }

    // Getter for cargo capacity (Encapsulation)
    public double getCargoCapacity() {
        return cargoCapacity;
    }

    // Setter for cargo capacity with validation check (Encapsulation)
    public void setCargoCapacity(double cargoCapacity) {
        if (cargoCapacity >= 0) {
            this.cargoCapacity = cargoCapacity;
        } else {
            System.out.println("Warning: Cargo capacity cannot be negative. Setting capacity to 0.0 tons.");
            this.cargoCapacity = 0.0;
        }
    }

    // Overriding the abstract method. Demonstrates POLYMORPHISM.
    // Surcharge logic specific to Trucks: adds a surcharge of $20.00 per ton per day.
    @Override
    public double calculateRentalCost(int days) {
        if (days < 0) {
            return 0.0;
        }
        double baseCost = getBaseRatePerDay() * days;
        double capacitySurcharge = cargoCapacity * 20.00 * days;
        return baseCost + capacitySurcharge;
    }

    // Overriding toString to append Truck-specific details.
    @Override
    public String toString() {
        return super.toString() + String.format(" | Type: Truck      | Capacity: %.1f Tons (+$%.2f/day)", cargoCapacity, (cargoCapacity * 20.00));
    }
}
