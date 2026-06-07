// No package statement to make compilation simple.

// The 'extends' keyword demonstrates INHERITANCE.
// Car inherits all fields and methods of the Vehicle base class (e.g., brand, model, baseRatePerDay).
public class Car extends Vehicle {
    
    // Encapsulation: Subclass-specific private property
    private boolean hasInsurance;

    // Subclass constructor
    public Car(String vehicleId, String brand, String model, double baseRatePerDay, boolean hasInsurance) {
        // 'super' refers to the constructor of the parent class (Vehicle).
        // It initializes the fields inherited from Vehicle.
        super(vehicleId, brand, model, baseRatePerDay);
        this.hasInsurance = hasInsurance;
    }

    // Getter for hasInsurance (Encapsulation)
    public boolean hasInsurance() {
        return hasInsurance;
    }

    // Setter for hasInsurance (Encapsulation)
    public void setInsurance(boolean hasInsurance) {
        this.hasInsurance = hasInsurance;
    }

    // Override annotation lets the compiler verify that we are correctly overriding a parent method.
    // This demonstrates POLYMORPHISM (specifically Method Overriding / Runtime Polymorphism).
    // The rental agency will call this method on a Vehicle reference, and Java will call the Car's version at runtime.
    @Override
    public double calculateRentalCost(int days) {
        if (days < 0) {
            return 0.0;
        }
        
        // Use 'getBaseRatePerDay()' (getter) to access the private field of the parent class.
        double baseCost = getBaseRatePerDay() * days;
        
        // Surcharge logic specific to cars: add $15.00 per day if insurance is opted in.
        double insuranceCost = hasInsurance ? (15.00 * days) : 0.0;
        
        return baseCost + insuranceCost;
    }

    // Overriding toString to append Car-specific details to the parent class's string format.
    @Override
    public String toString() {
        // 'super.toString()' calls the parent class's toString() implementation.
        return super.toString() + String.format(" | Type: Car        | Insurance: %s", (hasInsurance ? "Yes (+$15.00/day)" : "No"));
    }
}
